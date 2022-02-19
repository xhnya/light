package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.ScoreEntity;
import com.xhn.light.game.entity.vo.ScoreViewForIndex;

import java.util.List;
import java.util.Map;

/**
 * 游戏评分表

 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
public interface ScoreService extends IService<ScoreEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ScoreViewForIndex> getEvaluating();
}

