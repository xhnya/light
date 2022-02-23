package com.xhn.light.search.controller;

import com.xhn.light.common.utils.Result;
import com.xhn.light.search.service.ElasticSearchService;
import com.xhn.light.search.vo.SearchParams;
import com.xhn.light.search.vo.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/23 17:29
 * @description：
 */
@Slf4j
@RequestMapping(value = "/search/search")
@RestController
public class ElasticSearchController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping()
    public Result esSearch(SearchParams params, HttpServletRequest request){
        params.set_queryString(request.getQueryString());
        log.info(String.valueOf(params));
        SearchResult result=elasticSearchService.esSearch(params);
        return Result.ok().data("result",result);

    }

}
