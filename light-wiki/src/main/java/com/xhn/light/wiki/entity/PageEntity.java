package com.xhn.light.wiki.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 页面内容
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-21 10:18:51
 */
@Data
@TableName("wms_page")
public class PageEntity implements Serializable {
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
	 * 内容
	 */
	private String content;
	/**
	 * 创建人ID
	 */
	private Long createUserId;
	/**
	 * 创建人名字
	 */
	private String createUserName;
	/**
	 * 修改人ID
	 */
	private Long updateUserId;
	/**
	 * 修改人名字
	 */
	private String updateUserName;
	/**
	 * 预览内容
	 */
	private String preview;
	/**
	 * 
	 */
	private Long parentId;
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
