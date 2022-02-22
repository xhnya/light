package com.xhn.light.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.wiki.entity.MenuEntity;
import com.xhn.light.wiki.vo.MenuListView;
import com.xhn.light.wiki.vo.SaveMenuAndPageParam;

import java.util.List;
import java.util.Map;

/**
 * 百科菜单表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MenuListView> getMenuList(Long id);

    void saveMenuAndPage(SaveMenuAndPageParam params);
}

