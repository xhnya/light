package com.xhn.light.search.service;

import com.xhn.light.common.es.ElasticSearchModel;

import java.io.IOException;

/**
 * @author xhn
 * @date 2022/2/22 22:17
 * @description:
 */
public interface ElasticSaveService {


    public void esSave(ElasticSearchModel model) throws IOException;


}
