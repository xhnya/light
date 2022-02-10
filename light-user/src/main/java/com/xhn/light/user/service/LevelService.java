package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Result;
import com.xhn.light.user.entity.LevelEntity;

import java.util.Map;

/**
 * 等级表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
public interface LevelService extends IService<LevelEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Result saveLevelEntity(LevelEntity level);
}

