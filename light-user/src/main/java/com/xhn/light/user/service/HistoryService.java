package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.user.entity.HistoryEntity;

import java.util.Map;

/**
 * 用户历史表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 11:42:28
 */
public interface HistoryService extends IService<HistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

