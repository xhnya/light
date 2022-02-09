package com.xhn.light.community.dao;

import com.xhn.light.community.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章-评论表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Mapper
public interface CommentDao extends BaseMapper<CommentEntity> {
	
}
