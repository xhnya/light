package com.xhn.light.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.admin.entity.RegisterCountEntity;

import java.util.Map;

/**
 * 注册人数统计表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-15 10:45:41
 */
public interface RegisterCountService extends IService<RegisterCountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

