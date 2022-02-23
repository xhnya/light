package com.xhn.light.user.dao;

import com.xhn.light.user.entity.MessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.user.entity.vo.MyLikeMessageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 私信信息表,包含了所有用户的私信信息
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 10:23:42
 */
@Mapper
public interface MessageDao extends BaseMapper<MessageEntity> {

    List<MyLikeMessageVo> getMyLikeList(Long userId);
}
