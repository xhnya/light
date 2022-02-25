package com.xhn.light.game.dao;

import com.xhn.light.game.entity.UserGameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户关注的游戏
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 00:27:04
 */
@Mapper
public interface UserGameDao extends BaseMapper<UserGameEntity> {
	
}
