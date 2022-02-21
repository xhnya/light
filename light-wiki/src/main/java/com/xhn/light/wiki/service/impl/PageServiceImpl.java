package com.xhn.light.wiki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.wiki.dao.PageDao;
import com.xhn.light.wiki.entity.PageEntity;
import com.xhn.light.wiki.service.PageService;


@Service("pageService")
public class PageServiceImpl extends ServiceImpl<PageDao, PageEntity> implements PageService {

    @Autowired
    private PageDao pageDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PageEntity> page = this.page(
                new Query<PageEntity>().getPage(params),
                new QueryWrapper<PageEntity>()
        );

        return new PageUtils(page);
    }

}