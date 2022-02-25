package com.xhn.light.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.admin.entity.CountEntity;

import java.util.Map;

/**
 * 统计表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 01:59:05
 */
public interface CountService extends IService<CountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

