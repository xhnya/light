package com.xhn.light.game.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author xhn
 * @date 2022/2/11 22:23
 * @description: 首页榜单列表显示
 */
@Data
public class GameRankList {
    private Long id;
    /**
     *
     */
    private Long gameId;
    /**
     *
     */
    private Integer sort;
    private Date createTime;
    /**
     * 榜单类型
     */
    private Integer type;
    /**
     * 游戏类型
     */
    private String gameType;
    /**
     * 中文名
     */
    private String gameNameChina;
    /**
     * 封面图
     */
    private String coverUrl;
    /**
     * 游戏名称
     */
    private String gameName;
    /**
     * 发行时间
     */
    private Date releaseTime;
    private String hotNums;
}
