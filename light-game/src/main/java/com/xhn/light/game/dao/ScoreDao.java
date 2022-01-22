package com.xhn.light.game.dao;

import com.xhn.light.game.entity.ScoreEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏评分表

 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:15:00
 */
@Mapper
public interface ScoreDao extends BaseMapper<ScoreEntity> {
	
}
