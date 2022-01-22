package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.BannerEntity;

import java.util.Map;

/**
 * 游戏详情banner图
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:14:59
 */
public interface BannerService extends IService<BannerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

