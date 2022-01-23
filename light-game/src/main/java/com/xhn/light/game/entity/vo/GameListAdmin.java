package com.xhn.light.game.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xhn
 * @date 2022/1/23 20:26
 * @description: 后台管理的游戏列表
 */
@Data
public class GameListAdmin {
    private Long id;
    /**
     * 游戏名称
     */
    private String gameName;
    /**
     * 官网链接
     */
    private String website;
    /**
     * 封面图
     */
    private String coverUrl;
    /**
     * 发行时间
     */
    private Date releaseTime;
    /**
     * 中文名
     */
    private String gameNameChina;
    /**
     * 描述
     */
    private String gameDescribe;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 游戏类型
     */
    private String gameType;
    /**
     * 制作商
     */
    private String gameMaking;
    /**
     * 发行商
     */
    private String gameIssue;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
    /**
     * 是否热门
     */
    private Integer isHot;
    /**
     * 背景图
     */
    private String bgUrl;
    /**
     * 主要图片
     */
    private String imgUrl;
    /**
     * 排序
     */
    private Integer sort;
}
