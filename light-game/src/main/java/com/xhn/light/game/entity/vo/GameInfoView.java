package com.xhn.light.game.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xhn.light.game.entity.AwardEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xhn
 * @date 2022/2/15 23:26
 * @description: 游戏详情的页面显示
 */
@Data
public class GameInfoView {

    private Long id;
    private String gameName;
    private String gameNameOther;
    private String typeName;
    private String produceName;
    private String issueName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date releaseTime;
    private String website;
    private String cover;
    private Integer lightScore;
    private Integer userScore;
    private String bgUrl;
    private String videoUrl;
    private String gameDescribe;

    private List<String> bannerList;
    private List<GameInfoScoreList>  scoreList;
    private List<AwardEntity> awardList;
    private List<String> pictureList;


}
