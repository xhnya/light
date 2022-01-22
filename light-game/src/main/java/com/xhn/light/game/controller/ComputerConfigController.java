package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.ComputerConfigEntity;
import com.xhn.light.game.service.ComputerConfigService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏配置表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:15
 */
@RestController
@RequestMapping("game/computerconfig")
public class ComputerConfigController {
    @Autowired
    private ComputerConfigService computerConfigService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:computerconfig:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = computerConfigService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:computerconfig:info")
    public Result info(@PathVariable("id") Long id){
		ComputerConfigEntity computerConfig = computerConfigService.getById(id);

        return Result.ok().data("computerConfig", computerConfig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:computerconfig:save")
    public Result save(@RequestBody ComputerConfigEntity computerConfig){
		computerConfigService.save(computerConfig);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:computerconfig:update")
    public Result update(@RequestBody ComputerConfigEntity computerConfig){
		computerConfigService.updateById(computerConfig);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:computerconfig:delete")
    public Result delete(@RequestBody Long[] ids){
		computerConfigService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
