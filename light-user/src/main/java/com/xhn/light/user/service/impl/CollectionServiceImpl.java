package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.CollectionDao;
import com.xhn.light.user.entity.CollectionEntity;
import com.xhn.light.user.service.CollectionService;


@Service("collectionService")
public class CollectionServiceImpl extends ServiceImpl<CollectionDao, CollectionEntity> implements CollectionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CollectionEntity> page = this.page(
                new Query<CollectionEntity>().getPage(params),
                new QueryWrapper<CollectionEntity>()
        );

        return new PageUtils(page);
    }

}