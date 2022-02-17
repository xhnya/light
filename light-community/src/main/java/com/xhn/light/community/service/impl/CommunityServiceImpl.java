package com.xhn.light.community.service.impl;

import com.xhn.light.community.entity.vo.SelectCommunityView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.community.dao.CommunityDao;
import com.xhn.light.community.entity.CommunityEntity;
import com.xhn.light.community.service.CommunityService;


@Service("communityService")
public class CommunityServiceImpl extends ServiceImpl<CommunityDao, CommunityEntity> implements CommunityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommunityEntity> page = this.page(
                new Query<CommunityEntity>().getPage(params),
                new QueryWrapper<CommunityEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * TODO：如果是前台页面不显示系统，或者系统选择性显示
     * TODO: 查3次数据库进行封装有没有更好
     * @return
     */
    @Override
    public List<SelectCommunityView> getCommunityCascader() {
        List<CommunityEntity> list = baseMapper.selectList(null);
        SelectCommunityView view0 = new SelectCommunityView();
        SelectCommunityView view1 = new SelectCommunityView();
        SelectCommunityView view2 = new SelectCommunityView();

        view0.setValue(0L);
        view0.setLabel("推荐");
        view1.setValue(1L);
        view1.setLabel("游戏");
        view2.setValue(2L);
        view2.setLabel("系统");
        List<SelectCommunityView> children1 = new ArrayList<>();
        List<SelectCommunityView> children2 = new ArrayList<>();
        List<SelectCommunityView> children3 = new ArrayList<>();
        for (CommunityEntity community : list) {
            SelectCommunityView view3 = new SelectCommunityView();
            if (community.getType()==0){
//                游戏类
                view3.setLabel(community.getName());
                view3.setValue(community.getId());
                children1.add(view3);
            }else if(community.getType()==1){
//                推荐类
                view3.setLabel(community.getName());
                view3.setValue(community.getId());
                children2.add(view3);
            }else if(community.getType()==2){
//                系统类
                view3.setLabel(community.getName());
                view3.setValue(community.getId());
                children3.add(view3);
            }

        }
        view0.setChildren(children2);
        view1.setChildren(children1);
        view2.setChildren(children3);
        List<SelectCommunityView> result = new ArrayList<>();
        result.add(view0);
        result.add(view1);
        result.add(view2);
        return result;
    }

}