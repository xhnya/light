package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.UserCountEntity;
import com.xhn.light.user.service.UserCountService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 用户关注的游戏的统计
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-19 22:35:46
 */
@RestController
@RequestMapping("user/usercount")
public class UserCountController {
    @Autowired
    private UserCountService userCountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:usercount:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userCountService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:usercount:info")
    public Result info(@PathVariable("id") Long id){
		UserCountEntity userCount = userCountService.getById(id);

        return Result.ok().data("userCount", userCount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:usercount:save")
    public Result save(@RequestBody UserCountEntity userCount){
		userCountService.save(userCount);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:usercount:update")
    public Result update(@RequestBody UserCountEntity userCount){
		userCountService.updateById(userCount);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:usercount:delete")
    public Result delete(@RequestBody Long[] ids){
		userCountService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
