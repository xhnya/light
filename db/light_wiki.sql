/*
 Navicat Premium Data Transfer

 Source Server         : xhn
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.8.166:63306
 Source Schema         : light_wiki

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 17/02/2022 14:19:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wiki_attribute
-- ----------------------------
DROP TABLE IF EXISTS `wiki_attribute`;
CREATE TABLE `wiki_attribute`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `thumbs_nums` int(20) NULL DEFAULT NULL COMMENT '赞同数',
  `watch_nums` int(20) NULL DEFAULT NULL COMMENT '观看数',
  `wiki_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '百科id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '百科点赞信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wiki_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for wiki_comment
-- ----------------------------
DROP TABLE IF EXISTS `wiki_comment`;
CREATE TABLE `wiki_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `wiki_id` bigint(20) NULL DEFAULT NULL,
  `aggre_nums` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_del` tinyint(3) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wiki_comment
-- ----------------------------

-- ----------------------------
-- Table structure for wiki_content
-- ----------------------------
DROP TABLE IF EXISTS `wiki_content`;
CREATE TABLE `wiki_content`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `is_delete` tinyint(4) NULL DEFAULT NULL COMMENT '逻辑删除',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '百科内容' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wiki_content
-- ----------------------------

-- ----------------------------
-- Table structure for wiki_history
-- ----------------------------
DROP TABLE IF EXISTS `wiki_history`;
CREATE TABLE `wiki_history`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改历史',
  `wiki_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改的代码',
  `user_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户代码',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiki_context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改的内容',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '修改历史' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wiki_history
-- ----------------------------

-- ----------------------------
-- Table structure for wiki_info
-- ----------------------------
DROP TABLE IF EXISTS `wiki_info`;
CREATE TABLE `wiki_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ava` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图',
  `context_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本',
  `add_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加的用户名',
  `is_del` int(11) NULL DEFAULT NULL,
  `add_userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加id',
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `type` int(10) NULL DEFAULT NULL COMMENT '百科类型',
  `is_change` int(10) NULL DEFAULT 0 COMMENT '是否允许修改',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '百科内容' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wiki_info
-- ----------------------------

-- ----------------------------
-- Table structure for wiki_menu
-- ----------------------------
DROP TABLE IF EXISTS `wiki_menu`;
CREATE TABLE `wiki_menu`  (
  `mid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '百科菜单',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `wid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名字',
  `is_del` int(1) NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '百科菜单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wiki_menu
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
