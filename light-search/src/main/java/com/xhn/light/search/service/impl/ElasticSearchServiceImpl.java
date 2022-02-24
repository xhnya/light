package com.xhn.light.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.xhn.light.common.es.ElasticSearchModel;
import com.xhn.light.common.utils.StringUtils;
import com.xhn.light.search.config.LightElasticSearchConfig;
import com.xhn.light.search.constant.EsConstant;
import com.xhn.light.search.service.ElasticSearchService;
import com.xhn.light.search.vo.SearchParams;
import com.xhn.light.search.vo.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/23 17:30
 * @description：
 */
@Slf4j
@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    private RestHighLevelClient esRestClient;

    @Override
    public SearchResult esSearch(SearchParams params) {
        SearchResult result = null;
        SearchRequest searchRequest = buildSearchRequest(params);
        try {
            //2、执行检索请求
            SearchResponse response = esRestClient.search(searchRequest, LightElasticSearchConfig.COMMON_OPTIONS);

            //3、分析响应数据，封装成我们需要的格式
            result = buildSearchResult(response, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public SearchResult hotGame(SearchParams params) {
//        CountRequest  result = null;
//        CountRequest  countRequest  = buildHotGameRequest(params);
//        try {
//            //2、执行检索请求
//            CountResponse response = esRestClient.count(countRequest, LightElasticSearchConfig.COMMON_OPTIONS);
//            //3、分析响应数据，封装成我们需要的格式
//            result = buildSearchResult(response, params);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
        return null;
    }

    /**
     * 构建结果数据
     * 模糊匹配，完成排序、分页、高亮,聚合分析功能
     *
     * @param response
     * @return
     */
    private SearchResult buildSearchResult(SearchResponse response, SearchParams param) {

        SearchResult result = new SearchResult();

        //返回的所有查询到
        SearchHits hits = response.getHits();

        List<ElasticSearchModel> esModels = new ArrayList<>();
        //遍历所有信息
        if (hits.getHits() != null && hits.getHits().length > 0) {
            for (SearchHit hit : hits.getHits()) {
                String sourceAsString = hit.getSourceAsString();
                ElasticSearchModel esModel = JSON.parseObject(sourceAsString, ElasticSearchModel.class);

                //判断是否按关键字检索，若是就显示高亮，否则不显示
                if (!StringUtils.isEmpty(param.getKeyword())) {
                    //拿到高亮信息显示标题
                    HighlightField skuTitle = hit.getHighlightFields().get("name");
                    String nameSearch = skuTitle.getFragments()[0].string();
                    esModel.setName(nameSearch);
                }
                esModels.add(esModel);
            }
        }
        result.setModel(esModels);

        //===============以上可以从聚合信息中获取====================//
        //分页信息-页码
        result.setPageNum(param.getPageNum());
        //1分页信息、总记录数
        long total = hits.getTotalHits().value;
        result.setTotal(total);

        //2分页信息-总页码-计算
        int totalPages = (int) total % EsConstant.PRODUCT_PAGESIZE == 0 ?
                (int) total / EsConstant.PRODUCT_PAGESIZE : ((int) total / EsConstant.PRODUCT_PAGESIZE + 1);
        result.setTotalPages(totalPages);

        return result;
    }

    /**
     * 准备检索请求
     * 模糊匹配，过滤（按照属性，分类，品牌，价格区间，库存），排序，分页，高亮，聚合分析
     *
     * @return
     */
    private SearchRequest buildSearchRequest(SearchParams param) {

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        /**
         * 模糊匹配，过滤
         */
        //1. 构建bool-query
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        //1.1 bool-must
        if (!StringUtils.isEmpty(param.getKeyword())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", param.getKeyword()));
        }

        //1.2
        //1.2.1
        if (null != param.getTypeSearch()) {
            boolQueryBuilder.filter(QueryBuilders.termQuery("typeSearch", param.getTypeSearch()));
        }

        //封装所有的查询条件
        searchSourceBuilder.query(boolQueryBuilder);

        /**
         * 排序，分页，高亮
         */

        //排序
        //形式为sort=hotScore_asc/desc
        if (!StringUtils.isEmpty(param.getSort())) {
            String sort = param.getSort();
            String[] sortFileds = sort.split("_");
            SortOrder sortOrder = "asc".equalsIgnoreCase(sortFileds[1]) ? SortOrder.ASC : SortOrder.DESC;
            searchSourceBuilder.sort(sortFileds[0], sortOrder);
        }

        //分页
        searchSourceBuilder.from((param.getPageNum() - 1) * EsConstant.PRODUCT_PAGESIZE);
        searchSourceBuilder.size(EsConstant.PRODUCT_PAGESIZE);

        //高亮
        if (!StringUtils.isEmpty(param.getKeyword())) {

            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("name");
            highlightBuilder.preTags("<b style='color:red'>");
            highlightBuilder.postTags("</b>");
            searchSourceBuilder.highlighter(highlightBuilder);
        }

        log.debug("构建的DSL语句 {}", searchSourceBuilder.toString());

        SearchRequest searchRequest = new SearchRequest(new String[]{EsConstant.LIGHT_INDEX}, searchSourceBuilder);

        return searchRequest;
    }

    /**
     * 构建热门游戏排行
     * @param param
     * @return
     */
    private CountRequest buildHotGameRequest(SearchParams param) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.filter(QueryBuilders.termQuery("typeSearch", 1));
        searchSourceBuilder.query(boolQueryBuilder);
        if (!StringUtils.isEmpty(param.getSort())) {
            String sort = param.getSort();
            String[] sortFileds = sort.split("_");
            SortOrder sortOrder = "asc".equalsIgnoreCase(sortFileds[1]) ? SortOrder.ASC : SortOrder.DESC;
            searchSourceBuilder.sort(sortFileds[0], sortOrder);
        }
        //分页
        searchSourceBuilder.from((param.getPageNum() - 1) * EsConstant.PRODUCT_PAGESIZE);
        searchSourceBuilder.size(5);

        //高亮
        if (!StringUtils.isEmpty(param.getKeyword())) {

            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("name");
            highlightBuilder.preTags("<b style='color:red'>");
            highlightBuilder.postTags("</b>");
            searchSourceBuilder.highlighter(highlightBuilder);
        }

        log.debug("构建的DSL语句 {}", searchSourceBuilder.toString());
        CountRequest countRequest = new CountRequest(new String[]{EsConstant.LIGHT_INDEX}, searchSourceBuilder);
        return countRequest;
    }


}
