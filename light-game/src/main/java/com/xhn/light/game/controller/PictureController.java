package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.PictureEntity;
import com.xhn.light.game.service.PictureService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏图片
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@RestController
@RequestMapping("game/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:picture:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = pictureService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:picture:info")
    public Result info(@PathVariable("id") Long id){
		PictureEntity picture = pictureService.getById(id);

        return Result.ok().data("picture", picture);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:picture:save")
    public Result save(@RequestBody PictureEntity picture){
		pictureService.save(picture);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:picture:update")
    public Result update(@RequestBody PictureEntity picture){
		pictureService.updateById(picture);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:picture:delete")
    public Result delete(@RequestBody Long[] ids){
		pictureService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
