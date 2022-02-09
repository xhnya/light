package com.xhn.light.community.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.community.dao.LikesDao;
import com.xhn.light.community.entity.LikesEntity;
import com.xhn.light.community.service.LikesService;


@Service("likesService")
public class LikesServiceImpl extends ServiceImpl<LikesDao, LikesEntity> implements LikesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<LikesEntity> page = this.page(
                new Query<LikesEntity>().getPage(params),
                new QueryWrapper<LikesEntity>()
        );

        return new PageUtils(page);
    }

}