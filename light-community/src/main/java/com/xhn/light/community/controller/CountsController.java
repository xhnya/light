package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.community.entity.CountsEntity;
import com.xhn.light.community.service.CountsService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 文章统计表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@RestController
@RequestMapping("community/counts")
public class CountsController {
    @Autowired
    private CountsService countsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:counts:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = countsService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:counts:info")
    public Result info(@PathVariable("id") Long id){
		CountsEntity counts = countsService.getById(id);

        return Result.ok().data("counts", counts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:counts:save")
    public Result save(@RequestBody CountsEntity counts){
		countsService.save(counts);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:counts:update")
    public Result update(@RequestBody CountsEntity counts){
		countsService.updateById(counts);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:counts:delete")
    public Result delete(@RequestBody Long[] ids){
		countsService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
