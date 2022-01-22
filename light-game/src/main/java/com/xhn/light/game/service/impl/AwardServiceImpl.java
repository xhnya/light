package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.AwardDao;
import com.xhn.light.game.entity.AwardEntity;
import com.xhn.light.game.service.AwardService;


@Service("awardService")
public class AwardServiceImpl extends ServiceImpl<AwardDao, AwardEntity> implements AwardService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AwardEntity> page = this.page(
                new Query<AwardEntity>().getPage(params),
                new QueryWrapper<AwardEntity>()
        );

        return new PageUtils(page);
    }

}