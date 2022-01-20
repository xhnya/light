package com.xhn.light.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.xhn.light.admin.entity.BannerEntity;
import com.xhn.light.common.utils.PageUtils;

import java.util.Map;

/**
 * 首页banner管理
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-20 20:37:25
 */
public interface BannerService extends IService<BannerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

