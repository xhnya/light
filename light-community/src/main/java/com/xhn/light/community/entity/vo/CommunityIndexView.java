package com.xhn.light.community.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ：xhn
 * @date ：2022/2/14 10:28
 * @description： 社区主界面返回数据的封装
 */
@Data
public class CommunityIndexView {
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
    private Integer collection;
    private Integer likes;
    private Integer countComment;
}
