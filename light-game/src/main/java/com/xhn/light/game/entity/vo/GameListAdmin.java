package com.xhn.light.game.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xhn
 * @date 2022/1/23 20:26
 * @description: 后台管理的游戏列表,用于后台展示游戏类表的封装类
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
     * 发行时间
     */
    private Date releaseTime;
    /**
     * 中文名
     */
    private String gameNameChina;

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
     * 是否热门
     */
    private Integer isHot;
    /**
     * 排序
     */
    private Integer sort;
}
