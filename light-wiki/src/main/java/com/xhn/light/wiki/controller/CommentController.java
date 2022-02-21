package com.xhn.light.wiki.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.wiki.entity.CommentEntity;
import com.xhn.light.wiki.service.CommentService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 页面评论
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@RestController
@RequestMapping("wiki/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("wiki:comment:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = commentService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("wiki:comment:info")
    public Result info(@PathVariable("id") Long id){
		CommentEntity comment = commentService.getById(id);

        return Result.ok().data("comment", comment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("wiki:comment:save")
    public Result save(@RequestBody CommentEntity comment){
		commentService.save(comment);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("wiki:comment:update")
    public Result update(@RequestBody CommentEntity comment){
		commentService.updateById(comment);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("wiki:comment:delete")
    public Result delete(@RequestBody Long[] ids){
		commentService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
