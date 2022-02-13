package com.xhn.light.community.controller;

import com.xhn.light.common.utils.Result;
import com.xhn.light.community.entity.vo.IndexHotPageList;
import com.xhn.light.community.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xhn
 * @date 2022/2/13 13:37
 * @description: 首页的社区列表的请求的处理
 */
@Slf4j
@RestController
@RequestMapping("community/index")
public class IndexController {
    @Autowired
    private ArticleService articleService;

    /**
     * 首页的中间部分展示
     * @return
     */
    @GetMapping("/indexHotPageList")
    public Result IndexHotPageList() {
        List<IndexHotPageList> result=articleService.selectIndexHotPageList();
        return Result.ok().data("result",result);
    }

}
