package com.xhn.light.game.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.GameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhn.light.game.entity.vo.GameInfoVo;
import com.xhn.light.game.entity.vo.GameListAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 游戏表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@Mapper
public interface GameDao extends BaseMapper<GameEntity> {


    List<GameListAdmin> gameList(Page<GameEntity> page);

    GameInfoVo getGameInfo(Long id);
}
