package com.xhn.light.game.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.game.entity.RecommendEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.game.entity.vo.RecommendAdminList;
import com.xhn.light.game.entity.vo.RecommendListView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* @author xhn
* @description 针对表【gms_recommend(游戏推荐表)】的数据库操作Mapper
* @createDate 2022-02-13 21:16:34
* @Entity com.xhn.light.game.entity.GmsRecommend
*/
@Mapper
public interface RecommendDao extends BaseMapper<RecommendEntity> {

    List<RecommendAdminList> selectRecommendList(Page page, Integer type);

    List<RecommendListView> listView(Integer type);
}




