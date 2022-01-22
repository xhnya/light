package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.TagsDao;
import com.xhn.light.game.entity.TagsEntity;
import com.xhn.light.game.service.TagsService;


@Service("tagsService")
public class TagsServiceImpl extends ServiceImpl<TagsDao, TagsEntity> implements TagsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TagsEntity> page = this.page(
                new Query<TagsEntity>().getPage(params),
                new QueryWrapper<TagsEntity>()
        );

        return new PageUtils(page);
    }

}