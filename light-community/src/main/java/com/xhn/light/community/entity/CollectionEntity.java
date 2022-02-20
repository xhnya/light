package com.xhn.light.community.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收藏夹内容
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 15:05:34
 */
@Data
@TableName("cms_collection")
public class CollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 所属的收藏夹
	 */
	private Long parentId;
	/**
	 * 收藏的id
	 */
	private Long contentId;
	/**
	 * 
	 */
	private Integer isDel;
	/**
	 * 
	 */
	private Integer start;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
