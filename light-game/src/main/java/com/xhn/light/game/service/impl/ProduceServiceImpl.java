package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.ProduceDao;
import com.xhn.light.game.entity.ProduceEntity;
import com.xhn.light.game.service.ProduceService;


@Service("produceService")
public class ProduceServiceImpl extends ServiceImpl<ProduceDao, ProduceEntity> implements ProduceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProduceEntity> page = this.page(
                new Query<ProduceEntity>().getPage(params),
                new QueryWrapper<ProduceEntity>()
        );

        return new PageUtils(page);
    }

}