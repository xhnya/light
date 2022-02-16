package com.xhn.light.game.service;

import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.RecommendEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.game.entity.vo.RecommendListView;

import java.util.List;
import java.util.Map;

/**
* @author xhn
* @description 针对表【gms_recommend(游戏推荐表)】的数据库操作Service
* @createDate 2022-02-13 21:16:34
*/
public interface RecommendService extends IService<RecommendEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RecommendListView> listView(Integer type);
}
