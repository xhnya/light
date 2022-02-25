package com.xhn.light.game.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.xhn.light.game.dao.UserGameDao;
import com.xhn.light.game.entity.UserGameEntity;
import com.xhn.light.game.service.UserGameService;


@Service("userGameService")
public class UserGameServiceImpl extends ServiceImpl<UserGameDao, UserGameEntity> implements UserGameService {

    @Autowired
    private UserGameDao userGameDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserGameEntity> page = this.page(
                new Query<UserGameEntity>().getPage(params),
                new QueryWrapper<UserGameEntity>()
        );

        return new PageUtils(page);
    }

}