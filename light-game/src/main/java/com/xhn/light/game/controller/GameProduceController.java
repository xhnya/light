package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.GameProduceEntity;
import com.xhn.light.game.service.GameProduceService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏产商的游戏
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:15
 */
@RestController
@RequestMapping("game/gameproduce")
public class GameProduceController {
    @Autowired
    private GameProduceService gameProduceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:gameproduce:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = gameProduceService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:gameproduce:info")
    public Result info(@PathVariable("id") Long id){
		GameProduceEntity gameProduce = gameProduceService.getById(id);

        return Result.ok().data("gameProduce", gameProduce);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:gameproduce:save")
    public Result save(@RequestBody GameProduceEntity gameProduce){
		gameProduceService.save(gameProduce);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:gameproduce:update")
    public Result update(@RequestBody GameProduceEntity gameProduce){
		gameProduceService.updateById(gameProduce);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:gameproduce:delete")
    public Result delete(@RequestBody Long[] ids){
		gameProduceService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
