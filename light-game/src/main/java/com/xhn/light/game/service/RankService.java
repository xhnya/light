package com.xhn.light.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhn.light.common.utils.PageUtils;
import com.xhn.light.game.entity.RankEntity;
import com.xhn.light.game.entity.vo.GameRankList;
import com.xhn.light.game.entity.vo.RankAdminListVo;

import java.util.List;
import java.util.Map;

/**
 * 游戏排行榜
 *
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
public interface RankService extends IService<RankEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RankAdminListVo> getRankAdminList(Integer type);

    List<GameRankList> getHotGameRankList(Integer type);
}

