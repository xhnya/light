package com.xhn.light.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.admin.entity.CountEntity;
import com.xhn.light.admin.service.CountService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 统计表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 01:59:05
 */
@RestController
@RequestMapping("admin/count")
public class CountController {
    @Autowired
    private CountService countService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("admin:count:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = countService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("admin:count:info")
    public Result info(@PathVariable("id") Long id){
		CountEntity count = countService.getById(id);

        return Result.ok().data("count", count);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:count:save")
    public Result save(@RequestBody CountEntity count){
		countService.save(count);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:count:update")
    public Result update(@RequestBody CountEntity count){
		countService.updateById(count);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:count:delete")
    public Result delete(@RequestBody Long[] ids){
		countService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
