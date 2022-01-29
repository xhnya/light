package com.xhn.light.game.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description: 游戏banner列表封装
 * @author: xhn
 * @date: 2022/1/28 9:51
 */
@Data
public class GameBannerListVo {
    //banner的id
    private Long id;

    private Long gameId;

    private String gameName;

    private Integer nums;
    private Integer isDel;

    private List<String> imgUrl;

    private Date createTime;

    private Date updateTime;

}
