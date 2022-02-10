package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.UserAttentionDao;
import com.xhn.light.user.entity.UserAttentionEntity;
import com.xhn.light.user.service.UserAttentionService;


@Service("userAttentionService")
public class UserAttentionServiceImpl extends ServiceImpl<UserAttentionDao, UserAttentionEntity> implements UserAttentionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserAttentionEntity> page = this.page(
                new Query<UserAttentionEntity>().getPage(params),
                new QueryWrapper<UserAttentionEntity>()
        );

        return new PageUtils(page);
    }

}