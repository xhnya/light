package com.xhn.light.admin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.xhn.light.admin.dao.CountDao;
import com.xhn.light.admin.entity.CountEntity;
import com.xhn.light.admin.service.CountService;


@Service("countService")
public class CountServiceImpl extends ServiceImpl<CountDao, CountEntity> implements CountService {

    @Autowired
    private CountDao countDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CountEntity> page = this.page(
                new Query<CountEntity>().getPage(params),
                new QueryWrapper<CountEntity>()
        );

        return new PageUtils(page);
    }

}