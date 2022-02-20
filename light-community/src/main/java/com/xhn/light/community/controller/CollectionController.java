package com.xhn.light.community.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.community.entity.CountsEntity;
import com.xhn.light.community.entity.vo.CollectionMyParams;
import com.xhn.light.community.service.CountsService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.community.entity.CollectionEntity;
import com.xhn.light.community.service.CollectionService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 收藏夹内容
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 15:05:34
 */
@RestController
@RequestMapping("community/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private CountsService countsService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("community:collection:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = collectionService.queryPage(params);

        return Result.ok().data("page", page);
    }

    @GetMapping("/myList")
    //@RequiresPermissions("community:collection:list")
    public Result myList( CollectionMyParams params){
        PageUtils page = collectionService.myList(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("community:collection:info")
    public Result info(@PathVariable("id") Long id){
		CollectionEntity collection = collectionService.getById(id);

        return Result.ok().data("collection", collection);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("community:collection:save")
    public Result save(@RequestBody CollectionEntity collection){
        Long contentId = collection.getContentId();
        Long parentId = collection.getParentId();
        QueryWrapper<CollectionEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("content_id",contentId).eq("parent_id",parentId);
        long count = collectionService.count(wrapper);
        if (count!=0){
            return Result.error().message("你已经收藏过了");
        }
        Map<String, Long> map = new HashMap<>();
        map.put("id",contentId);
        rabbitTemplate.convertAndSend("user_collection",map);
        collectionService.save(collection);
        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("community:collection:update")
    public Result update(@RequestBody CollectionEntity collection){
		collectionService.updateById(collection);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("community:collection:delete")
    public Result delete(@RequestBody Long[] ids){
		collectionService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
