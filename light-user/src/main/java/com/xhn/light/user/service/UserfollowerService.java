package com.xhn.light.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.user.entity.UserfollowerEntity;

import java.util.Map;

/**
 * 用户粉丝
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
public interface UserfollowerService extends IService<UserfollowerEntity> {

    PageUtils queryPage(Map<String, Object> params,Long userId);
}

