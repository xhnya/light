package com.xhn.light.wiki.dao;

import com.xhn.light.wiki.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.wiki.vo.MenuListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 百科菜单表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@Mapper
public interface MenuDao extends BaseMapper<MenuEntity> {

    List<MenuListVo> getMenuList(Long id);
}
