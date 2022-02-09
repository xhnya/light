package com.xhn.light.community.dao;

import com.xhn.light.community.entity.LikesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章点赞表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Mapper
public interface LikesDao extends BaseMapper<LikesEntity> {
	
}
