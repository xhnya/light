package com.xhn.light.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.pojo.PageParam;
import com.xhn.light.common.pojo.UserAnPageView;
import com.xhn.light.common.utils.*;
import com.xhn.light.community.client.GameFeignService;
import com.xhn.light.community.client.UserFeignService;
import com.xhn.light.community.entity.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xhn.light.community.dao.ArticleDao;
import com.xhn.light.community.entity.ArticleEntity;
import com.xhn.light.community.service.ArticleService;

@Slf4j
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private GameFeignService gameFeignService;
    @Autowired
    private UserFeignService userFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ArticleEntity> page = this.page(
                new Query<ArticleEntity>().getPage(params),
                new QueryWrapper<ArticleEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 后台管理的页面列表显示，进行了远程调用
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils selectPageAdminList(ArticleAdminListQueryVo params) {
        Page<ArticleEntity> page = new Page<>(params.getPage(), params.getLimit());
        List<ArticleAdminListVo> result = articleDao.selectPageAdminList(page, params);
        //为远程调用提供参数
        List<Long> userList = new ArrayList<>();
        for (ArticleAdminListVo articleAdminListVo : result) {
            userList.add(articleAdminListVo.getUser());
        }
        //远程调用
        List<PageOfGameName> userNameList = userFeignService.getUserFromAdminCommunity(userList);
        log.info("userNameList================>" + userNameList);
        //给现在的属性赋值
        for (ArticleAdminListVo articleAdminListVo : result) {
            if (userNameList != null) {
                for (int i = 0; i < userNameList.size(); i++) {
                    if (userNameList.get(i).getId() == articleAdminListVo.getUser()) {
                        articleAdminListVo.setUserName(userNameList.get(i).getName());
                    }
                }
            }
        }

        return new PageUtils(result, (int) page.getTotal(), (int) page.getSize(), (int) page.getCurrent());
    }

    @Override
    public List<IndexHotPageList> selectIndexHotPageList() {
        return articleDao.selectIndexHotPageList();
    }

    @Override
    public PageUtils selectCommunityIndexView(CommunityIndexListParam params) {

        Page<ArticleEntity> page = new Page<>(params.getPage(), params.getLimit());

        List<CommunityIndexView> result = articleDao.selectCommunityIndexView(page, params);
        List<Long> list = new ArrayList<>();
        for (CommunityIndexView view : result) {
            list.add(view.getUserId());
        }
        List<UserAnPageView> userInfoList = userFeignService.getCommunityIndex(list);
        for (CommunityIndexView view : result) {
            if (userInfoList != null) {
                for (int i = 0; i < userInfoList.size(); i++) {
                    UserAnPageView userAnPageView = userInfoList.get(i);
                    if (userAnPageView.getId() == view.getUserId()) {
                        view.setName(userAnPageView.getUserName());
                        view.setCover(userAnPageView.getCover());
                    }
                }
            }
        }

        return new PageUtils(result, (int) page.getTotal(), (int) page.getSize(), (int) page.getPages());
    }

    @Override
    public List<IndexHotPageList> getGamePageInfoLit() {

        return articleDao.getGamePageInfoLit();
    }

    @Override
    public List<IndexHotPageList> getUserNeedKnow() {
        return articleDao.getUserNeedKnow();
    }

    @Override
    public PageUtils getInformation(Map<String, Object> params) {
        Page pages = new PageParamsUtils().getPage(params);
        Page<ArticleEntity> page = new Page<>(pages.getCurrent(), pages.getSize());
        List<InformationListView> result = articleDao.getInformation(page);
        List<Long> list = new ArrayList<>();
        for (InformationListView view : result) {
            list.add(view.getUserId());
        }
        List<UserAnPageView> userInfoList = userFeignService.getCommunityIndex(list);
        for (InformationListView view : result) {
            if (userInfoList != null) {
                for (int i = 0; i < userInfoList.size(); i++) {
                    UserAnPageView userAnPageView = userInfoList.get(i);
                    if (userAnPageView.getId() == view.getUserId()) {
                        view.setName(userAnPageView.getUserName());
                        view.setCover(userAnPageView.getCover());
                    }
                }
            }
        }
        return new PageUtils(result, (int) page.getTotal(), (int) page.getSize(), (int) page.getPages());
    }

    @Override
    public List<CommunityListViewForIndex> getSelectPage() {
        return articleDao.getSelectPage();
    }

    @Override
    public PageUtils getInformationByGameId(InformationByGameIdParam param) {
        Page<ArticleEntity> page = new Page<>(param.getPage(), param.getLimit());
        List<InformationListView> result = articleDao.getInformationByGameId(page,param);
        List<Long> list = new ArrayList<>();
        for (InformationListView view : result) {
            list.add(view.getUserId());
        }
        List<UserAnPageView> userInfoList = userFeignService.getCommunityIndex(list);
        for (InformationListView view : result) {
            if (userInfoList != null) {
                for (int i = 0; i < userInfoList.size(); i++) {
                    UserAnPageView userAnPageView = userInfoList.get(i);
                    if (userAnPageView.getId() == view.getUserId()) {
                        view.setName(userAnPageView.getUserName());
                        view.setCover(userAnPageView.getCover());
                    }
                }
            }
        }
        return new PageUtils(result, (int) page.getTotal(), (int) page.getSize(), (int) page.getPages());
    }

    @Override
    public PageUtils getMyPageList(CommunityIndexListParam param, Long userId) {
        Page<ArticleEntity> page = new Page<>(param.getPage(),param.getLimit());
        List<MyListView> result=articleDao.getMyList(page,userId);
        return new PageUtils(result, (int) page.getTotal(), (int) page.getSize(), (int) page.getCurrent());
    }

    @Override
    public PageUtils getGameCommunityList(GameCommunityParams params) {
        Page<ArticleEntity> page = new Page<>(params.getPage(), params.getLimit());
        List<CommunityIndexView> result = articleDao.getGameCommunityList(page, params);
        List<Long> list = new ArrayList<>();
        for (CommunityIndexView view : result) {
            list.add(view.getUserId());
        }
        List<UserAnPageView> userInfoList = userFeignService.getCommunityIndex(list);
        for (CommunityIndexView view : result) {
            if (userInfoList != null) {
                for (int i = 0; i < userInfoList.size(); i++) {
                    UserAnPageView userAnPageView = userInfoList.get(i);
                    if (userAnPageView.getId() == view.getUserId()) {
                        view.setName(userAnPageView.getUserName());
                        view.setCover(userAnPageView.getCover());
                    }
                }
            }
        }

        return new PageUtils(result, (int) page.getTotal(), (int) page.getSize(), (int) page.getPages());
    }

    @Override
    public List<IdAndName> gameInfoList(Long id) {
        return articleDao.gameInfoList(id);
    }

}