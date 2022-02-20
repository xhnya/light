package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.HistoryEntity;
import com.xhn.light.user.service.HistoryService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 用户历史表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 11:42:28
 */
@RestController
@RequestMapping("user/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:history:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = historyService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:history:info")
    public Result info(@PathVariable("id") Long id){
		HistoryEntity history = historyService.getById(id);

        return Result.ok().data("history", history);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:history:save")
    public Result save(@RequestBody HistoryEntity history){
		historyService.save(history);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:history:update")
    public Result update(@RequestBody HistoryEntity history){
		historyService.updateById(history);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:history:delete")
    public Result delete(@RequestBody Long[] ids){
		historyService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
