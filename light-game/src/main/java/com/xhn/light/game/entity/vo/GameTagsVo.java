package com.xhn.light.game.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author xhn
 * @date 2022/1/23 18:15
 * @description: 获取传入的游戏和标签对应的数据
 */
@Data
public class GameTagsVo {
    private Long gameId;
    private List<Long> tagsList;
}
