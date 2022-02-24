package com.xhn.light.search.service;

import com.xhn.light.search.vo.SearchParams;
import com.xhn.light.search.vo.SearchResult;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/23 17:30
 * @description：
 */
public interface ElasticSearchService {
    SearchResult esSearch(SearchParams params);

    SearchResult hotGame(SearchParams params);
}
