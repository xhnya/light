package com.xhn.light.user.dao;

import com.xhn.light.user.entity.UserInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.user.entity.vo.UserInfoForMy;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {

    UserInfoForMy getUserInfo(Long userId);
}
