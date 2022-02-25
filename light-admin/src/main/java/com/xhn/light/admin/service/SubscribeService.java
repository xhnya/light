package com.xhn.light.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.admin.entity.SubscribeEntity;

import java.util.Map;

/**
 * 邮件订阅表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 01:59:05
 */
public interface SubscribeService extends IService<SubscribeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

