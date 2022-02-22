package com.xhn.light.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.wiki.entity.PageEntity;
import com.xhn.light.wiki.vo.SaveMenuAndPageParam;

import java.util.Map;

/**
 * 页面内容
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
public interface PageService extends IService<PageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    Long saveMenuAndPage(SaveMenuAndPageParam params);
}

