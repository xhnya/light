package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.ContentEntity;

import java.util.Map;

/**
 * 游戏评论表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:14:59
 */
public interface ContentService extends IService<ContentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

