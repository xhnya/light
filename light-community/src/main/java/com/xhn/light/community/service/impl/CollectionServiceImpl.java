package com.xhn.light.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.common.utils.PageParamsUtils;
import com.xhn.light.community.entity.vo.CollectionMyParams;
import com.xhn.light.community.entity.vo.MyListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.community.dao.CollectionDao;
import com.xhn.light.community.entity.CollectionEntity;
import com.xhn.light.community.service.CollectionService;


@Service("collectionService")
public class CollectionServiceImpl extends ServiceImpl<CollectionDao, CollectionEntity> implements CollectionService {

    @Autowired
    private CollectionDao collectionDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CollectionEntity> page = this.page(
                new Query<CollectionEntity>().getPage(params),
                new QueryWrapper<CollectionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils myList(CollectionMyParams params) {
        Page<CollectionEntity> page = new Page<>(params.getPage(),params.getLimit());
        List<MyListView> result=collectionDao.getMyList(page,params);
        return new PageUtils(result,(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent());
    }

}