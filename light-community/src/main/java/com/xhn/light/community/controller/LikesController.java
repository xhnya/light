package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.community.entity.LikesEntity;
import com.xhn.light.community.service.LikesService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 文章点赞表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@RestController
@RequestMapping("community/likes")
public class LikesController {
    @Autowired
    private LikesService likesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:likes:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = likesService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:likes:info")
    public Result info(@PathVariable("id") Long id){
		LikesEntity likes = likesService.getById(id);

        return Result.ok().data("likes", likes);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:likes:save")
    public Result save(@RequestBody LikesEntity likes){
		likesService.save(likes);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:likes:update")
    public Result update(@RequestBody LikesEntity likes){
		likesService.updateById(likes);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:likes:delete")
    public Result delete(@RequestBody Long[] ids){
		likesService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
