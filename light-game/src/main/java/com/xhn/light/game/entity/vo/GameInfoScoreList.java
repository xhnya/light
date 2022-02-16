package com.xhn.light.game.entity.vo;

import lombok.Data;

/**
 * @author ：xhn
 * @date ：2022/2/16 9:30
 * @description：
 */
@Data
public class GameInfoScoreList {
    private Long id;
    private Integer gameScore;
    /**
     * 评分人
     */
    private String scoreName;
    /**
     * 评分描述
     */
    private String scoreDescribe;
}
