/*
 Navicat Premium Data Transfer

 Source Server         : tenxun
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.8.166:63306
 Source Schema         : light_system

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 08/01/2022 13:10:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for game_order
-- ----------------------------
DROP TABLE IF EXISTS `game_order`;
CREATE TABLE `game_order`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单',
  `game_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->积分',
  `integral` int(10) NULL DEFAULT NULL COMMENT '积分',
  `payment_time` datetime(6) NULL DEFAULT NULL COMMENT '支付时间',
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `delete_status` int(1) NOT NULL COMMENT '删除状态：0->未删除；1->已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game_order
-- ----------------------------

-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message_conxt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `is_read` int(1) NULL DEFAULT NULL COMMENT '是否已读',
  `send_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送id',
  `accept_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接受id',
  `is_del` int(1) NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_info
-- ----------------------------

-- ----------------------------
-- Table structure for subscribe_service
-- ----------------------------
DROP TABLE IF EXISTS `subscribe_service`;
CREATE TABLE `subscribe_service`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订阅服务的用户',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subscribe_service
-- ----------------------------

-- ----------------------------
-- Table structure for sys_count
-- ----------------------------
DROP TABLE IF EXISTS `sys_count`;
CREATE TABLE `sys_count`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设计定时任务，每天统计人数',
  `user_count` int(10) NULL DEFAULT NULL COMMENT '总用户数',
  `now_time` datetime(6) NULL DEFAULT NULL COMMENT '日期',
  `art_count` int(10) NULL DEFAULT NULL COMMENT '文章统计',
  `wiki_count` int(10) NULL DEFAULT NULL COMMENT '百科统计',
  `game_count` int(10) NULL DEFAULT NULL COMMENT '游戏统计',
  `create_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_count
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
