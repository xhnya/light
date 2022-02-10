package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.CollectionEntity;
import com.xhn.light.user.service.CollectionService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 收藏夹内容
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:collection:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = collectionService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:collection:info")
    public Result info(@PathVariable("id") Long id){
		CollectionEntity collection = collectionService.getById(id);

        return Result.ok().data("collection", collection);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:collection:save")
    public Result save(@RequestBody CollectionEntity collection){
		collectionService.save(collection);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:collection:update")
    public Result update(@RequestBody CollectionEntity collection){
		collectionService.updateById(collection);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:collection:delete")
    public Result delete(@RequestBody Long[] ids){
		collectionService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
