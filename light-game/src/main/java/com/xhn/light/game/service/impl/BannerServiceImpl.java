package com.xhn.light.game.service.impl;

import com.xhn.light.common.utils.Constant;
import com.xhn.light.game.entity.vo.GameAdminBannerVo;
import com.xhn.light.game.entity.vo.GameBannerInfoListVo;
import com.xhn.light.game.entity.vo.GameBannerListVo;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerEntity> implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BannerEntity> page = this.page(
                new Query<BannerEntity>().getPage(params),
                new QueryWrapper<BannerEntity>().eq(params.get("id") != null, "game_id", params.get("id"))
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getGameBannerList(Map<String, Object> params) {
        IPage<BannerEntity> page = new Query<BannerEntity>().getPage(params);
        QueryWrapper<BannerEntity> wrapper = new QueryWrapper<>();
        wrapper.groupBy("game_id");
        List<BannerEntity> list = baseMapper.selectList(wrapper);
        List<GameBannerListVo> result = bannerDao.getGameBannerList(page);
        log.info(String.valueOf(list.size()));
        return new PageUtils(result, Math.toIntExact(list.size()), (int) page.getSize(), (int) page.getCurrent());
    }

    @Override
    public List<GameAdminBannerVo> getGameBannerUrl(Long id) {
        return bannerDao.getGameBannerUrl(id);
    }

    @Override
    public PageUtils getGameBannerUrlByGameId(Map<String, Object> params) {
        IPage<BannerEntity> page = new Query<BannerEntity>().getPage(params);
        long gameId=1L;
        if (params.get("gameId") != null) {
            gameId=Long.parseLong((String)params.get("gameId"));
        } else {
            gameId = 1L;
        }
        QueryWrapper<BannerEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("game_id",gameId);
        Long count = baseMapper.selectCount(wrapper);

        List<GameBannerInfoListVo> result = bannerDao.getGameBannerUrlByGameId(page, gameId);
        return new PageUtils(result, Math.toIntExact(count), (int) page.getSize(), (int) page.getCurrent());
    }

}