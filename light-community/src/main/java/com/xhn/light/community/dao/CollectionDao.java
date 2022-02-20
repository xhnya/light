package com.xhn.light.community.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.community.entity.CollectionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.community.entity.vo.CollectionMyParams;
import com.xhn.light.community.entity.vo.MyListView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 收藏夹内容
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 15:05:34
 */
@Mapper
public interface CollectionDao extends BaseMapper<CollectionEntity> {

    List<MyListView> getMyList(Page<CollectionEntity> page, CollectionMyParams params);
}
