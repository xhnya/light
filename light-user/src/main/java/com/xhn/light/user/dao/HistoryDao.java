package com.xhn.light.user.dao;

import com.xhn.light.user.entity.HistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户历史表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 11:42:28
 */
@Mapper
public interface HistoryDao extends BaseMapper<HistoryEntity> {
	
}
