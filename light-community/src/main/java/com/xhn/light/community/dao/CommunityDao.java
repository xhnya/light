package com.xhn.light.community.dao;

import com.xhn.light.community.entity.CommunityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.community.entity.vo.CommunityListViewForIndex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 社区表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-17 09:06:04
 */
@Mapper
public interface CommunityDao extends BaseMapper<CommunityEntity> {

    List<CommunityListViewForIndex> getCommunityListView();
}
