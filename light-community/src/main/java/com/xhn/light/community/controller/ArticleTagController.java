package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.community.entity.ArticleTagEntity;
import com.xhn.light.community.service.ArticleTagService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 文章标签
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@RestController
@RequestMapping("community/articletag")
public class ArticleTagController {
    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:articletag:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = articleTagService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:articletag:info")
    public Result info(@PathVariable("id") Long id){
		ArticleTagEntity articleTag = articleTagService.getById(id);

        return Result.ok().data("articleTag", articleTag);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:articletag:save")
    public Result save(@RequestBody ArticleTagEntity articleTag){
		articleTagService.save(articleTag);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:articletag:update")
    public Result update(@RequestBody ArticleTagEntity articleTag){
		articleTagService.updateById(articleTag);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:articletag:delete")
    public Result delete(@RequestBody Long[] ids){
		articleTagService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
