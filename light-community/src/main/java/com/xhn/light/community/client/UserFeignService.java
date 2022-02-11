package com.xhn.light.community.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author ：xhn
 * @date ：2022/2/10 16:49
 * @description：
 */
@Component
@FeignClient(value = "light-user",fallback =GameFeignServiceImpl.class)
public interface UserFeignService {
}
