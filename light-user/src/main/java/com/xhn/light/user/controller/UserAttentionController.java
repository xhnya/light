package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.UserAttentionEntity;
import com.xhn.light.user.service.UserAttentionService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 用户关注
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/userattention")
public class UserAttentionController {
    @Autowired
    private UserAttentionService userAttentionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userattention:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userAttentionService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:userattention:info")
    public Result info(@PathVariable("id") Long id){
		UserAttentionEntity userAttention = userAttentionService.getById(id);

        return Result.ok().data("userAttention", userAttention);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:userattention:save")
    public Result save(@RequestBody UserAttentionEntity userAttention){
		userAttentionService.save(userAttention);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:userattention:update")
    public Result update(@RequestBody UserAttentionEntity userAttention){
		userAttentionService.updateById(userAttention);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userattention:delete")
    public Result delete(@RequestBody Long[] ids){
		userAttentionService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
