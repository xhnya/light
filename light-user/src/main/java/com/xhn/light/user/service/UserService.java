package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.UserAnPageView;
import com.xhn.light.common.pojo.UserLogin;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;
import com.xhn.light.user.entity.UserEntity;
import com.xhn.light.user.entity.vo.UserInfoView;

import java.util.List;
import java.util.Map;

/**
 * 用户重要信息
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<PageOfGameName> getUserFromAdminCommunity(List<Long> ids);

    List<UserAnPageView> getCommunityIndex(List<Long> ids);

    Result getUserAndPassword(String username, String password);

    UserLogin getUserAndPassword1(String username, String password);

    UserInfoView getUserInfoByToken(Long userId);

    UserLogin getUserInfoForAuth(String username, String password);
}

