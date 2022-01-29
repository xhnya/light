package com.xhn.light.game.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xhn.light.game.entity.BannerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.game.entity.vo.GameAdminBannerVo;
import com.xhn.light.game.entity.vo.GameBannerListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 游戏详情banner图
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@Mapper
public interface BannerDao extends BaseMapper<BannerEntity> {

    List<GameBannerListVo> getGameBannerList(IPage<BannerEntity> page);

    List<GameAdminBannerVo> getGameBannerUrl(Long id);
}
