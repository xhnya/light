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
 * @date 2022-02-10 17:28:33
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
	 * 密码
	 */
	private String password;
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
	 * 最后一次登录时间
	 */
	private Date lastLogin;
	/**
	 * 登录的ip地址
	 */
	private String loginIp;
	/**
	 * 尝试登录，未登录成功次数
	 */
	private Integer attempts;
	/**
	 * 最后尝试登陆未成功时间
	 */
	private Date attemptsTime;
	/**
	 * 注册日期时间
	 */
	private Date createTime;
	/**
	 * 用户状态 1正常状态 2 删除至回收站 3锁定
	 */
	private Integer userStatus;
	/**
	 * 
	 */
	private Date updateTime;

}
