package com.xhn.light.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import com.xhn.light.admin.entity.SysUserEntity;

import java.util.Map;

/**
 * 
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-10 18:13:58
 */
public interface SysUserService extends IService<SysUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

