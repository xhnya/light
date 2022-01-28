package com.xhn.light.game.service.impl;

import com.xhn.light.game.entity.vo.GameBannerListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.BannerDao;
import com.xhn.light.game.entity.BannerEntity;
import com.xhn.light.game.service.BannerService;


@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerEntity> implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BannerEntity> page = this.page(
                new Query<BannerEntity>().getPage(params),
                new QueryWrapper<BannerEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getGameBannerList(Map<String, Object> params) {
        IPage<BannerEntity> page = new Query<BannerEntity>().getPage(params);

        List<GameBannerListVo> result=bannerDao.getGameBannerList(page);
        return new PageUtils(result,result.size(), (int) page.getSize(), (int) page.getCurrent());
    }

}