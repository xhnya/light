package com.xhn.light.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.Constant;
import com.xhn.light.common.utils.PageParamsUtils;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;
import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.entity.RecommendEntity;
import com.xhn.light.game.entity.vo.IdAndNameVo;
import com.xhn.light.game.entity.vo.RecommendAdminList;
import com.xhn.light.game.entity.vo.RecommendListView;
import com.xhn.light.game.service.RecommendService;
import com.xhn.light.game.dao.RecommendDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author xhn
* @description 针对表【gms_recommend(游戏推荐表)】的数据库操作Service实现
* @createDate 2022-02-13 21:16:34
*/
@Service
public class RecommendServiceImpl extends ServiceImpl<RecommendDao, RecommendEntity>
    implements RecommendService {
    @Autowired
    private RecommendDao recommendDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //列表时间显示
        Page page = new PageParamsUtils().getPage(params);
//        Page<RecommendEntity> page = new Page<>();

        Integer type = new Integer(params.get("type").toString());
        List<RecommendAdminList> result=recommendDao.selectRecommendList(page,type);
        return new PageUtils(result,(int)page.getTotal(),(int)page.getSize(),(int)page.getPages());
    }

    @Override
    public List<RecommendListView> listView(Integer type) {
        List<RecommendListView> list=recommendDao.listView(type);
        return list;
    }

    @Override
    public List<IdAndNameVo> getBannerGame(Integer type) {
        return recommendDao.getBannerGame(type);
    }
}




