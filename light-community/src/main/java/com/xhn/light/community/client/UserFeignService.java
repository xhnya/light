package com.xhn.light.community.client;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.UserAnPageView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/10 16:49
 * @description：
 */
@Component
@FeignClient(value = "light-user",fallback =UserFeignServiceImpl.class)
public interface UserFeignService {
    @GetMapping("/user/user/getUserFromAdminCommunity")
    public List<PageOfGameName> getUserFromAdminCommunity(@RequestParam List<Long> ids);

    @GetMapping("/user/user/getCommunityIndex")
    public List<UserAnPageView> getCommunityIndex(@RequestParam List<Long> ids);
}
