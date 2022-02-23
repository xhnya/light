package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 私信信息表,包含了所有用户的私信信息
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-23 10:23:42
 */
@Data
@TableName("ums_message")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 对应通知消息的id
	 */
	private Long notifyId;
	/**
	 * 发送者用户ID
	 */
	private Long senderId;
	/**
	 * 接受者用户ID
	 */
	private Long reciverId;
	/**
	 * 消息内容,最长长度不允许超过1000
	 */
	private String content;
	/**
	 * 创建时间:按当前时间自动创建
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
