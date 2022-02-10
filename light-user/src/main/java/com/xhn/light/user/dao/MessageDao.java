package com.xhn.light.user.dao;

import com.xhn.light.user.entity.MessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 私信
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Mapper
public interface MessageDao extends BaseMapper<MessageEntity> {
	
}
