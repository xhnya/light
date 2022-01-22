package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.AwardEntity;
import com.xhn.light.game.service.AwardService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 奖项
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@RestController
@RequestMapping("game/award")
public class AwardController {
    @Autowired
    private AwardService awardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:award:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = awardService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:award:info")
    public Result info(@PathVariable("id") Long id){
		AwardEntity award = awardService.getById(id);

        return Result.ok().data("award", award);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:award:save")
    public Result save(@RequestBody AwardEntity award){
		awardService.save(award);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:award:update")
    public Result update(@RequestBody AwardEntity award){
		awardService.updateById(award);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:award:delete")
    public Result delete(@RequestBody Long[] ids){
		awardService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
