package com.xhn.light.search.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.xhn.light.common.es.ElasticSearchModel;
import com.xhn.light.search.config.LightElasticSearchConfig;
import com.xhn.light.search.constant.EsConstant;
import com.xhn.light.search.service.ElasticSaveService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xhn
 * @date 2022/2/22 22:17
 * @description:
 */
@Slf4j
@Service
public class ElasticSaveServiceImpl implements ElasticSaveService {


    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public void esSave(ElasticSearchModel model) throws IOException {
        //保存到es,建立映射关系
        //在es中保存
        BulkRequest bulkRequest = new BulkRequest();
        IndexRequest request = new IndexRequest(EsConstant.LIGHT_INDEX);


        String s = JSON.toJSONString(model);
        request.source(s, XContentType.JSON);
        bulkRequest.add(request);

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, LightElasticSearchConfig.COMMON_OPTIONS);
        boolean b = bulk.hasReferences();
        List<String> collect = Arrays.asList(bulk.getItems()).stream().map(item -> {
            return item.getId();
        }).collect(Collectors.toList());

        log.info("ElasticSearch：{}",collect);


    }
}
