package com.xhn.light.game.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author ：xhn
 * @date ：2022/2/18 17:07
 * @description：
 */
@Data
public class AllGameListView {
    private Long id;
    private String name;
    private String describes;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date releaseTime;
    private String nameOther;
    private String makingName;
    private String issueName;
    private String typeName;
    private Integer score;
    private String imgUrl;
}
