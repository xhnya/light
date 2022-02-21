package com.xhn.light.wiki.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xhn.light.wiki.vo.MenuListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.wiki.entity.MenuEntity;
import com.xhn.light.wiki.service.MenuService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;


/**
 * 百科菜单表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@RestController
@RequestMapping("wiki/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("wiki:menu:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = menuService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("wiki:menu:info")
    public Result info(@PathVariable("id") Long id) {
        MenuEntity menu = menuService.getById(id);

        return Result.ok().data("menu", menu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("wiki:menu:save")
    public Result save(@RequestBody MenuEntity menu) {
        menuService.save(menu);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("wiki:menu:update")
    public Result update(@RequestBody MenuEntity menu) {
        menuService.updateById(menu);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("wiki:menu:delete")
    public Result delete(@RequestBody Long[] ids) {
        menuService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    @GetMapping("/getMenuList/{id}")
    public Result getMenuList(@PathVariable("id") Long id) {
        List<MenuListView> result=menuService.getMenuList(id);
        return Result.ok().data("result",result);
    }


}
