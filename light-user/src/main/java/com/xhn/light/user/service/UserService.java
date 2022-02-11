package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.user.entity.UserEntity;

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
}

