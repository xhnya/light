package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.GameDao;
import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.service.GameService;


@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GameEntity> page = this.page(
                new Query<GameEntity>().getPage(params),
                new QueryWrapper<GameEntity>()
        );

        return new PageUtils(page);
    }

}