package com.xhn.light.game.dao;

import com.xhn.light.game.entity.ComputerConfigEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏配置表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:15
 */
@Mapper
public interface ComputerConfigDao extends BaseMapper<ComputerConfigEntity> {
	
}
