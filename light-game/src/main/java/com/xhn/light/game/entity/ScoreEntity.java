package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏评分表

 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@Data
@TableName("gms_score")
public class ScoreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	private Long gameId;
	/**
	 * 游戏分数
	 */
	private Integer gameScore;
	/**
	 * 评分类型
	 */
	private Integer type;
	/**
	 * 评分人
	 */
	private String scoreName;
	/**
	 * 评分描述
	 */
	private String scoreDescribe;
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
	 * 排序
	 */
	private Integer sort;

}
