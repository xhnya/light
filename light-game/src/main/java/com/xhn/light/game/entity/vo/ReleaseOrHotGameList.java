package com.xhn.light.game.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author xhn
 * @date 2022/2/13 17:25
 * @description: 首页的最近发布热门大作数据返回封装
 */
@Data
public class ReleaseOrHotGameList {

    private Long id;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date time;
    private String cover;
}
