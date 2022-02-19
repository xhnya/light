package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.FavoriteDao;
import com.xhn.light.user.entity.FavoriteEntity;
import com.xhn.light.user.service.FavoriteService;


@Service("favoriteService")
public class FavoriteServiceImpl extends ServiceImpl<FavoriteDao, FavoriteEntity> implements FavoriteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,Long userId) {
        IPage<FavoriteEntity> page = this.page(
                new Query<FavoriteEntity>().getPage(params),
                new QueryWrapper<FavoriteEntity>().eq("user_id",userId)
        );

        return new PageUtils(page);
    }

}