package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 游戏表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@Data
@TableName("gms_game")
public class GameEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
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
	 * 详情视频
	 */
	private String videoUrl;
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
