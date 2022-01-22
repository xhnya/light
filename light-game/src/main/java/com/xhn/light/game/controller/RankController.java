package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.RankEntity;
import com.xhn.light.game.service.RankService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏排行榜
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:15:00
 */
@RestController
@RequestMapping("game/rank")
public class RankController {
    @Autowired
    private RankService rankService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:rank:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = rankService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:rank:info")
    public Result info(@PathVariable("id") Long id){
		RankEntity rank = rankService.getById(id);

        return Result.ok().data("rank", rank);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:rank:save")
    public Result save(@RequestBody RankEntity rank){
		rankService.save(rank);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:rank:update")
    public Result update(@RequestBody RankEntity rank){
		rankService.updateById(rank);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:rank:delete")
    public Result delete(@RequestBody Long[] ids){
		rankService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
