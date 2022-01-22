package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.SeriesEntity;

import java.util.Map;

/**
 * 游戏同系列
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
public interface SeriesService extends IService<SeriesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

