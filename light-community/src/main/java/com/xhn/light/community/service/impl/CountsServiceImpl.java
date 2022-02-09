package com.xhn.light.community.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.community.dao.CountsDao;
import com.xhn.light.community.entity.CountsEntity;
import com.xhn.light.community.service.CountsService;


@Service("countsService")
public class CountsServiceImpl extends ServiceImpl<CountsDao, CountsEntity> implements CountsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CountsEntity> page = this.page(
                new Query<CountsEntity>().getPage(params),
                new QueryWrapper<CountsEntity>()
        );

        return new PageUtils(page);
    }

}