package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏标签表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@Data
@TableName("gms_tags")
public class TagsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 标签名
	 */
	private String tagName;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	private Integer start;
	/**
	 * 
	 */
	private Integer isDel;
	/**
	 *
	 */
	private Integer sort;
	/**
	 *
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
