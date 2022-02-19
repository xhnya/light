package com.xhn.light.game.service.impl;

import com.xhn.light.game.entity.vo.ScoreViewForIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.ScoreDao;
import com.xhn.light.game.entity.ScoreEntity;
import com.xhn.light.game.service.ScoreService;


@Service("scoreService")
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, ScoreEntity> implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ScoreEntity> page = this.page(
                new Query<ScoreEntity>().getPage(params),
                new QueryWrapper<ScoreEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ScoreViewForIndex> getEvaluating() {
        return scoreDao.getEvaluating();
    }

}