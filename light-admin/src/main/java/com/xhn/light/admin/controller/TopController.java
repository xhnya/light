package com.xhn.light.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.admin.entity.TopEntity;
import com.xhn.light.admin.service.TopService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 顶部图
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 01:59:04
 */
@RestController
@RequestMapping("admin/top")
public class TopController {
    @Autowired
    private TopService topService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("admin:top:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = topService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("admin:top:info")
    public Result info(@PathVariable("id") Long id){
		TopEntity top = topService.getById(id);

        return Result.ok().data("top", top);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:top:save")
    public Result save(@RequestBody TopEntity top){
		topService.save(top);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:top:update")
    public Result update(@RequestBody TopEntity top){
		topService.updateById(top);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:top:delete")
    public Result delete(@RequestBody Long[] ids){
		topService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
