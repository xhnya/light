package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.game.entity.vo.GameRankList;
import com.xhn.light.game.entity.vo.RankAdminListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.game.entity.RankEntity;
import com.xhn.light.game.service.RankService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;


/**
 * 游戏排行榜
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
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
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = rankService.queryPage(params);

        return Result.ok().data("page", page);
    }

    /**
     * 获取排行列表后台管理的
     *
     * @param type 榜单类型
     * @return
     */
    @GetMapping("/getRankList")
    public Result getRankAdminList(@RequestParam Integer type) {
        List<RankAdminListVo> result = rankService.getRankAdminList(type);

        return Result.ok().data("rankList", result);
    }

    /**
     * 首页的榜单显示
     * @param type
     * @return
     */
    @GetMapping("/getHotGameRankList")
    public Result getHotGameRankList(@RequestParam Integer type) {
        List<GameRankList> result = rankService.getHotGameRankList(type);
        return Result.ok().data("rankList", result);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:rank:info")
    public Result info(@PathVariable("id") Long id) {
        RankEntity rank = rankService.getById(id);

        return Result.ok().data("rank", rank);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:rank:save")
    public Result save(@RequestBody RankEntity rank) {
//        QueryWrapper<RankEntity> wrapper = new QueryWrapper<>();
//        wrapper.eq("type",rank.getType());
//        long count = rankService.count(wrapper);
//        if (count<=0){
//
//        }else {
//            return Result.error("最多10个");
//        }
        rankService.save(rank);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:rank:update")
    public Result update(@RequestBody RankEntity rank) {
        rankService.updateById(rank);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:rank:delete")
    public Result delete(@RequestBody Long[] ids) {
        rankService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
