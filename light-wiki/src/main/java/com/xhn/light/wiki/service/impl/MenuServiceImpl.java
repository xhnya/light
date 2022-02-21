package com.xhn.light.wiki.service.impl;

import com.xhn.light.wiki.service.PageService;
import com.xhn.light.wiki.vo.MenuListView;
import com.xhn.light.wiki.vo.MenuListVo;
import com.xhn.light.wiki.vo.SaveMenuAndPageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.wiki.dao.MenuDao;
import com.xhn.light.wiki.entity.MenuEntity;
import com.xhn.light.wiki.service.MenuService;
import org.springframework.transaction.annotation.Transactional;


@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private PageService pageService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MenuEntity> page = this.page(
                new Query<MenuEntity>().getPage(params),
                new QueryWrapper<MenuEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 构成树节点TODO: 可以优化，参考谷粒商场的树
     * @param id
     * @return
     */
    @Override
    public List<MenuListView> getMenuList(Long id) {
        List<MenuListView> menuListView = new ArrayList<>();
        List<MenuListVo> result = menuDao.getMenuList(id);
        //设置第一级
        for (MenuListVo menu : result) {
            MenuListView view = new MenuListView();
            if (menu.getParentId()==null){
                view.setId(menu.getId());
                view.setName(menu.getName());
                view.setEditType(menu.getEditType());
                menuListView.add(view);
            }
        }
        for (MenuListView listView : menuListView) {
            List<MenuListView> children = new ArrayList<>();
            for (MenuListVo menuListVo : result) {
                if (menuListVo.getParentId()==listView.getId()){
                    MenuListView menuListView1 = new MenuListView();
                    menuListView1.setId(menuListVo.getId());
                    menuListView1.setPid(menuListVo.getPid());
                    menuListView1.setEditType(menuListVo.getEditType());
                    menuListView1.setCover(menuListVo.getCover());
                    menuListView1.setName(menuListVo.getName());
                    children.add(menuListView1);
                }
            }
            listView.setChildren(children);
        }

        return menuListView;
    }
    @Transactional
    @Override
    public void saveMenuAndPage(SaveMenuAndPageParam params) {
        Long id=pageService.saveMenuAndPage(params);
        MenuEntity menu = new MenuEntity();
        menu.setCover(params.getCover());
        menu.setGid(params.getGameId());
        menu.setParentId(params.getMenuId());
        menu.setName(params.getTitle());
        menu.setPid(id);
        menuDao.insert(menu);
    }

}