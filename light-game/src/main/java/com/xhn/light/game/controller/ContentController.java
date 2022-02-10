package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.ContentEntity;
import com.xhn.light.game.service.ContentService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏评论表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@RestController
@RequestMapping("game/content")
public class
ContentController {
    @Autowired
    private ContentService contentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:content:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = contentService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:content:info")
    public Result info(@PathVariable("id") Long id){
		ContentEntity content = contentService.getById(id);

        return Result.ok().data("content", content);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:content:save")
    public Result save(@RequestBody ContentEntity content){
		contentService.save(content);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:content:update")
    public Result update(@RequestBody ContentEntity content){
		contentService.updateById(content);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:content:delete")
    public Result delete(@RequestBody Long[] ids){
		contentService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
