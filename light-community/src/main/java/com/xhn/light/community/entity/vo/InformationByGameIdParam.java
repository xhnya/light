package com.xhn.light.community.entity.vo;

import lombok.Data;

/**
 * @author xhn
 * @date 2022/2/19 15:10
 * @description:
 */
@Data
public class InformationByGameIdParam {
    private Integer page=1;
    private Integer limit=10;
    private Long gameId;
    private String type;
}
