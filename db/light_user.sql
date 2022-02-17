/*
 Navicat Premium Data Transfer

 Source Server         : xhn
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.8.166:63306
 Source Schema         : light_user

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 17/02/2022 14:18:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ums_collection
-- ----------------------------
DROP TABLE IF EXISTS `ums_collection`;
CREATE TABLE `ums_collection`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '所属的收藏夹',
  `content_id` bigint(20) NULL DEFAULT NULL COMMENT '收藏的id',
  `is_del` tinyint(3) NULL DEFAULT 0,
  `start` tinyint(3) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏夹内容' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_collection
-- ----------------------------

-- ----------------------------
-- Table structure for ums_favorite
-- ----------------------------
DROP TABLE IF EXISTS `ums_favorite`;
CREATE TABLE `ums_favorite`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `favorite_content` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收藏备注',
  `model_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收藏名称',
  `user_id` int(10) NULL DEFAULT 0 COMMENT '用户id',
  `cover` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cover',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_del` tinyint(3) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏夹' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for ums_level
-- ----------------------------
DROP TABLE IF EXISTS `ums_level`;
CREATE TABLE `ums_level`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '等级名',
  `level_sort` int(5) NULL DEFAULT NULL COMMENT '等级排名',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_level
-- ----------------------------
INSERT INTO `ums_level` VALUES (1, 'LV.1', 1, '2022-02-10 18:02:07');
INSERT INTO `ums_level` VALUES (2, 'LV.2', 2, '2022-02-10 20:58:15');
INSERT INTO `ums_level` VALUES (3, 'LV.3', 3, '2022-02-10 20:58:15');

-- ----------------------------
-- Table structure for ums_level_record
-- ----------------------------
DROP TABLE IF EXISTS `ums_level_record`;
CREATE TABLE `ums_level_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gain_time` datetime(0) NULL DEFAULT NULL COMMENT '获得时间',
  `gain_form` bigint(20) NULL DEFAULT NULL COMMENT '来源名称',
  `gain_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源活动标题',
  `gain_nums` bigint(20) NULL DEFAULT NULL COMMENT '获取积分数',
  `gain_before` bigint(20) NULL DEFAULT NULL COMMENT '获取之前数',
  `gain_after` bigint(20) NULL DEFAULT NULL COMMENT '获取之后',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户等级记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_level_record
-- ----------------------------

-- ----------------------------
-- Table structure for ums_message
-- ----------------------------
DROP TABLE IF EXISTS `ums_message`;
CREATE TABLE `ums_message`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `chat_message_to_uuid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '对话的uuid',
  `chat_message_data` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '私信消息数据',
  `chat_message_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型，管理员之类的',
  `chat_message_is_read` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0未读，1已读',
  `chat_message_io` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'in为接收到的消息，out为发出的消息',
  `user_to` bigint(20) NULL DEFAULT NULL COMMENT '发给谁',
  `user_form` bigint(20) NULL DEFAULT NULL COMMENT '谁发来',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `chat_message_to_uuid`(`chat_message_to_uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '私信' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_message
-- ----------------------------

-- ----------------------------
-- Table structure for ums_sign
-- ----------------------------
DROP TABLE IF EXISTS `ums_sign`;
CREATE TABLE `ums_sign`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `continuity_nums` int(10) NULL DEFAULT NULL COMMENT '连续签到天数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '签到记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_sign
-- ----------------------------

-- ----------------------------
-- Table structure for ums_task
-- ----------------------------
DROP TABLE IF EXISTS `ums_task`;
CREATE TABLE `ums_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_code` bigint(20) NULL DEFAULT NULL COMMENT '任务代码',
  `type` bigint(20) NULL DEFAULT NULL COMMENT '任务类型',
  `profit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收益',
  `sort` int(10) NULL DEFAULT 0,
  `start` int(10) NULL DEFAULT 0 COMMENT '任务状态',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '任务描述',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '详情的文章',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_task
-- ----------------------------

-- ----------------------------
-- Table structure for ums_task_type
-- ----------------------------
DROP TABLE IF EXISTS `ums_task_type`;
CREATE TABLE `ums_task_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '任务类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_task_type
-- ----------------------------

-- ----------------------------
-- Table structure for ums_user
-- ----------------------------
DROP TABLE IF EXISTS `ums_user`;
CREATE TABLE `ums_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户代码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像路径',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐加密',
  `yesapi_ry_sys_user_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `pwd_update_date` datetime(0) NULL DEFAULT NULL COMMENT '密码最后更新时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户 01注册用户）',
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户重要信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user
-- ----------------------------
INSERT INTO `ums_user` VALUES (2, '1', NULL, NULL, 'http://img.xhnya.top/img/vae.jpg', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, '2022-02-11 11:51:27', NULL, NULL, NULL, 'xhnya', '00', '2022-02-11 11:51:27');
INSERT INTO `ums_user` VALUES (3, '2', NULL, NULL, 'http://img.xhnya.top/img/vae.jpg', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, '2022-02-11 14:12:07', NULL, 'wuhu', NULL, 'xhnhhhh', '00', '2022-02-11 14:12:07');
INSERT INTO `ums_user` VALUES (4, '86f45d24ce094850a6a76c26a82688a4', NULL, '15079730794', 'http://img.xhnya.top/img/vae.jpg', NULL, NULL, '0', '0', NULL, NULL, NULL, NULL, '2022-02-15 21:48:07', NULL, NULL, NULL, '用户15079730794', '01', '2022-02-15 21:48:07');

-- ----------------------------
-- Table structure for ums_user_attention
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_attention`;
CREATE TABLE `ums_user_attention`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `to_user_id` int(11) NOT NULL,
  `date_added` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户关注' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user_attention
-- ----------------------------

-- ----------------------------
-- Table structure for ums_user_info
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_info`;
CREATE TABLE `ums_user_info`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Email',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `true_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` tinyint(1) NULL DEFAULT 1 COMMENT '性别1男2女3保密',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `signature` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '自我介绍',
  `city` int(11) NULL DEFAULT NULL COMMENT '城市',
  `contact_addr` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `zip` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `qq` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册日期时间',
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user_info
-- ----------------------------
INSERT INTO `ums_user_info` VALUES (1, 4, '用户15079730794', '15079730794', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-02-15 21:48:07', '2022-02-15 21:48:07');

-- ----------------------------
-- Table structure for ums_user_level
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_level`;
CREATE TABLE `ums_user_level`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lid` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_user_level
-- ----------------------------
INSERT INTO `ums_user_level` VALUES (1, 1, 4, NULL, NULL);

-- ----------------------------
-- Table structure for ums_userfollower
-- ----------------------------
DROP TABLE IF EXISTS `ums_userfollower`;
CREATE TABLE `ums_userfollower`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userfollower_user` bigint(20) NOT NULL,
  `follower` bigint(20) NOT NULL,
  `crate_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户粉丝' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_userfollower
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
