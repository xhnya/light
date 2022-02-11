package com.xhn.light.game.service.impl;

import com.xhn.light.game.entity.vo.RankAdminListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.RankDao;
import com.xhn.light.game.entity.RankEntity;
import com.xhn.light.game.service.RankService;


@Service("rankService")
public class RankServiceImpl extends ServiceImpl<RankDao, RankEntity> implements RankService {

    @Autowired
    private RankDao rankDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RankEntity> page = this.page(
                new Query<RankEntity>().getPage(params),
                new QueryWrapper<RankEntity>().eq("type",params.get("type"))
                        .orderByAsc("sort")
        );

        return new PageUtils(page);
    }

    @Override
    public List<RankAdminListVo> getRankAdminList(Integer type) {
        return rankDao.getRankAdminList(type);
    }

}