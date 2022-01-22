package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.TypeEntity;
import com.xhn.light.game.service.TypeService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏类型表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@RestController
@RequestMapping("game/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:type:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = typeService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:type:info")
    public Result info(@PathVariable("id") Long id){
		TypeEntity type = typeService.getById(id);

        return Result.ok().data("type", type);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:type:save")
    public Result save(@RequestBody TypeEntity type){
		typeService.save(type);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:type:update")
    public Result update(@RequestBody TypeEntity type){
		typeService.updateById(type);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:type:delete")
    public Result delete(@RequestBody Long[] ids){
		typeService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
