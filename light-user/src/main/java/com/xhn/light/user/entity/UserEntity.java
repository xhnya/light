package com.xhn.light.user.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户重要信息
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-10 17:28:33
 */
@Data
@TableName("ums_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 用户代码
	 */
	private String code;
	/**
	 * 手机号码
	 */
	private String phonenumber;
	/**
	 * 用户性别（0男 1女 2未知）
	 */
	private String sex;
	/**
	 * 头像路径
	 */
	private String avatar;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐加密
	 */
	private String salt;
	/**
	 * 帐号状态（0正常 1停用）
	 */
	private String yesapiRySysUserStatus;
	/**
	 * 删除标志（0代表存在 2代表删除）
	 */
	private String delFlag;
	/**
	 * 最后登录IP
	 */
	private String loginIp;
	/**
	 * 最后登录时间
	 */
	private Date loginDate;
	/**
	 * 密码最后更新时间
	 */
	private Date pwdUpdateDate;
	/**
	 * 创建者
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新者
	 */
	private String updateBy;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户昵称
	 */
	private String userName;
	/**
	 * 用户类型（00系统用户 01注册用户）
	 */
	private String userType;
	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
