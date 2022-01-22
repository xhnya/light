package com.xhn.light.game.dao;

import com.xhn.light.game.entity.GameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@Mapper
public interface GameDao extends BaseMapper<GameEntity> {
	
}
