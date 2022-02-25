package com.xhn.light.game.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户关注的游戏
 * 
 * @author xhn
 * @email 930957853@qq.com
 * @date 2022-02-26 00:27:04
 */
@Data
@TableName("gms_user_game")
public class UserGameEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 
	 */
	private Long gid;
	/**
	 * 
	 */
	private Long uid;

}
