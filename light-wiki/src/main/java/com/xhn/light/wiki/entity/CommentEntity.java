package com.xhn.light.wiki.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 页面评论
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@Data
@TableName("wms_comment")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 页面ID
	 */
	private Long pageId;
	/**
	 * 父评论ID
	 */
	private Long parentId;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 赞的数量
	 */
	private Integer zanNum;
	/**
	 * 创建人ID
	 */
	private Long createUserId;
	/**
	 * 创建人名字
	 */
	private String createUserName;
	/**
	 * 0=有效 1=删除
	 */
	private Integer delFlag;

}
