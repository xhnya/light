package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.SeriesEntity;
import com.xhn.light.game.service.SeriesService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏同系列
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@RestController
@RequestMapping("game/series")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:series:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = seriesService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:series:info")
    public Result info(@PathVariable("id") Long id){
		SeriesEntity series = seriesService.getById(id);

        return Result.ok().data("series", series);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:series:save")
    public Result save(@RequestBody SeriesEntity series){
		seriesService.save(series);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:series:update")
    public Result update(@RequestBody SeriesEntity series){
		seriesService.updateById(series);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:series:delete")
    public Result delete(@RequestBody Long[] ids){
		seriesService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
