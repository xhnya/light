package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 私信
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Data
@TableName("ums_message")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 对话的uuid
	 */
	private String chatMessageToUuid;
	/**
	 * 私信消息数据
	 */
	private String chatMessageData;
	/**
	 * 类型，管理员之类的
	 */
	private String chatMessageType;
	/**
	 * 0未读，1已读
	 */
	private Integer chatMessageIsRead;
	/**
	 * in为接收到的消息，out为发出的消息
	 */
	private String chatMessageIo;
	/**
	 * 发给谁
	 */
	private Long userTo;
	/**
	 * 谁发来
	 */
	private Long userForm;
	/**
	 * 
	 */
	private Date createTime;

}
