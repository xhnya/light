package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏图片
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 13:14:59
 */
@Data
@TableName("gms_picture")
public class PictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 图片链接
	 */
	private String coverUrl;
	/**
	 * 图集id
	 */
	private Long parentId;
	/**
	 * 是否在首页显示
	 */
	private Integer isShow;
	/**
	 * 排序
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
