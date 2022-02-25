package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.UserGameEntity;

import java.util.Map;

/**
 * 用户关注的游戏
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 00:27:04
 */
public interface UserGameService extends IService<UserGameEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

