package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.UserCountDao;
import com.xhn.light.user.entity.UserCountEntity;
import com.xhn.light.user.service.UserCountService;


@Service("userCountService")
public class UserCountServiceImpl extends ServiceImpl<UserCountDao, UserCountEntity> implements UserCountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserCountEntity> page = this.page(
                new Query<UserCountEntity>().getPage(params),
                new QueryWrapper<UserCountEntity>()
        );

        return new PageUtils(page);
    }

}