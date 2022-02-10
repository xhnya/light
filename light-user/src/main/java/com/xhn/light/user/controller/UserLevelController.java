package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.UserLevelEntity;
import com.xhn.light.user.service.UserLevelService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 用户等级表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/userlevel")
public class UserLevelController {
    @Autowired
    private UserLevelService userLevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userlevel:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userLevelService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:userlevel:info")
    public Result info(@PathVariable("id") Long id){
		UserLevelEntity userLevel = userLevelService.getById(id);

        return Result.ok().data("userLevel", userLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:userlevel:save")
    public Result save(@RequestBody UserLevelEntity userLevel){
		userLevelService.save(userLevel);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:userlevel:update")
    public Result update(@RequestBody UserLevelEntity userLevel){
		userLevelService.updateById(userLevel);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userlevel:delete")
    public Result delete(@RequestBody Long[] ids){
		userLevelService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
