package com.xhn.light.search.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xhn
 * @date 2022/2/22 21:46
 * @description: 数据保存
 * {
 * id: 文章，用户，游戏的id，，，Long
 * name: 名称，text
 * type: 用户0，游戏1，文章2,keyword
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





}
