package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.ComputerConfigDao;
import com.xhn.light.game.entity.ComputerConfigEntity;
import com.xhn.light.game.service.ComputerConfigService;


@Service("computerConfigService")
public class ComputerConfigServiceImpl extends ServiceImpl<ComputerConfigDao, ComputerConfigEntity> implements ComputerConfigService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ComputerConfigEntity> page = this.page(
                new Query<ComputerConfigEntity>().getPage(params),
                new QueryWrapper<ComputerConfigEntity>()
        );

        return new PageUtils(page);
    }

}