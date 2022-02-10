package com.xhn.light.game.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.game.entity.vo.GameInfoVo;
import com.xhn.light.game.entity.vo.GameListAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.common.utils.Query;

import com.xhn.light.game.dao.GameDao;
import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.service.GameService;


@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Autowired
    private GameDao gameDao;

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
        Page<GameEntity> page = new Page<>(1,10);
        List<GameListAdmin> result= gameDao.gameList(page);
        return new PageUtils(result,1,10,result.size());
    }

    @Override
    public GameInfoVo getGameInfo(Long id) {
        return gameDao.getGameInfo(id);
    }

    @Override
    public List<PageOfGameName> gatGameNameByIdsForCommunity(List<Long> ids) {
        return gameDao.gatGameNameByIdsForCommunity(ids);
    }

}