package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户任务表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Data
@TableName("ums_task")
public class TaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 任务代码
	 */
	private Long taskCode;
	/**
	 * 任务类型
	 */
	private Long type;
	/**
	 * 收益
	 */
	private String profit;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 任务状态
	 */
	private Integer start;
	/**
	 * 
	 */
	private String name;
	/**
	 * 任务描述
	 */
	private String describe;
	/**
	 * 详情的文章
	 */
	private Long parentId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createBy;

}
