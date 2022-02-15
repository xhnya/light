package com.xhn.light.game.entity.vo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/15 23:26
 * @description: 游戏详情的页面显示
 */
@Data
public class GameInfoView {

    private Long id;
    private String gameName;
    private String typeName;
    private String produceName;
    private String issueName;
    private String releaseTime;
    private String website;
    private String cover;


}
