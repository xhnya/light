package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.LevelEntity;
import com.xhn.light.user.service.LevelService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 等级表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:level:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = levelService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:level:info")
    public Result info(@PathVariable("id") Long id){
		LevelEntity level = levelService.getById(id);

        return Result.ok().data("level", level);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:level:save")
    public Result save(@RequestBody LevelEntity level){
        return levelService.saveLevelEntity(level);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:level:update")
    public Result update(@RequestBody LevelEntity level){
		levelService.updateById(level);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:level:delete")
    public Result delete(@RequestBody Long[] ids){
		levelService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
