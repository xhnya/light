package com.xhn.light.game.controller;

import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;
import com.xhn.light.game.entity.RecommendEntity;
import com.xhn.light.game.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xhn
 * @date 2022/2/13 21:21
 * @description: 游戏推荐
 */
@RestController
@RequestMapping("game/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @PostMapping("/add")
    public Result add(@RequestBody RecommendEntity recommend){
        recommendService.save(recommend);
        return Result.ok();
    }

    @RequestMapping("/list")
    //@RequiresPermissions("game:game:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = recommendService.queryPage(params);

        return Result.ok().data("page", page);
    }


}
