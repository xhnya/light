package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.AtlasEntity;
import com.xhn.light.game.service.AtlasService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏图集
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:15
 */
@RestController
@RequestMapping("game/atlas")
public class AtlasController {
    @Autowired
    private AtlasService atlasService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:atlas:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = atlasService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:atlas:info")
    public Result info(@PathVariable("id") Long id){
		AtlasEntity atlas = atlasService.getById(id);

        return Result.ok().data("atlas", atlas);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:atlas:save")
    public Result save(@RequestBody AtlasEntity atlas){
		atlasService.save(atlas);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:atlas:update")
    public Result update(@RequestBody AtlasEntity atlas){
		atlasService.updateById(atlas);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:atlas:delete")
    public Result delete(@RequestBody Long[] ids){
		atlasService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
