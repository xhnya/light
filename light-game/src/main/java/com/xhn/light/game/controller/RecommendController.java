package com.xhn.light.game.controller;

import com.sun.xml.internal.bind.v2.TODO;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;
import com.xhn.light.game.entity.RecommendEntity;
import com.xhn.light.game.entity.vo.IdAndNameVo;
import com.xhn.light.game.entity.vo.RecommendListView;
import com.xhn.light.game.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
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

//    TODO: 游戏优惠应该有另外的一套逻辑
    @RequestMapping("/list")
    //@RequiresPermissions("game:game:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = recommendService.queryPage(params);

        return Result.ok().data("page", page);
    }
    @GetMapping("/listView")
    //@RequiresPermissions("game:game:list")
    public Result listView(@RequestParam Integer type) {
        List<RecommendListView> page=recommendService.listView(type);
        return Result.ok().data("page", page);
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:rank:delete")
    public Result delete(@RequestBody Long[] ids) {
        recommendService.removeByIds(Arrays.asList(ids));
        return Result.ok();
    }

    @GetMapping("/bannerList")
    public Result getBannerGame(@RequestParam Integer type){
        List<IdAndNameVo> result=recommendService.getBannerGame(type);
        return Result.ok().data("result",result);
    }



}
