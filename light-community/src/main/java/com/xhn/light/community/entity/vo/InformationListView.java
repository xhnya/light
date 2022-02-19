package com.xhn.light.community.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author xhn
 * @date 2022/2/18 21:31
 * @description:
 */
@Data
public class InformationListView {

    /**
     * 用户头像
     */
    private String cover;
    /**
     * 文章的id
     */
    private Long id;
    private Long userId;
    private String name;
    private String title;
    private Date time;
    private String content;
    private String url;
    private Integer collection;
    private Integer likes;
    private Integer countComment;
}
