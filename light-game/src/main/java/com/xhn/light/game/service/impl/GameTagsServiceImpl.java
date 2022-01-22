package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.GameTagsDao;
import com.xhn.light.game.entity.GameTagsEntity;
import com.xhn.light.game.service.GameTagsService;


@Service("gameTagsService")
public class GameTagsServiceImpl extends ServiceImpl<GameTagsDao, GameTagsEntity> implements GameTagsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GameTagsEntity> page = this.page(
                new Query<GameTagsEntity>().getPage(params),
                new QueryWrapper<GameTagsEntity>()
        );

        return new PageUtils(page);
    }

}