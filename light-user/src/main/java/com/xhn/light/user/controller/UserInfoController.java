package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.Map;

import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.entity.vo.UserInfoForMy;
import com.xhn.light.user.entity.vo.UserInfoView;
import com.xhn.light.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.user.entity.UserInfoEntity;
import com.xhn.light.user.service.UserInfoService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户信息表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userinfo:list")
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = userInfoService.queryPage(params);

        return Result.ok().data("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:userinfo:info")
    public Result info(@PathVariable("id") Long id){
		UserInfoEntity userInfo = userInfoService.getById(id);

        return Result.ok().data("userInfo", userInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:userinfo:save")
    public Result save(@RequestBody UserInfoEntity userInfo){
		userInfoService.save(userInfo);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:userinfo:update")
    public Result update(@RequestBody UserInfoEntity userInfo,HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);
        userInfoService.updateUserInfo(userInfo,userId);
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userinfo:delete")
    public Result delete(@RequestBody Long[] ids){
		userInfoService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    @GetMapping("/userInfo")
    public Result getUserInfo(HttpServletRequest request){
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);
        UserInfoForMy result=userInfoService.getUserInfo(userId);
        return Result.ok().data("result",result);
    }

}
