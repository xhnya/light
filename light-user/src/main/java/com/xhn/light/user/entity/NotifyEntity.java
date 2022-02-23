package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户通知表,包含了所有用户的消息
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 09:36:31
 */
@Data
@TableName("ums_notify")
public class NotifyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 发送者用户ID
	 */
	private Long senderId;
	/**
	 * 接受者用户ID
	 */
	private Long reciverId;
	/**
	 * 消息类型:announcement公告/remind提醒/message私信
	 */
	private String type;
	/**
	 * 是否已读,0未读,1已读
	 */
	private Boolean isRead;
	/**
	 * 创建时间:按当前时间自动创建
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
