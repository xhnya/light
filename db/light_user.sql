/*
 Navicat Premium Data Transfer

 Source Server         : tenxun
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.8.166:63306
 Source Schema         : light_user

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 08/01/2022 13:11:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for integral_info
-- ----------------------------
DROP TABLE IF EXISTS `integral_info`;
CREATE TABLE `integral_info`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '积分',
  `source_type` int(2) NULL DEFAULT NULL COMMENT '来源类型',
  `integral_nums` int(10) NULL DEFAULT NULL COMMENT '数量',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `is_del` int(1) NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '积分' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of integral_info
-- ----------------------------

-- ----------------------------
-- Table structure for integral_types
-- ----------------------------
DROP TABLE IF EXISTS `integral_types`;
CREATE TABLE `integral_types`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '积分类型表',
  `integral_code` int(5) NULL DEFAULT NULL COMMENT '类型代码',
  `integral_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of integral_types
-- ----------------------------

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `uid` bigint(20) NOT NULL,
  `user_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` bigint(20) NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` int(1) NULL DEFAULT NULL COMMENT '设置状态',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `integral` int(10) NULL DEFAULT NULL COMMENT '积分',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_account
-- ----------------------------

-- ----------------------------
-- Table structure for user_gamefocus
-- ----------------------------
DROP TABLE IF EXISTS `user_gamefocus`;
CREATE TABLE `user_gamefocus`  (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关注的游戏',
  `game_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_ava` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `game_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_gamefocus
-- ----------------------------

-- ----------------------------
-- Table structure for user_history
-- ----------------------------
DROP TABLE IF EXISTS `user_history`;
CREATE TABLE `user_history`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户游览历史',
  `history_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '游览标题',
  `history_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_history
-- ----------------------------

-- ----------------------------
-- Table structure for user_level
-- ----------------------------
DROP TABLE IF EXISTS `user_level`;
CREATE TABLE `user_level`  (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experience` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经验',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_level
-- ----------------------------

-- ----------------------------
-- Table structure for user_medal
-- ----------------------------
DROP TABLE IF EXISTS `user_medal`;
CREATE TABLE `user_medal`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '勋章',
  `medal_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `medal_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `medal_type` int(5) NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_medal
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `rid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for user_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `user_userinfo`;
CREATE TABLE `user_userinfo`  (
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `phone` bigint(20) NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `age` int(5) NULL DEFAULT NULL COMMENT '年龄',
  `concern_nums` int(10) NULL DEFAULT NULL COMMENT '关注数',
  `vermicelli_nums` int(20) NULL DEFAULT NULL,
  `collections` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收藏数',
  `sex` int(5) NULL DEFAULT NULL,
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `update_time` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  `create_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_userinfo
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
