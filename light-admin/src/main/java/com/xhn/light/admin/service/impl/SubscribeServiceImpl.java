package com.xhn.light.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.xhn.light.admin.dao.SubscribeDao;
import com.xhn.light.admin.entity.SubscribeEntity;
import com.xhn.light.admin.service.SubscribeService;


@Service("subscribeService")
public class SubscribeServiceImpl extends ServiceImpl<SubscribeDao, SubscribeEntity> implements SubscribeService {

    @Autowired
    private SubscribeDao subscribeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SubscribeEntity> page = this.page(
                new Query<SubscribeEntity>().getPage(params),
                new QueryWrapper<SubscribeEntity>()
        );

        return new PageUtils(page);
    }

}