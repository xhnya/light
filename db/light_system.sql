/*
 Navicat Premium Data Transfer

 Source Server         : xhn
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.8.166:63306
 Source Schema         : light_system

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 17/02/2022 14:18:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_banner
-- ----------------------------
DROP TABLE IF EXISTS `sys_banner`;
CREATE TABLE `sys_banner`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `start` int(10) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '首页banner管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_banner
-- ----------------------------
INSERT INTO `sys_banner` VALUES (4, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/21/8d374c4783de4f85ba3b6a174b575b05vae.jpg', 1, '2022-01-21 20:31:41', 0, '2022-01-21 20:53:10', 'aaa');
INSERT INTO `sys_banner` VALUES (6, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/11/0012ac3eb3364a869293eb92f03b9b91small003052RMR9o1640536252.jpg', 2, '2022-02-11 14:51:49', 0, '2022-02-11 14:51:49', 'test01');
INSERT INTO `sys_banner` VALUES (7, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/11/d6734035a17d45cfab11a491e2c1dad4small224918Cu9HM1640357358.jpg', 4, '2022-02-11 15:14:23', 0, '2022-02-11 15:14:23', 'xxxx');
INSERT INTO `sys_banner` VALUES (8, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/11/ef7b73b22ada419aa8cdc664f01ec73dsmall002143h9AZk1640449303.jpg', 3, '2022-02-11 15:15:39', 0, '2022-02-11 15:15:39', 'aaaa');

-- ----------------------------
-- Table structure for sys_register_count
-- ----------------------------
DROP TABLE IF EXISTS `sys_register_count`;
CREATE TABLE `sys_register_count`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nums` int(10) NULL DEFAULT NULL COMMENT '人数',
  `days` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当天日期',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `type` tinyint(2) NULL DEFAULT 0 COMMENT '类型（默认0，是日，1星期，2月，3年）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '注册人数统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_register_count
-- ----------------------------
INSERT INTO `sys_register_count` VALUES (2, 3, '20220215', '2022-02-15 14:25:53', '2022-02-15 21:48:09', 0);

SET FOREIGN_KEY_CHECKS = 1;
