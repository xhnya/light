package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.AtlasDao;
import com.xhn.light.game.entity.AtlasEntity;
import com.xhn.light.game.service.AtlasService;


@Service("atlasService")
public class AtlasServiceImpl extends ServiceImpl<AtlasDao, AtlasEntity> implements AtlasService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AtlasEntity> page = this.page(
                new Query<AtlasEntity>().getPage(params),
                new QueryWrapper<AtlasEntity>()
        );

        return new PageUtils(page);
    }

}