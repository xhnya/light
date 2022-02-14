package com.xhn.light.user.dao;

import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.UserAnPageView;
import com.xhn.light.user.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户重要信息
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    List<PageOfGameName> getUserFromAdminCommunity(List<Long> ids);

    List<UserAnPageView> getCommunityIndex(List<Long> ids);
}
