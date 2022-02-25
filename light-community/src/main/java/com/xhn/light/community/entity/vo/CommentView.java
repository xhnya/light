package com.xhn.light.community.entity.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ：xhn
 * @date ：2022/2/25 8:51
 * @description：
 */
@Data
public class CommentView {

    private Long id;
    private Long userId;
    private String userName;
    private String cover;
    private String content;
    private Date createTime;
    private String reply;
    private Long parentId;
    private List<CommentView> children;

}
