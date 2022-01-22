package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏类型表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:17
 */
@Data
@TableName("gms_type")
public class TypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 
	 */
	private String typeName;
	/**
	 * 
	 */
	private Integer sort;
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

}
