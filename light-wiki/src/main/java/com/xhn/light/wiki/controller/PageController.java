package com.xhn.light.wiki.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.wiki.entity.PageEntity;
import com.xhn.light.wiki.service.PageService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 页面内容
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@RestController
@RequestMapping("wiki/page")
public class PageController {
    @Autowired
    private PageService pageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("wiki:page:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = pageService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("wiki:page:info")
    public Result info(@PathVariable("id") Long id){
		PageEntity page = pageService.getById(id);

        return Result.ok().data("page", page);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("wiki:page:save")
    public Result save(@RequestBody PageEntity page){
		pageService.save(page);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("wiki:page:update")
    public Result update(@RequestBody PageEntity page){
		pageService.updateById(page);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("wiki:page:delete")
    public Result delete(@RequestBody Long[] ids){
		pageService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
