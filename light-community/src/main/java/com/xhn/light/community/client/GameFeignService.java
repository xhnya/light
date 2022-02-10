package com.xhn.light.community.client;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/10 11:58
 * @description： 调用game的接口
 */
@Component
@FeignClient(value = "light-game",fallback =GameFeignServiceImpl.class)
public interface GameFeignService {
    @GetMapping("/game/game/gatGameNameByIdsForCommunity")
    public List<PageOfGameName>  gatGameNameByIdsForCommunity(@RequestParam(value = "ids") List<Long> ids);
}
