package com.xhn.light.wiki.dao;

import com.xhn.light.wiki.entity.PageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 页面内容
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@Mapper
public interface PageDao extends BaseMapper<PageEntity> {
	
}
