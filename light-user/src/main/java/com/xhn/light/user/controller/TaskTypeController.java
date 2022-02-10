package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.TaskTypeEntity;
import com.xhn.light.user.service.TaskTypeService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 任务类型表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/tasktype")
public class TaskTypeController {
    @Autowired
    private TaskTypeService taskTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:tasktype:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = taskTypeService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:tasktype:info")
    public Result info(@PathVariable("id") Long id){
		TaskTypeEntity taskType = taskTypeService.getById(id);

        return Result.ok().data("taskType", taskType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:tasktype:save")
    public Result save(@RequestBody TaskTypeEntity taskType){
		taskTypeService.save(taskType);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:tasktype:update")
    public Result update(@RequestBody TaskTypeEntity taskType){
		taskTypeService.updateById(taskType);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:tasktype:delete")
    public Result delete(@RequestBody Long[] ids){
		taskTypeService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
