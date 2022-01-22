package com.xhn.light.game.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.game.entity.ProduceEntity;
import com.xhn.light.game.service.ProduceService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;



/**
 * 游戏产商
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:14:59
 */
@RestController
@RequestMapping("game/produce")
public class ProduceController {
    @Autowired
    private ProduceService produceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("game:produce:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = produceService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("game:produce:info")
    public Result info(@PathVariable("id") Long id){
		ProduceEntity produce = produceService.getById(id);

        return Result.ok().data("produce", produce);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("game:produce:save")
    public Result save(@RequestBody ProduceEntity produce){
		produceService.save(produce);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("game:produce:update")
    public Result update(@RequestBody ProduceEntity produce){
		produceService.updateById(produce);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("game:produce:delete")
    public Result delete(@RequestBody Long[] ids){
		produceService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
