package com.xhn.light.admin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 注册人数统计表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-15 10:45:41
 */
@Data
@TableName("sys_register_count")
public class RegisterCountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 人数
	 */
	private Integer nums;
	/**
	 * 当天日期
	 */
	private String days;
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
	 * 类型（默认0，是日，1星期，2月，3年）
	 */
	private Integer type;

}
