package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.SignEntity;
import com.xhn.light.user.service.SignService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 签到记录表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/sign")
public class SignController {
    @Autowired
    private SignService signService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:sign:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = signService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:sign:info")
    public Result info(@PathVariable("id") Long id){
		SignEntity sign = signService.getById(id);

        return Result.ok().data("sign", sign);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:sign:save")
    public Result save(@RequestBody SignEntity sign){
		signService.save(sign);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:sign:update")
    public Result update(@RequestBody SignEntity sign){
		signService.updateById(sign);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:sign:delete")
    public Result delete(@RequestBody Long[] ids){
		signService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
