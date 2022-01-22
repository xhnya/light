package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.TypeEntity;

import java.util.Map;

/**
 * 游戏类型表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
public interface TypeService extends IService<TypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

