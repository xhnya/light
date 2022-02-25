package com.xhn.light.admin.dao;

import com.xhn.light.admin.entity.SubscribeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件订阅表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 01:59:05
 */
@Mapper
public interface SubscribeDao extends BaseMapper<SubscribeEntity> {
	
}
