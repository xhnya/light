package com.xhn.light.auth.client;

import com.xhn.light.common.exceptionhandler.LightException;
import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ：xhn
 * @date ：2022/2/14 16:22
 * @description：
 */
@Slf4j
@Component
public class UserFeignServiceImpl implements UserFeignService{
    @Override
    public Result getUserAndPassword(UserLogin user) {
        return Result.error();
    }

    @Override
    public UserLogin getUserAndPassword1(UserLogin user) {
        throw LightException.from("登录出错");
    }
}
