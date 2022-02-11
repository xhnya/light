package com.xhn.light.admin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.admin.entity.BannerEntity;
import com.xhn.light.admin.service.BannerService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 首页banner管理
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-20 20:37:25
 */
@Slf4j
@RestController
@RequestMapping("admin/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("admin:banner:list")
    public Result list(@RequestParam Map<String, Object> params){
        log.info("=============="+params);
        PageUtils page = bannerService.queryPage(params);
        return Result.ok().data("page", page);
    }
    /**
     * 列表
     */
    @GetMapping("/bannerList")
    //@RequiresPermissions("admin:banner:list")
    public Result bannerList(){
        QueryWrapper<BannerEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("start",0);
        wrapper.orderByDesc("sort");
        List<BannerEntity> result = bannerService.list(wrapper);
        return Result.ok().data("bannerList", result);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("admin:banner:info")
    public Result info(@PathVariable("id") Long id){
		BannerEntity banner = bannerService.getById(id);

        return Result.ok().data("banner", banner);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:banner:save")
    public Result save(@RequestBody BannerEntity banner){
        bannerService.save(banner);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:banner:update")
    public Result update(@RequestBody BannerEntity banner){
		bannerService.updateById(banner);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:banner:delete")
    public Result delete(@RequestBody Long[] ids){
		bannerService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
