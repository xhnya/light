package com.xhn.light.game.client;

import com.xhn.light.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/17 9:11
 * @description：
 */
@Component
@FeignClient(value = "light-community",fallback =AddCommunityFeignImpl.class)
public interface AddCommunityFeign {

    @PostMapping("/community/community/saveFromGame")
    public Result saveFromGame(@RequestBody Map<String,Object> params);
}
