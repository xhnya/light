package com.xhn.light.game.dao;

import com.xhn.light.game.entity.ScoreEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.game.entity.vo.GameInfoScoreList;
import com.xhn.light.game.entity.vo.ScoreViewForIndex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 游戏评分表

 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@Mapper
public interface ScoreDao extends BaseMapper<ScoreEntity> {

    List<GameInfoScoreList> getGameInfoList(Long id);

    List<ScoreViewForIndex> getEvaluating();
}
