package com.xhn.light.game.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author xhn
 * @date 2022/2/19 11:38
 * @description:
 */
@Data
public class ScoreViewForIndex {
    private Long id;
    private Long pageId;
    private String scoreDescribe;
    /**
     * 游戏分数
     */
    private Double gameScore;
    private String url;
    private Date createTime;
    private String scoreName;
}
