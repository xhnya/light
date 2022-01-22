package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.SeriesDao;
import com.xhn.light.game.entity.SeriesEntity;
import com.xhn.light.game.service.SeriesService;


@Service("seriesService")
public class SeriesServiceImpl extends ServiceImpl<SeriesDao, SeriesEntity> implements SeriesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SeriesEntity> page = this.page(
                new Query<SeriesEntity>().getPage(params),
                new QueryWrapper<SeriesEntity>()
        );

        return new PageUtils(page);
    }

}