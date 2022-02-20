package com.xhn.light.auth.controller;

import com.xhn.light.auth.service.LoginService;
import com.xhn.light.auth.vo.LoginInfoVo;
import com.xhn.light.common.enums.ResultCode;
import com.xhn.light.common.exceptionhandler.LightException;
import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Description: 登录处理
 * @author: xhn
 * @date: 2022/1/10 17:38
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 密码登录
     * @param userLogin
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody UserLogin userLogin){
        //throw LightException.from(ResultCode.LOGIN_ERROR);
        return loginService.login(userLogin);
    }

    @PostMapping("/phoneAndEmail")
    public Result verificationLogin(@RequestBody UserLogin userLogin){
        String token=loginService.verificationLogin(userLogin);
        return Result.ok().data("token",token);
    }


}
