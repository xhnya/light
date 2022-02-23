package com.xhn.light.search.vo;

import com.xhn.light.common.es.ElasticSearchModel;
import lombok.Data;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/23 17:26
 * @description：
 */
@Data
public class SearchResult {

    private List<ElasticSearchModel> model;

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 总记录数
     */
    private Long total;


    /**
     * 总页码
     */
    private Integer totalPages;

}
