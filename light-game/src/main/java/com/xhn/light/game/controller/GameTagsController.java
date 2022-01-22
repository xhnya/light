package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.GameTagsEntity;
import com.xhn.light.game.service.GameTagsService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏标签对应表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@RestController
@RequestMapping("game/gametags")
public class GameTagsController {
    @Autowired
    private GameTagsService gameTagsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:gametags:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = gameTagsService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:gametags:info")
    public Result info(@PathVariable("id") Long id){
		GameTagsEntity gameTags = gameTagsService.getById(id);

        return Result.ok().data("gameTags", gameTags);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:gametags:save")
    public Result save(@RequestBody GameTagsEntity gameTags){
		gameTagsService.save(gameTags);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:gametags:update")
    public Result update(@RequestBody GameTagsEntity gameTags){
		gameTagsService.updateById(gameTags);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:gametags:delete")
    public Result delete(@RequestBody Long[] ids){
		gameTagsService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
