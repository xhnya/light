package com.xhn.light.community.client;

import com.xhn.light.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/10 11:58
 * @description： 调用game的接口
 */
@Component
@FeignClient(value = "light-game",fallback =GameFeignServiceImpl.class)
public interface GameFeignService {
    @GetMapping("/gatGameNameByIdsForCommunity")
    public List<String>  gatGameNameByIdsForCommunity(List<Long> ids);
}
