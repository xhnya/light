package com.xhn.light.community.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章分类表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Data
@TableName("cms_type")
public class TypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 分类名
	 */
	private String typeName;
	/**
	 * 父id
	 */
	private Long parentId;
	/**
	 * 状态，拿来当类型字段，如果是0则是游戏
	 *
	 *
	 *
	 */
	private Integer status;
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
	 * 
	 */
	private Integer isDel;

}
