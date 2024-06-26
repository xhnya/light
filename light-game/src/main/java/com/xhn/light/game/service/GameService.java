package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.pojo.PageOfGameName;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.GameEntity;
import com.xhn.light.game.entity.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 游戏表
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
public interface GameService extends IService<GameEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils gameList(Map<String, Object> params);

    GameInfoVo getGameInfo(Long id);

    List<PageOfGameName> gatGameNameByIdsForCommunity(List<Long> ids);

    List<ReleaseOrHotGameList> getNewReleaseGame();

    GameInfoView gameInfo(Long id);

    List<TypeGameListView> getGameTypeForType(Long id);

    List<TypeGameListView> getGameTypeForTypeTop(Long id);

    List<AllGameListView> getAllGameList();

    List<RecommendListView> getWikiGameList();
}

