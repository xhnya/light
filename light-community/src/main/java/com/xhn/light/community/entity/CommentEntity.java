package com.xhn.light.community.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章-评论表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-09 16:28:26
 */
@Data
@TableName("cms_comment")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 评论人id
	 */
	private Long userId;
	/**
	 * 父评论id
	 */
	private Long parentId;
	/**
	 * 1：文章评论
	 */
	private Integer type;
	/**
	 * 文章id
	 */
	private Integer aid;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 评论日期
	 */
	private Integer date;
	/**
	 * 1:已审核 0：未审核
	 */
	private Integer status;
	/**
	 * 是否删除
	 */
	private Integer isDelete;
	/**
	 * 
	 */
	private Integer floor;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 备注（审核不通过时添加）
	 */
	private String remark;

	private String userName;
	private String userCover;

}
