package com.xhn.light.community.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class ArticleAdminListVo {
    /**
     *
     */
    private Long id;
    /**
     * 所属社区的id
     */
    private Long parentId;
    private String parentName;
    /**
     * 用户id，外键
     */
    private Long user;
    private String userName;
    /**
     * 标题
     */
    private String title;

    /**
     * 点击量
     */
    private Integer clickNum;
    /**
     * 发表日期
     */
    private Date createTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 是否推荐
     */
    private Integer recommended;
    /**
     *
     */
    private Date updateTime;
    /**
     * 是否热门
     */
    private Integer isHot;
    private Long typeId;
}
