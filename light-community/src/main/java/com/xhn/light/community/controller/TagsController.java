package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.community.entity.TagsEntity;
import com.xhn.light.community.service.TagsService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 标签表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@RestController
@RequestMapping("community/tags")
public class TagsController {
    @Autowired
    private TagsService tagsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:tags:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = tagsService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:tags:info")
    public Result info(@PathVariable("id") Long id){
		TagsEntity tags = tagsService.getById(id);

        return Result.ok().data("tags", tags);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:tags:save")
    public Result save(@RequestBody TagsEntity tags){
		tagsService.save(tags);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:tags:update")
    public Result update(@RequestBody TagsEntity tags){
		tagsService.updateById(tags);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:tags:delete")
    public Result delete(@RequestBody Long[] ids){
		tagsService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
