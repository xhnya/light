package com.xhn.light.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.xhn.light.admin.dao.TopDao;
import com.xhn.light.admin.entity.TopEntity;
import com.xhn.light.admin.service.TopService;


@Service("topService")
public class TopServiceImpl extends ServiceImpl<TopDao, TopEntity> implements TopService {

    @Autowired
    private TopDao topDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TopEntity> page = this.page(
                new Query<TopEntity>().getPage(params),
                new QueryWrapper<TopEntity>()
        );

        return new PageUtils(page);
    }

}