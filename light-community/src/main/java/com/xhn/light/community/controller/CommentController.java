package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.Map;

import com.xhn.light.community.entity.vo.CollectionMyParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.community.entity.CommentEntity;
import com.xhn.light.community.service.CommentService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 文章-评论表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@RestController
@RequestMapping("community/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:comment:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = commentService.queryPage(params);

        return Result.ok().data("page", page);
    }

    @GetMapping("/getCommentList")
    public Result getCommentList(CollectionMyParams params){
        PageUtils page = commentService.getCommentList(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:comment:info")
    public Result info(@PathVariable("id") Long id){
		CommentEntity comment = commentService.getById(id);

        return Result.ok().data("comment", comment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:comment:save")
    public Result save(@RequestBody CommentEntity comment){
		commentService.save(comment);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:comment:update")
    public Result update(@RequestBody CommentEntity comment){
		commentService.updateById(comment);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:comment:delete")
    public Result delete(@RequestBody Long[] ids){
		commentService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
