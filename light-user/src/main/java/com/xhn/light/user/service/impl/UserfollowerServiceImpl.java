package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.UserfollowerDao;
import com.xhn.light.user.entity.UserfollowerEntity;
import com.xhn.light.user.service.UserfollowerService;


@Service("userfollowerService")
public class UserfollowerServiceImpl extends ServiceImpl<UserfollowerDao, UserfollowerEntity> implements UserfollowerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,Long id) {
        IPage<UserfollowerEntity> page = this.page(
                new Query<UserfollowerEntity>().getPage(params),
                new QueryWrapper<UserfollowerEntity>().eq("user_id",id)
        );

        return new PageUtils(page);
    }

}