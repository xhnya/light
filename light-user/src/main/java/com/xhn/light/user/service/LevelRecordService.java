package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.user.entity.LevelRecordEntity;

import java.util.Map;

/**
 * 用户等级记录表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
public interface LevelRecordService extends IService<LevelRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

