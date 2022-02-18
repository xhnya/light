package com.xhn.light.auth.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.auth.client.UserFeignService;
import com.xhn.light.auth.service.LoginService;
import com.xhn.light.auth.vo.LoginInfoVo;
import com.xhn.light.common.enums.ResultCode;
import com.xhn.light.common.exceptionhandler.LightException;

import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.JwtUtils;
import com.xhn.light.common.utils.PhoneOrEmailOrUserName;
import com.xhn.light.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/14 15:12
 * @description：
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserFeignService userFeignService;

    /**
     * 代码重构
     * String username = userLogin.getUsername();
     * String password = userLogin.getPassword();
     * //      Integer type = loginInfoVo.getType();
     * if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
     * throw LightException.from(ResultCode.LOGIN_ERROR);
     * }
     * Result result = userFeignService.getUserAndPassword(userLogin);
     * String token = (String) result.getData().get("token");
     * return token;
     * TODO： 加入用户权限管理
     * @param userLogin
     * @return
     */
    @Override
    public Result login(UserLogin userLogin) {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
        //判断输入的是否为空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw LightException.from(ResultCode.LOGIN_ERROR);
        }
        //不为空，验证账号和密码
        UserLogin login = userFeignService.getUserAndPassword1(userLogin);
        if (login==null){
            throw LightException.from(ResultCode.LOGIN_NOT);
        }
        log.info(String.valueOf(login)+"<======>"+userLogin);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password1 = encoder.encode(password);
        if (!password1.equals(login.getPassword())) {
            //否则通过密码验证
            throw LightException.from(ResultCode.LOGIN_ERROR);
        }
        String token = JwtUtils.getJwtToken(login.getId(), login.getCode());

        return Result.ok().data("token",token);
    }

    @Override
    public String verificationLogin(UserLogin userLogin) {


        return null;
    }
}
