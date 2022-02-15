package com.xhn.light.admin.dao;

import com.xhn.light.admin.entity.RegisterCountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 注册人数统计表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-15 10:45:41
 */
@Mapper
public interface RegisterCountDao extends BaseMapper<RegisterCountEntity> {
	
}
