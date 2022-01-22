package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.TagsEntity;

import java.util.Map;

/**
 * 游戏标签表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:15:00
 */
public interface TagsService extends IService<TagsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

