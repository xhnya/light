package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏推荐表
 * @TableName gms_recommend
 */
@TableName(value ="gms_recommend")
@Data
public class RecommendEntity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 游戏id
     */
    private Long gameId;

    /**
     * 0推荐游戏，1为优惠促销，2为首页热门，3为最受期待，4为最近热门
     */
    private Byte type;

    /**
     * 状态
     */
    private Byte state;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}