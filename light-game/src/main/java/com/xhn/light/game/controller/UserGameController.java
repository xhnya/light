package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.UserGameEntity;
import com.xhn.light.game.service.UserGameService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 用户关注的游戏
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 00:27:04
 */
@RestController
@RequestMapping("game/usergame")
public class UserGameController {
    @Autowired
    private UserGameService userGameService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:usergame:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userGameService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:usergame:info")
    public Result info(@PathVariable("id") Long id){
		UserGameEntity userGame = userGameService.getById(id);

        return Result.ok().data("userGame", userGame);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:usergame:save")
    public Result save(@RequestBody UserGameEntity userGame){
		userGameService.save(userGame);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:usergame:update")
    public Result update(@RequestBody UserGameEntity userGame){
		userGameService.updateById(userGame);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:usergame:delete")
    public Result delete(@RequestBody Long[] ids){
		userGameService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
