package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息表
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-14 20:23:45
 */
@Data
@TableName("ums_user_info")
public class UserInfoEntity implements Serializable {
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
	 * 用户名
	 */
	private String userName;
	/**
	 * 手机
	 */
	private String userMobile;
	/**
	 * Email
	 */
	private String userEmail;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 性别1男2女3保密
	 */
	private Integer sex;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 个性签名
	 */
	private String signature;
	/**
	 * 自我介绍
	 */
	private String description;
	/**
	 * 城市
	 */
	private Integer city;
	/**
	 * 联系地址
	 */
	private String contactAddr;
	/**
	 * 邮政编码
	 */
	private String zip;
	/**
	 * QQ
	 */
	private String qq;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 注册日期时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
