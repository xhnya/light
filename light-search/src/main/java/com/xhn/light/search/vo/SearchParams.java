package com.xhn.light.search.vo;

import lombok.Data;

/**
 * @author ：xhn
 * @date ：2022/2/23 17:12
 * @description： 页面传递的查询参数
 */
@Data
public class SearchParams {


    /**
     * 页面传递过来的全文匹配关键字
     */
    private String keyword;

    /**
     * 选择是用户，游戏还是文章
     */
    private String typeSearch;
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 原生的所有查询条件
     */
    private String _queryString;

    /**
     * 排序条件：sort=/hotscore_desc/asc
     */
    private String sort;

}
