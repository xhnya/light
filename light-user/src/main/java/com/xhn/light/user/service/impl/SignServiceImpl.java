package com.xhn.light.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.user.dao.SignDao;
import com.xhn.light.user.entity.SignEntity;
import com.xhn.light.user.service.SignService;


@Service("signService")
public class SignServiceImpl extends ServiceImpl<SignDao, SignEntity> implements SignService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SignEntity> page = this.page(
                new Query<SignEntity>().getPage(params),
                new QueryWrapper<SignEntity>()
        );

        return new PageUtils(page);
    }

}