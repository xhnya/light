package com.xhn.light.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.community.entity.TagsEntity;

import java.util.Map;

/**
 * 标签表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
public interface TagsService extends IService<TagsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

