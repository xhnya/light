package com.xhn.light.community.dao;

import com.xhn.light.community.entity.CountsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章统计表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Mapper
public interface CountsDao extends BaseMapper<CountsEntity> {
	
}
