package com.xhn.light.auth.client;

import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.Result;
import org.springframework.stereotype.Component;

/**
 * @author ：xhn
 * @date ：2022/2/14 16:22
 * @description：
 */
@Component
public class UserFeignServiceImpl implements UserFeignService{
    @Override
    public Result getUserAndPassword(UserLogin user) {
        return Result.error();
    }
}
