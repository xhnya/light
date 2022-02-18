package com.xhn.light.game.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.utils.Constant;
import com.xhn.light.game.dao.*;
import com.xhn.light.game.entity.AwardEntity;
import com.xhn.light.game.entity.BannerEntity;
import com.xhn.light.game.entity.vo.*;
import com.xhn.light.game.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.service.GameService;


@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private AwardDao awardDao;
    @Autowired
    private PictureDao pictureDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GameEntity> page = this.page(
                new Query<GameEntity>().getPage(params),
                new QueryWrapper<GameEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils gameList(Map<String, Object> params) {
        String curr = (String) params.get("page");
        String sizePage = (String) params.get("limit");
        Long curPage=1L;
        Long size=10L;
        if (curr!=null){
             curPage = Long.parseLong(curr);
        }
        if (sizePage!=null){
            size = Long.parseLong(sizePage);
        }
        Page<GameEntity> page = new Page<>(curPage,size);
        List<GameListAdmin> result= gameDao.gameList(page);
        return new PageUtils(result,(int) page.getTotal(),(int) page.getSize(),(int) page.getCurrent());
    }

    @Override
    public GameInfoVo getGameInfo(Long id) {
        return gameDao.getGameInfo(id);
    }

    @Override
    public List<PageOfGameName> gatGameNameByIdsForCommunity(List<Long> ids) {
        return gameDao.gatGameNameByIdsForCommunity(ids);
    }

    @Override
    public List<ReleaseOrHotGameList> getNewReleaseGame() {
        return gameDao.getNewReleaseGame();
    }

    /**
     * 游戏详情数据封装
     * @param id
     * @return
     */
    @Override
    public GameInfoView gameInfo(Long id) {
        GameInfoView result=gameDao.gameInfo(id);
        //轮播图
        List<String> bannerList=bannerDao.getGameInfoList(id);
        if (bannerList!=null){
            result.setBannerList(bannerList);
        }
        List<GameInfoScoreList> scoreList=scoreDao.getGameInfoList(id);
        if (scoreList!=null){
            result.setScoreList(scoreList);
        }
        QueryWrapper<AwardEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("game_id",id);
        wrapper.orderByDesc("sort");
        List<AwardEntity> awardList=awardDao.selectList(wrapper);
        if (awardList!=null){
            result.setAwardList(awardList);
        }
        List<String> pictureList =pictureDao.getGameInfoList(id);
        if (pictureList!=null){
            result.setPictureList(pictureList);
        }
        return result;
    }

    @Override
    public List<TypeGameListView> getGameTypeForType(Long id) {
        return gameDao.getGameTypeForType(id);
    }

    @Override
    public List<TypeGameListView> getGameTypeForTypeTop(Long id) {
        return gameDao.getGameTypeForTypeTop(id);
    }

    @Override
    public List<AllGameListView> getAllGameList() {
        return gameDao.getAllGameList();
    }

}