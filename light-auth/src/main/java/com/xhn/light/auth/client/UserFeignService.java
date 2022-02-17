package com.xhn.light.auth.client;

import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ：xhn
 * @date ：2022/2/14 16:21
 * @description：
 */
@Component
@FeignClient(value = "light-user",fallback =UserFeignServiceImpl.class)
public interface UserFeignService {
    @PostMapping("/user/user/getUserAndPassword")
    public Result getUserAndPassword(@RequestBody UserLogin user);

    @PostMapping("/user/user/getUserAndPassword1")
    public UserLogin getUserAndPassword1(@RequestBody UserLogin user);
}
