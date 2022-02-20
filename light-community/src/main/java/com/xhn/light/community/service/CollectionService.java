package com.xhn.light.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.community.entity.CollectionEntity;
import com.xhn.light.community.entity.vo.CollectionMyParams;

import java.util.Map;

/**
 * 收藏夹内容
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 15:05:34
 */
public interface CollectionService extends IService<CollectionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils myList(CollectionMyParams params);
}

