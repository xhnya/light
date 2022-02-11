package com.xhn.light.community.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.utils.Result;
import com.xhn.light.community.client.GameFeignService;
import com.xhn.light.community.client.UserFeignService;
import com.xhn.light.community.entity.vo.ArticleAdminListQueryVo;
import com.xhn.light.community.entity.vo.ArticleAdminListVo;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public PageUtils selectPageAdminList(ArticleAdminListQueryVo params) {
        Page<ArticleEntity> page = new Page<>(params.getPage(),params.getLimit());
        List<ArticleAdminListVo> result=articleDao.selectPageAdminList(page,params);
        List<Long> gameList = new ArrayList<>();
        List<Long> userList = new ArrayList<>();
        List<Long>  typeList= new ArrayList<>();
        for (ArticleAdminListVo articleAdminListVo : result) {
            userList.add(articleAdminListVo.getUser());
            if (articleAdminListVo.getTypeId()==1){
                gameList.add(articleAdminListVo.getParentId());
            }else {
                typeList.add(articleAdminListVo.getParentId());
            }

        }
        List<PageOfGameName> userNameList=userFeignService.getUserFromAdminCommunity(userList);
        List<PageOfGameName> gameName = gameFeignService.gatGameNameByIdsForCommunity(gameList);
        log.info("gameName================>"+gameName);
        log.info("userNameList================>"+userNameList);
        for (ArticleAdminListVo articleAdminListVo : result) {
            if (gameName!=null){
                for (int i = 0; i < gameName.size(); i++) {
                    if (gameName.get(i).getId()==articleAdminListVo.getParentId()){
                        articleAdminListVo.setParentName(gameName.get(i).getName());
                    }
                }
            }
            if (userNameList!=null){
                for (int i = 0; i < userNameList.size(); i++) {
                    if (userNameList.get(i).getId()==articleAdminListVo.getUser()){
                        articleAdminListVo.setUserName(userNameList.get(i).getName());
                    }
                }
            }
        }

        return new PageUtils(result,(int)page.getTotal(),(int)page.getSize(),(int)page.getPages());
    }

}