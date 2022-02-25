package com.xhn.light.admin.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 邮件订阅表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 01:59:05
 */
@Data
@TableName("sys_subscribe")
public class SubscribeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 
	 */
	private String email;

}
