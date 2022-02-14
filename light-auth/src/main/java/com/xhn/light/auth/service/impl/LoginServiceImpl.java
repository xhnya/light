package com.xhn.light.auth.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xhn.light.auth.client.UserFeignService;
import com.xhn.light.auth.service.LoginService;
import com.xhn.light.auth.vo.LoginInfoVo;
import com.xhn.light.common.enums.ResultCode;
import com.xhn.light.common.exceptionhandler.LightException;

import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.PhoneOrEmailOrUserName;
import com.xhn.light.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/14 15:12
 * @description：
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserFeignService userFeignService;

    @Override
    public String login(UserLogin userLogin) {
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
//        Integer type = loginInfoVo.getType();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            throw LightException.from(ResultCode.LOGIN_ERROR);
        }
        Result result = userFeignService.getUserAndPassword(userLogin);
        String token = (String) result.getData().get("token");
        return token;
    }
}
