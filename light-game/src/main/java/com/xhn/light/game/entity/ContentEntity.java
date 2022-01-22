package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏评论表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-01-22 16:36:16
 */
@Data
@TableName("gms_content")
public class ContentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 评论人
	 */
	private Long userId;
	/**
	 * 评论人
	 */
	private String userName;
	/**
	 * 评论头像
	 */
	private String cover;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 父评论
	 */
	private Long parentId;
	/**
	 * 游戏id
	 */
	private Long gameId;
	/**
	 * 是否热门，默认为0
	 */
	private Integer isHot;
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
