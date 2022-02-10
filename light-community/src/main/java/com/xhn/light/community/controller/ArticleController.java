package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.Map;

import com.xhn.light.community.entity.vo.ArticleAdminListQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.community.entity.ArticleEntity;
import com.xhn.light.community.service.ArticleService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 社区文章表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Slf4j
@RestController
@RequestMapping("community/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:article:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = articleService.queryPage(params);

        return Result.ok().data("page", page);
    }
    /**
     * 页面的列表，管理后台
     */
    @GetMapping("/pageAdminList")
    //@RequiresPermissions("community:article:list")
    public Result pageAdminList( ArticleAdminListQueryVo params){
        PageUtils page = articleService.selectPageAdminList(params);
        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:article:info")
    public Result info(@PathVariable("id") Long id){
		ArticleEntity article = articleService.getById(id);

        return Result.ok().data("article", article);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:article:save")
    public Result save(@RequestBody ArticleEntity article){
		articleService.save(article);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:article:update")
    public Result update(@RequestBody ArticleEntity article){
		articleService.updateById(article);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:article:delete")
    public Result delete(@RequestBody Long[] ids){
		articleService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
