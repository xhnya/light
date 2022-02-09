package com.xhn.light.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.community.entity.CountsEntity;

import java.util.Map;

/**
 * 文章统计表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
public interface CountsService extends IService<CountsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

