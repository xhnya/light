package com.xhn.light.community.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户历史表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-20 11:54:21
 */
@Data
@TableName("cms_history")
public class HistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	private Long pid;


	private Date watchDays;
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
