package com.xhn.light.admin.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.admin.entity.RegisterCountEntity;
import com.xhn.light.admin.service.RegisterCountService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 注册人数统计表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-15 10:45:41
 */
@RestController
@RequestMapping("admin/registercount")
public class RegisterCountController {
    @Autowired
    private RegisterCountService registerCountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("admin:registercount:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = registerCountService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("admin:registercount:info")
    public Result info(@PathVariable("id") Long id){
		RegisterCountEntity registerCount = registerCountService.getById(id);

        return Result.ok().data("registerCount", registerCount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:registercount:save")
    public Result save(@RequestBody RegisterCountEntity registerCount){
		registerCountService.save(registerCount);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:registercount:update")
    public Result update(@RequestBody RegisterCountEntity registerCount){
		registerCountService.updateById(registerCount);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:registercount:delete")
    public Result delete(@RequestBody Long[] ids){
		registerCountService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
