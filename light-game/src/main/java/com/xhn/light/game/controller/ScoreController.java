package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xhn.light.game.entity.vo.ScoreViewForIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.game.entity.ScoreEntity;
import com.xhn.light.game.service.ScoreService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏评分表

 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@RestController
@RequestMapping("game/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:score:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = scoreService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:score:info")
    public Result info(@PathVariable("id") Long id){
		ScoreEntity score = scoreService.getById(id);

        return Result.ok().data("score", score);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:score:save")
    public Result save(@RequestBody ScoreEntity score){
		scoreService.save(score);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:score:update")
    public Result update(@RequestBody ScoreEntity score){
		scoreService.updateById(score);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:score:delete")
    public Result delete(@RequestBody Long[] ids){
		scoreService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    /**
     * 资讯页的游戏评测
     * @return
     */
    @GetMapping("getEvaluating")
    public Result getEvaluating() {
        List<ScoreViewForIndex> result =scoreService.getEvaluating();
        return Result.ok().data("result",result);
    }

}
