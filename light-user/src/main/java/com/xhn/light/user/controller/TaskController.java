package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.TaskEntity;
import com.xhn.light.user.service.TaskService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 用户任务表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:task:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = taskService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:task:info")
    public Result info(@PathVariable("id") Long id){
		TaskEntity task = taskService.getById(id);

        return Result.ok().data("task", task);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:task:save")
    public Result save(@RequestBody TaskEntity task){
		taskService.save(task);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:task:update")
    public Result update(@RequestBody TaskEntity task){
		taskService.updateById(task);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:task:delete")
    public Result delete(@RequestBody Long[] ids){
		taskService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
