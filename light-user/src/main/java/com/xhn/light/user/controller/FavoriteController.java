package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import com.xhn.light.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xhn.light.user.entity.FavoriteEntity;
import com.xhn.light.user.service.FavoriteService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 收藏夹
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:favorite:list")
    public Result list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);

        PageUtils page = favoriteService.queryPage(params,userId);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:favorite:info")
    public Result info(@PathVariable("id") Long id){
		FavoriteEntity favorite = favoriteService.getById(id);

        return Result.ok().data("favorite", favorite);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:favorite:save")
    public Result save(@RequestBody FavoriteEntity favorite,HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);
        favorite.setUserId(userId);
		favoriteService.save(favorite);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:favorite:update")
    public Result update(@RequestBody FavoriteEntity favorite){
		favoriteService.updateById(favorite);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:favorite:delete")
    public Result delete(@RequestBody Long[] ids){
		favoriteService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

}
