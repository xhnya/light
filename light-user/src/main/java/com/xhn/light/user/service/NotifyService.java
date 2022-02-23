package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.user.entity.NotifyEntity;

import java.util.Map;

/**
 * 用户通知表,包含了所有用户的消息
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 09:36:31
 */
public interface NotifyService extends IService<NotifyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Long getNoReadNums(Long userId);
}

