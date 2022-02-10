package com.xhn.light.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.common.utils.Result;
import com.xhn.light.community.client.GameFeignService;
import com.xhn.light.community.entity.vo.ArticleAdminListQueryVo;
import com.xhn.light.community.entity.vo.ArticleAdminListVo;
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

import com.xhn.light.community.dao.ArticleDao;
import com.xhn.light.community.entity.ArticleEntity;
import com.xhn.light.community.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private GameFeignService gameFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ArticleEntity> page = this.page(
                new Query<ArticleEntity>().getPage(params),
                new QueryWrapper<ArticleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils selectPageAdminList(ArticleAdminListQueryVo params) {
        Page<ArticleEntity> page = new Page<>(params.getPage(),params.getLimit());
        List<ArticleAdminListVo> result=articleDao.selectPageAdminList(page,params);
        List<Long> gameList = new ArrayList<>();
        List<Long> userList = new ArrayList<>();
        for (ArticleAdminListVo articleAdminListVo : result) {
            gameList.add(articleAdminListVo.getParentId());
            userList.add(articleAdminListVo.getUser());
        }
        List<String> gameName = gameFeignService.gatGameNameByIdsForCommunity(gameList);
        //TODO: 用户和社区，社区需要判断是什么类型才能继续


        return new PageUtils(result,(int)page.getTotal(),(int)page.getSize(),(int)page.getPages());
    }

}