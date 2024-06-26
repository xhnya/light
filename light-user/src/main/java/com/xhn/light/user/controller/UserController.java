package com.xhn.light.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.UserAnPageView;
import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.Constant;
import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.user.entity.vo.ChangePasswordVo;
import com.xhn.light.user.entity.vo.UserInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.service.UserService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户重要信息
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@RestController
@RequestMapping("user/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:user:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = userService.queryPage(params);

        return Result.ok().data("page", page);
    }

    /**
     * 提供给社区后台显示的远程调用接口
     */
    @GetMapping("/getUserFromAdminCommunity")
    public List<PageOfGameName> getUserFromAdminCommunity(@RequestParam List<Long> ids) {

        return userService.getUserFromAdminCommunity(ids);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:user:info")
    public Result info(@PathVariable("id") Long id) {
        UserEntity user = userService.getById(id);

        return Result.ok().data("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:user:save")
    public Result save(@RequestBody UserEntity user) {
        userService.save(user);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:user:update")
    public Result update(@RequestBody UserEntity user) {
        userService.updateById(user);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:user:delete")
    public Result delete(@RequestBody Long[] ids) {
        userService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }

    /**
     * 给社区主界面显示提供远程调用接口
     */
    @GetMapping("/getCommunityIndex")
    public List<UserAnPageView> getCommunityIndex(@RequestParam List<Long> ids) {
        return userService.getCommunityIndex(ids);
    }

    /**
     * 提供远程调用接口
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserAndPassword")
    public Result getUserAndPassword(@RequestBody UserLogin user) {
        return userService.getUserAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * 提供远程调用接口
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserAndPassword1")
    public UserLogin getUserAndPassword1(@RequestBody UserLogin user) {
        return userService.getUserAndPassword1(user.getUsername(), user.getPassword());
    }

    /**
     * 获取用户的信息
     * @param request
     * @return
     */
    @PostMapping("getUserInfo")
    public Result getUserInfo(HttpServletRequest request) {
        String info = JwtUtils.getUserInfoByJwtToken(request);
        if (info.equals("")){
            return Result.error().message("没有登录");
        }
        Long userId=Long.parseLong(info);
        UserInfoView userInfo=userService.getUserInfoByToken(userId);
        return Result.ok().data("result",userInfo);
    }

    /**
     * 手机验证登录
     * @param userLogin
     * @return
     */
    @PostMapping("/getUserInfoForAuth")
    public UserLogin getUserInfoForAuth(@RequestBody UserLogin userLogin){
        return userService.getUserInfoForAuth(userLogin.getUsername(), userLogin.getPassword());
    }

    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody ChangePasswordVo param){
        if (!param.getPass().equals(param.getCheckPass())){
            return Result.error().message("两次密码不一致");
        }
        return userService.changePassword(param);
    }

}
