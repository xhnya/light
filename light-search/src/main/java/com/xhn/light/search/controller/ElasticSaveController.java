package com.xhn.light.search.controller;

import com.xhn.light.common.es.ElasticSearchModel;
import com.xhn.light.common.utils.Result;
import com.xhn.light.search.service.ElasticSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author xhn
 * @date 2022/2/22 21:46
 * @description: 数据保存
 * {
 * id: 文章，用户，游戏的id，，，Long
 * name: 名称，text
 * type: 用户0，游戏1，文章2,
 * attrs:{
 * 分类： "",
 * 类型: "",
 * 标签: "",
 * }
 * }
 */
@Slf4j
@RequestMapping(value = "/search/save")
@RestController
public class ElasticSaveController {

    @Autowired
    private ElasticSaveService elasticSaveService;

    @PostMapping()
    public Result saveEs(@RequestBody ElasticSearchModel model) throws IOException {
        elasticSaveService.esSave(model);
        return Result.ok();
    }


}
