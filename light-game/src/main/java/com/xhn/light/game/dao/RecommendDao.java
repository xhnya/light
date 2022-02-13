package com.xhn.light.game.dao;

import com.xhn.light.game.entity.RecommendEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author xhn
* @description 针对表【gms_recommend(游戏推荐表)】的数据库操作Mapper
* @createDate 2022-02-13 21:16:34
* @Entity com.xhn.light.game.entity.GmsRecommend
*/
@Mapper
public interface RecommendDao extends BaseMapper<RecommendEntity> {

}




