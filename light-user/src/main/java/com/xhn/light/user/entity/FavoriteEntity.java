package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收藏夹
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Data
@TableName("ums_favorite")
public class FavoriteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 收藏备注
	 */
	private String favoriteContent;
	/**
	 * 收藏名称
	 */
	private String modelName;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * cover
	 */
	private String cover;
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

	/**
	 *
	 */
	private Integer type;

}
