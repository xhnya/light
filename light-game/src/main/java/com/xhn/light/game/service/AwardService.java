package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.AwardEntity;

import java.util.Map;

/**
 * 奖项
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
public interface AwardService extends IService<AwardEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

