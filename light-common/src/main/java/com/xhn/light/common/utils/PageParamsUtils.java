package com.xhn.light.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/14 9:07
 * @description： 分页数据处理,初始化分页
 */
public class PageParamsUtils<T> {

    public Page getPage(Map<String, Object> params){
        //分页参数
        long curPage = 1;
        long limit = 10;
        if(params.get(Constant.PAGE) != null){
            curPage = Long.parseLong((String)params.get(Constant.PAGE));
        }
        if(params.get(Constant.LIMIT) != null){
            limit = Long.parseLong((String)params.get(Constant.LIMIT));
        }
        //分页对象
        return new Page<>(curPage, limit);
    }
}
