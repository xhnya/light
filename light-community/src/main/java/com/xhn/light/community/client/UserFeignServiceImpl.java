package com.xhn.light.community.client;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.UserAnPageView;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/10 16:50
 * @description：
 */
@Component
public class UserFeignServiceImpl implements UserFeignService{

    @Override
    public List<PageOfGameName> getUserFromAdminCommunity(List<Long> ids) {
        return null;
    }

    @Override
    public List<UserAnPageView> getCommunityIndex(List<Long> ids) {
        return null;
    }
}
