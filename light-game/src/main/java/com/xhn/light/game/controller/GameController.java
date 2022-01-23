package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.service.GameService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@RestController
@RequestMapping("game/game")
public class GameController {
    @Autowired
    private GameService gameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:game:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = gameService.queryPage(params);

        return Result.ok().data("page", page);
    }
//    /**
//     * 获取列表
//     */
//    @RequestMapping("/gameList")
//    //@RequiresPermissions("game:game:list")
//    public Result gameList(@RequestParam Map<String, Object> params){
//        gameService
//
//        return Result.ok().data("page", page);
//    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:game:info")
    public Result info(@PathVariable("id") Long id){
		GameEntity game = gameService.getById(id);

        return Result.ok().data("game", game);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:game:save")
    public Result save(@RequestBody GameEntity game){
		gameService.save(game);
        return Result.ok().data("gameId",game.getId());
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:game:update")
    public Result update(@RequestBody GameEntity game){
		gameService.updateById(game);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:game:delete")
    public Result delete(@RequestBody Long[] ids){
		gameService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
