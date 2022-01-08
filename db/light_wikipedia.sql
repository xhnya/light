/*
 Navicat Premium Data Transfer

 Source Server         : tenxun
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.8.166:63306
 Source Schema         : light_wikipedia

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 08/01/2022 13:11:30
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
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wiki_attribute
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wiki_history
-- ----------------------------

-- ----------------------------
-- Table structure for wiki_info
-- ----------------------------
DROP TABLE IF EXISTS `wiki_info`;
CREATE TABLE `wiki_info`  (
  `mid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ava` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图',
  `context_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文本',
  `add_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加的用户名',
  `is_del` int(11) NULL DEFAULT NULL,
  `add_userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wiki_info
-- ----------------------------

-- ----------------------------
-- Table structure for wiki_menu
-- ----------------------------
DROP TABLE IF EXISTS `wiki_menu`;
CREATE TABLE `wiki_menu`  (
  `mid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '百科菜单',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `wid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名字',
  `is_del` int(1) NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wiki_menu
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
