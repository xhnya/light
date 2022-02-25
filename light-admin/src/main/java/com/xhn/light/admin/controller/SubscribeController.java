package com.xhn.light.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.admin.entity.SubscribeEntity;
import com.xhn.light.admin.service.SubscribeService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 邮件订阅表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 01:59:05
 */
@RestController
@RequestMapping("admin/subscribe")
public class SubscribeController {
    @Autowired
    private SubscribeService subscribeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("admin:subscribe:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = subscribeService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("admin:subscribe:info")
    public Result info(@PathVariable("id") Long id){
		SubscribeEntity subscribe = subscribeService.getById(id);

        return Result.ok().data("subscribe", subscribe);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:subscribe:save")
    public Result save(@RequestBody SubscribeEntity subscribe){
		subscribeService.save(subscribe);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:subscribe:update")
    public Result update(@RequestBody SubscribeEntity subscribe){
		subscribeService.updateById(subscribe);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:subscribe:delete")
    public Result delete(@RequestBody Long[] ids){
		subscribeService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
