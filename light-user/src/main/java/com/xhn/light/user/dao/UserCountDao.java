package com.xhn.light.user.dao;

import com.xhn.light.user.entity.UserCountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户关注的游戏的统计
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-19 22:35:46
 */
@Mapper
public interface UserCountDao extends BaseMapper<UserCountEntity> {
	
}
