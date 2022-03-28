package com.xhn.light.user.dao;

import com.xhn.light.user.entity.BanEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xhn
* @description 针对表【ums_ban(封禁用户表)】的数据库操作Mapper
* @createDate 2022-03-28 16:59:25
* @Entity com.xhn.light.user.entity.BanEntity
*/
@Mapper
public interface BanDao extends BaseMapper<BanEntity> {

}




