package com.xhn.light.community.entity.vo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/20 23:24
 * @description:
 */
@Data
public class GameCommunityParams {
    private Long gameId;
    private Integer limit=10;
    private Integer page=1;
    private Integer isHot;
    private String title;
    private String publishType;
}
