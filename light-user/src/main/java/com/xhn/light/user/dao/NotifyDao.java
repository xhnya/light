package com.xhn.light.user.dao;

import com.xhn.light.user.entity.NotifyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户通知表,包含了所有用户的消息
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 09:36:31
 */
@Mapper
public interface NotifyDao extends BaseMapper<NotifyEntity> {

    void updateLikeRead(Long userId);
}
