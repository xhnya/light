package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.PictureDao;
import com.xhn.light.game.entity.PictureEntity;
import com.xhn.light.game.service.PictureService;


@Service("pictureService")
public class PictureServiceImpl extends ServiceImpl<PictureDao, PictureEntity> implements PictureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PictureEntity> page = this.page(
                new Query<PictureEntity>().getPage(params),
                new QueryWrapper<PictureEntity>()
        );

        return new PageUtils(page);
    }

}