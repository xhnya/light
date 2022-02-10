package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.LevelRecordEntity;
import com.xhn.light.user.service.LevelRecordService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 用户等级记录表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/levelrecord")
public class LevelRecordController {
    @Autowired
    private LevelRecordService levelRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:levelrecord:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = levelRecordService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:levelrecord:info")
    public Result info(@PathVariable("id") Long id){
		LevelRecordEntity levelRecord = levelRecordService.getById(id);

        return Result.ok().data("levelRecord", levelRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:levelrecord:save")
    public Result save(@RequestBody LevelRecordEntity levelRecord){
		levelRecordService.save(levelRecord);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:levelrecord:update")
    public Result update(@RequestBody LevelRecordEntity levelRecord){
		levelRecordService.updateById(levelRecord);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:levelrecord:delete")
    public Result delete(@RequestBody Long[] ids){
		levelRecordService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
