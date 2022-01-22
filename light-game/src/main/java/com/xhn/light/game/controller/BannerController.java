package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.BannerEntity;
import com.xhn.light.game.service.BannerService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏详情banner图
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:14:59
 */
@RestController
@RequestMapping("game/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:banner:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = bannerService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:banner:info")
    public Result info(@PathVariable("id") Long id){
		BannerEntity banner = bannerService.getById(id);

        return Result.ok().data("banner", banner);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:banner:save")
    public Result save(@RequestBody BannerEntity banner){
		bannerService.save(banner);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:banner:update")
    public Result update(@RequestBody BannerEntity banner){
		bannerService.updateById(banner);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:banner:delete")
    public Result delete(@RequestBody Long[] ids){
		bannerService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
