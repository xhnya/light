package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.user.entity.UserCountEntity;

import java.util.Map;

/**
 * 用户关注的游戏的统计
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-19 22:35:46
 */
public interface UserCountService extends IService<UserCountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

