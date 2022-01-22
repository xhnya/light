package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.GameProduceDao;
import com.xhn.light.game.entity.GameProduceEntity;
import com.xhn.light.game.service.GameProduceService;


@Service("gameProduceService")
public class GameProduceServiceImpl extends ServiceImpl<GameProduceDao, GameProduceEntity> implements GameProduceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GameProduceEntity> page = this.page(
                new Query<GameProduceEntity>().getPage(params),
                new QueryWrapper<GameProduceEntity>()
        );

        return new PageUtils(page);
    }

}