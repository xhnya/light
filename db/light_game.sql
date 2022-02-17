/*
 Navicat Premium Data Transfer

 Source Server         : xhn
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.8.166:63306
 Source Schema         : light_game

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 17/02/2022 14:18:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gms_atlas
-- ----------------------------
DROP TABLE IF EXISTS `gms_atlas`;
CREATE TABLE `gms_atlas`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NULL DEFAULT NULL,
  `atlas_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图集名称',
  `sort` tinyint(3) NULL DEFAULT 0,
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `is_del` tinyint(1) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏图集' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_atlas
-- ----------------------------

-- ----------------------------
-- Table structure for gms_award
-- ----------------------------
DROP TABLE IF EXISTS `gms_award`;
CREATE TABLE `gms_award`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NOT NULL,
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  `institutions_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发奖机构',
  `name_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称描述',
  `award_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖项名称',
  `sort` tinyint(1) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构的封面logo',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '奖项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_award
-- ----------------------------

-- ----------------------------
-- Table structure for gms_banner
-- ----------------------------
DROP TABLE IF EXISTS `gms_banner`;
CREATE TABLE `gms_banner`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NULL DEFAULT NULL COMMENT '游戏id',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '0图片，1视频',
  `resources_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `is_del` tinyint(3) NULL DEFAULT 0,
  `sort` int(10) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏详情banner图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_banner
-- ----------------------------
INSERT INTO `gms_banner` VALUES (1, 9, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/26dc5325435842dabe01e4b31274d9c3vae.jpg', 0, 0, '2022-01-23 15:31:37', '2022-01-23 15:31:37');
INSERT INTO `gms_banner` VALUES (2, 10, 0, NULL, 0, 0, '2022-01-23 15:31:54', '2022-01-23 15:31:54');
INSERT INTO `gms_banner` VALUES (3, 11, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/ae9601134a864ac8b15fa9fbabfa3a14vae.jpg', 0, 0, '2022-01-23 15:32:35', '2022-01-23 15:32:35');
INSERT INTO `gms_banner` VALUES (4, 12, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/b5a9a3c87dc845a49102048974dbc0advae.jpg', 0, 0, '2022-01-23 15:35:43', '2022-01-23 15:35:43');
INSERT INTO `gms_banner` VALUES (5, 13, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/88b2c744245846d29135713b456ebed7vae.jpg', 0, 0, '2022-01-23 15:36:12', '2022-01-23 15:36:12');
INSERT INTO `gms_banner` VALUES (6, 10, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/20838d26099146cc81e13ae0e7c15765vae.jpg', 0, 0, '2022-01-23 15:37:43', '2022-01-23 15:37:43');
INSERT INTO `gms_banner` VALUES (7, 11, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/d0b7fbb43e77429b99ad7ffeb119746cvae.jpg', 0, 0, '2022-01-23 15:41:30', '2022-01-23 15:41:30');
INSERT INTO `gms_banner` VALUES (8, 9, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/79ba12039231492b8f36f423bc122926vae.jpg', 0, 0, '2022-01-23 15:41:41', '2022-01-23 15:41:41');
INSERT INTO `gms_banner` VALUES (9, 12, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/65afec58057e498ca87ced6b54cf550avae.jpg', 0, 0, '2022-01-23 15:44:49', '2022-01-23 15:44:49');
INSERT INTO `gms_banner` VALUES (10, 9, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/9c70a69577024c339006cb87a7f65262vae.jpg', 0, 0, '2022-01-23 15:44:55', '2022-01-23 15:44:55');
INSERT INTO `gms_banner` VALUES (11, 13, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/23/286ae98711bf47fc8b9d93dd2cbf83e8vae.jpg', 0, 0, '2022-01-23 15:53:12', '2022-01-23 15:53:12');
INSERT INTO `gms_banner` VALUES (13, 12, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/01/30/584fdb166049476d93939428f652aa07vae.jpg', 0, 0, '2022-01-30 23:01:55', '2022-01-30 23:01:55');
INSERT INTO `gms_banner` VALUES (14, 9, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/49b4b39f65974763a9caf827d9bd6e79vae.jpg', 0, 0, '2022-02-12 21:34:07', '2022-02-12 21:34:07');
INSERT INTO `gms_banner` VALUES (15, 10, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/5422738e824e4b67a5d97ded16163c47ss_107600c1337accc09104f7a8aa7f275f23cad096.600x338.jpg', 0, 2, '2022-02-12 22:03:23', '2022-02-12 22:03:23');
INSERT INTO `gms_banner` VALUES (16, 11, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/7aba09e9b3f9400d963854c0e0bfb4cass_284ba40590de8f604ae693631c751a0aefdc452e.600x338.jpg', 0, 3, '2022-02-12 22:12:07', '2022-02-12 22:12:07');
INSERT INTO `gms_banner` VALUES (17, 12, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/521436ed2a2c4e14a5d5e629ea7e22111602724460_827353.jpg', 0, 2, '2022-02-12 22:38:47', '2022-02-12 22:38:47');
INSERT INTO `gms_banner` VALUES (18, 13, 0, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/5c416ceb0e42447cba603a6a5c47dc7dss_9beef14102f164fa1163536d0fb3a51d0a2e4a3f.600x338.jpg', 0, 1, '2022-02-12 22:45:30', '2022-02-12 22:45:30');

-- ----------------------------
-- Table structure for gms_computer_config
-- ----------------------------
DROP TABLE IF EXISTS `gms_computer_config`;
CREATE TABLE `gms_computer_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` tinyint(3) NULL DEFAULT NULL COMMENT '最低配置和推荐配置，最低为0，推荐为1',
  `system_os` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `computer_ram` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内存',
  `computer_vram` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显卡',
  `computer_cpu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'cpu',
  `computer_hard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '硬盘',
  `computer_network` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网络',
  `game_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_computer_config
-- ----------------------------
INSERT INTO `gms_computer_config` VALUES (1, 0, 'test', 'aaa', 'aaa', 'aaa', 'aaa', 'aaa', NULL);
INSERT INTO `gms_computer_config` VALUES (2, 0, 'aa', '', '', '', '', '', NULL);
INSERT INTO `gms_computer_config` VALUES (3, 0, 'test001', 'test001', 'test001', 'test001', 'test001', 'test001', 7);
INSERT INTO `gms_computer_config` VALUES (4, 1, 'test001', 'test001', 'test001', 'test001', 'test001', 'test001', 7);
INSERT INTO `gms_computer_config` VALUES (5, 0, 'Windows 7 64bit or better', '6GB RAM', 'Nvidia GeForce GTX 660', 'Intel Core i5-2500K 3.3GHz', '需要35GB可用空间', '需要网络连接', 10);
INSERT INTO `gms_computer_config` VALUES (6, 1, 'Windows 7 64bit or better', '8GB RAM', 'Nvidia GeForce GTX 770', 'Windows 7 64bit or better', '需要35GB可用空间', '需要网络连接', 10);
INSERT INTO `gms_computer_config` VALUES (7, 0, 'Windows 7 or 10', '8 GB RAM', ' NVIDIA GeForce GTX 780 or AMD Radeon RX 470', ' Intel Core i5-3570K or AMD FX-8310', ' 需要 70 GB 可用空间', '', 11);
INSERT INTO `gms_computer_config` VALUES (8, 1, 'Windows 10', '12 GB RAM', 'GTX 1060 6GB / GTX 1660 Super or Radeon RX 590', 'Intel Core i7-4790 or AMD Ryzen 3 3200G', '需要 70 GB 可用空间', NULL, 11);
INSERT INTO `gms_computer_config` VALUES (9, 0, 'Windows 7 SP1', '8GB', 'GTX 770或R9 280', 'i5 2500K或FX 6300', '150GB', '', 12);
INSERT INTO `gms_computer_config` VALUES (10, 1, 'Windows10（v1803）', '12GB', 'GTX 1060（6GB）或Radeon RX 480 4GB', 'i7 4770K或AMD Ryzen 5 1500X', '150GB', NULL, 12);
INSERT INTO `gms_computer_config` VALUES (11, 0, 'Windows 7x64 / Windows 8.1x64 / Windows 10x64', '8 GB RAM', '2GB & AMD 7970 or nVidia 770 or greater', 'Intel Core i3 2.5 Ghz or AMD Phenom II 2.6 Ghz or greater', '需要 12 GB 可用空间', '', 13);
INSERT INTO `gms_computer_config` VALUES (12, 1, 'Windows 7x64 / Windows 8.1x64 / Windows 10x64', '4 GB RAM', '1 GB & AMD 5570 or nVidia 450', 'Intel Core i3 2.5 Ghz or AMD Phenom II 2.6 Ghz or greater', '需要 12 GB 可用空间', NULL, 13);

-- ----------------------------
-- Table structure for gms_content
-- ----------------------------
DROP TABLE IF EXISTS `gms_content`;
CREATE TABLE `gms_content`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '评论人',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论头像',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父评论',
  `game_id` bigint(20) NULL DEFAULT NULL COMMENT '游戏id',
  `is_hot` tinyint(3) NULL DEFAULT 0 COMMENT '是否热门，默认为0',
  `sort` tinyint(3) NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_content
-- ----------------------------

-- ----------------------------
-- Table structure for gms_game
-- ----------------------------
DROP TABLE IF EXISTS `gms_game`;
CREATE TABLE `gms_game`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏名称',
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '官网链接',
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图',
  `release_time` datetime(0) NULL DEFAULT NULL COMMENT '发行时间',
  `game_name_china` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名',
  `game_describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `game_type` bigint(20) NULL DEFAULT NULL COMMENT '游戏类型',
  `game_making` bigint(20) NULL DEFAULT NULL COMMENT '制作商',
  `game_issue` bigint(20) NULL DEFAULT NULL COMMENT '发行商',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情视频',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `is_hot` tinyint(1) NULL DEFAULT 0 COMMENT '是否热门',
  `bg_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '背景图',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要图片',
  `sort` int(10) NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_game
-- ----------------------------
INSERT INTO `gms_game` VALUES (9, 'Dying Light 2', 'https://dl2.dyinglightgame.com/zh/', 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/cb4a87ac6cad43cf9281c14168f4f5411560158175_841732.jpg', '2022-02-04 00:00:00', '消逝的光芒2', '《消逝的光芒2(Dying Light 2)》是一款由Techland制作发行的开放世界跑酷动作游戏，本作作为现象级开放世界《消逝的光芒》的大胆续作，给我们的生活带来了一种独特的后现代黑暗时代的景象的启示，——一个残酷、荒凉、无情的现实，你可能会像被感染的人一样，死在人类的手中。在这个精疲力竭的世界里，你的快速思考，非凡的跑酷能力以及残酷的战斗技能将是唯一能让你进入黑暗并活下来的东西。做出道德上的灰色决定，见证他们如何在多个层面影响世界，塑造城市的转型，并最终决定其命运。', 299.00, 2, 8, 8, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/d4e378a408864e2b8afbc747d28eb3ff消逝的光芒2专区_消逝的光芒2中文版下载,MOD,修改器,攻略,汉化补丁_3DM单机.mp4', '2022-02-12 21:30:28', '2022-02-12 21:32:49', 1, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/e66be69e18ff49d994f38b242ab32c1d1531798910_542579.jpg', NULL, 0);
INSERT INTO `gms_game` VALUES (10, '巫师3：狂猎', 'https://thewitcher.com/zh-cn/witcher3', 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/120a996c26f4499f87b53a9e7a0091d01532770815_753424.jpg', '2015-05-09 00:00:00', 'The Witcher 3：Wild Hunt', '《巫师3：狂猎(The Witcher 3：Wild Hunt)》是由CD Projekt Red制作发行的一款RPG游戏，玩家将在游戏中扮演职业猎魔人白狼，在狂猎中寻找预言之子，在石之心中对抗一个残暴的土匪头子，在血与酒美丽的陶森特地区揭开恐怖血腥的秘密。', 59.00, 3, 9, 9, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/c5bb0593249f4f2d91c3793334d7f6d3movie480.webm', '2022-02-12 21:52:55', '2022-02-12 22:03:12', 1, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/6da22fd928c24406a34257a0f902f98f1531986023_198592.jpg', 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/3d0e5c8e899d4acdab0f7ebf0b032834ss_107600c1337accc09104f7a8aa7f275f23cad096.600x338.jpg', 0);
INSERT INTO `gms_game` VALUES (11, '赛博朋克2077', 'https://www.cyberpunk.net/cn/zh-cn/', 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/7b1ba98c4a4d4cd492bb9b739049d15c1603349350_903224.jpg', '2020-12-10 00:00:00', 'Cyberpunk 2077', '《赛博朋克 2077》是一款开放世界游戏，故事发生在夜之城，权力更迭和身体改造是这里不变的主题。扮演一名野心勃勃的雇佣兵：V，追寻一种独一无二的植入体——获得永生的关键。自定义角色义体、技能和玩法，探索包罗万象的城市。您做出的选择也将会对剧情和周遭世界产生影响。', 299.00, 2, 9, 9, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/9a01c959cb944dc8a103effb3eaea4bd2077.webm', '2022-02-12 22:10:13', '2022-02-12 22:12:39', 1, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/c206c70b377647f7b4f8a0afddac6b6a1606963502_849729.jpg', NULL, 0);
INSERT INTO `gms_game` VALUES (12, 'Red Dead: RedemptionⅡ', 'https://www.rockstargames.com/reddeadredemption2/tw', 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/af0ea4004e8a48a1a350eb6fb3d09a861531115695_945701.jpg', '2019-11-05 00:00:00', '荒野大镖客2', '《荒野大镖客2(Red Dead Redemption 2)》是由Rockstar Games制作发行的一款开放世界动作冒险类游戏，是人气游戏《荒野大镖客》的最新续作。本作讲述在美国无情的蛮荒大地上绽放出的生命诗篇。游戏庞大又细腻的世界，也将是全新多人游戏模式体验的最佳舞台。', 299.00, 3, 4, 4, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/6093089385284394974892d67f130a06red.webm', '2022-02-12 22:36:25', '2022-02-12 22:38:31', 1, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/d280e57b63c841fabd6db80636a01127荒野大镖客bg20220116.jpg', NULL, 0);
INSERT INTO `gms_game` VALUES (13, 'Civilization VI', 'https://www.civilization.com/', 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/d084c5f84b964671aa45f8c9355d7cf71532412242_238190.jpg', '2022-02-16 00:00:00', '文明6', '《文明6(Civilization VI)》是由Firaxis Games制作，2K发行的一款回合制策略类游戏，是人气策略系列《文明》的第六代作品。游戏中玩家建立起一个帝国，并接受时间的考验。玩家将创建及带领自己的文明从石器时代迈向信息时代，并成为世界的领导者。在尝试建立起世界上赫赫有名的伟大文明的过程中，玩家将启动战争、实行外交、促进文化，同时正面对抗历史上的众多领袖。', 299.00, 5, 10, 11, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/a09fc297d3b74e44a3f5d9d49c50e495文明6专区_文明6中文版下载,MOD,修改器,攻略,汉化补丁_3DM单机.mp4', '2022-02-12 22:44:35', '2022-02-12 22:45:11', 1, 'https://xhnya.oss-cn-hangzhou.aliyuncs.com/2022/02/12/07bca37f10e3461cb2102e9436e310621527751146_828891.jpg', NULL, 0);

-- ----------------------------
-- Table structure for gms_game_produce
-- ----------------------------
DROP TABLE IF EXISTS `gms_game_produce`;
CREATE TABLE `gms_game_produce`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NULL DEFAULT NULL,
  `bid` bigint(20) NULL DEFAULT NULL,
  `is_hot` tinyint(3) NULL DEFAULT NULL COMMENT '是否佳作',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏产商的游戏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_game_produce
-- ----------------------------

-- ----------------------------
-- Table structure for gms_game_tags
-- ----------------------------
DROP TABLE IF EXISTS `gms_game_tags`;
CREATE TABLE `gms_game_tags`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NULL DEFAULT NULL,
  `tags_id` bigint(20) NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏标签对应表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_game_tags
-- ----------------------------
INSERT INTO `gms_game_tags` VALUES (1, NULL, 4, 0);
INSERT INTO `gms_game_tags` VALUES (2, NULL, 6, 0);
INSERT INTO `gms_game_tags` VALUES (3, 7, 5, 0);
INSERT INTO `gms_game_tags` VALUES (4, 7, 6, 0);
INSERT INTO `gms_game_tags` VALUES (5, 7, 4, 0);
INSERT INTO `gms_game_tags` VALUES (6, 9, 4, 0);
INSERT INTO `gms_game_tags` VALUES (7, 10, 4, 0);
INSERT INTO `gms_game_tags` VALUES (8, 10, 1, 0);
INSERT INTO `gms_game_tags` VALUES (9, 11, 4, 0);
INSERT INTO `gms_game_tags` VALUES (10, 11, 5, 0);
INSERT INTO `gms_game_tags` VALUES (11, 12, 4, 0);
INSERT INTO `gms_game_tags` VALUES (12, 12, 1, 0);
INSERT INTO `gms_game_tags` VALUES (13, 12, 4, 0);
INSERT INTO `gms_game_tags` VALUES (14, 12, 1, 0);
INSERT INTO `gms_game_tags` VALUES (15, 12, 4, 0);
INSERT INTO `gms_game_tags` VALUES (16, 12, 1, 0);
INSERT INTO `gms_game_tags` VALUES (17, 13, 1, 0);
INSERT INTO `gms_game_tags` VALUES (18, 13, 4, 0);

-- ----------------------------
-- Table structure for gms_picture
-- ----------------------------
DROP TABLE IF EXISTS `gms_picture`;
CREATE TABLE `gms_picture`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片链接',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '图集id',
  `is_show` tinyint(3) NULL DEFAULT NULL COMMENT '是否在首页显示',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_picture
-- ----------------------------

-- ----------------------------
-- Table structure for gms_produce
-- ----------------------------
DROP TABLE IF EXISTS `gms_produce`;
CREATE TABLE `gms_produce`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` tinyint(3) NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `game_nums` int(10) NULL DEFAULT 0 COMMENT '具有的游戏数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏产商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_produce
-- ----------------------------
INSERT INTO `gms_produce` VALUES (4, 'Rockstar', 0, '2022-01-22 17:54:27', 0);
INSERT INTO `gms_produce` VALUES (7, '育碧', 1, '2022-01-22 22:43:48', 0);
INSERT INTO `gms_produce` VALUES (8, 'Techland', 3, '2022-02-12 21:28:59', 0);
INSERT INTO `gms_produce` VALUES (9, 'CD Projekt Red', 3, '2022-02-12 21:50:07', 0);
INSERT INTO `gms_produce` VALUES (10, 'Firaxis', 2, '2022-02-12 22:43:19', 0);
INSERT INTO `gms_produce` VALUES (11, '2K', 1, '2022-02-12 22:43:28', 0);

-- ----------------------------
-- Table structure for gms_rank
-- ----------------------------
DROP TABLE IF EXISTS `gms_rank`;
CREATE TABLE `gms_rank`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `type` int(10) NULL DEFAULT NULL COMMENT '榜单类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏排行榜' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_rank
-- ----------------------------
INSERT INTO `gms_rank` VALUES (1, 3, 3, '2022-02-11 16:47:31', 1);
INSERT INTO `gms_rank` VALUES (2, 6, 5, '2022-02-11 17:01:43', 1);
INSERT INTO `gms_rank` VALUES (4, 3, 1, '2022-02-11 17:21:50', 2);
INSERT INTO `gms_rank` VALUES (8, 6, 1, '2022-02-12 09:27:45', 3);
INSERT INTO `gms_rank` VALUES (9, 9, 1, '2022-02-12 21:36:14', 1);
INSERT INTO `gms_rank` VALUES (10, 9, 1, '2022-02-12 21:36:19', 2);
INSERT INTO `gms_rank` VALUES (11, 9, 1, '2022-02-12 21:36:23', 3);
INSERT INTO `gms_rank` VALUES (12, 11, 2, '2022-02-12 22:14:18', 1);
INSERT INTO `gms_rank` VALUES (13, 10, 2, '2022-02-12 22:14:24', 2);
INSERT INTO `gms_rank` VALUES (14, 11, 3, '2022-02-12 22:14:33', 2);
INSERT INTO `gms_rank` VALUES (15, 10, 2, '2022-02-12 22:14:38', 3);
INSERT INTO `gms_rank` VALUES (16, 11, 3, '2022-02-12 22:14:44', 3);
INSERT INTO `gms_rank` VALUES (17, 10, 3, '2022-02-12 22:14:51', 1);
INSERT INTO `gms_rank` VALUES (18, 12, 4, '2022-02-13 13:02:23', 1);
INSERT INTO `gms_rank` VALUES (19, 13, 5, '2022-02-13 13:02:33', 1);
INSERT INTO `gms_rank` VALUES (20, 13, 4, '2022-02-13 13:02:41', 2);
INSERT INTO `gms_rank` VALUES (21, 12, 5, '2022-02-13 13:02:47', 2);
INSERT INTO `gms_rank` VALUES (22, 12, 4, '2022-02-13 13:02:55', 3);
INSERT INTO `gms_rank` VALUES (24, 13, 5, '2022-02-13 13:03:13', 3);

-- ----------------------------
-- Table structure for gms_recommend
-- ----------------------------
DROP TABLE IF EXISTS `gms_recommend`;
CREATE TABLE `gms_recommend`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NULL DEFAULT NULL COMMENT '游戏id',
  `type` tinyint(3) NULL DEFAULT NULL,
  `state` tinyint(3) NULL DEFAULT 0 COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏推荐表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_recommend
-- ----------------------------
INSERT INTO `gms_recommend` VALUES (1, 10, 0, 0, '2022-02-13 09:32:57', '2022-02-14 09:32:53');
INSERT INTO `gms_recommend` VALUES (2, 11, 0, 0, '2022-02-14 09:37:16', '2022-02-14 09:37:16');
INSERT INTO `gms_recommend` VALUES (3, 11, 1, 0, '2022-02-16 20:27:04', '2022-02-16 20:27:04');
INSERT INTO `gms_recommend` VALUES (4, 13, 1, 0, '2022-02-16 20:27:09', '2022-02-16 20:27:09');
INSERT INTO `gms_recommend` VALUES (5, 9, 1, 0, '2022-02-16 20:27:14', '2022-02-16 20:27:14');

-- ----------------------------
-- Table structure for gms_score
-- ----------------------------
DROP TABLE IF EXISTS `gms_score`;
CREATE TABLE `gms_score`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_score` int(5) NULL DEFAULT 0 COMMENT '游戏分数',
  `type` tinyint(3) NULL DEFAULT NULL COMMENT '评分类型（0是本站，1是本站用户，2是其他）',
  `score_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评分人',
  `score_describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评分描述',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `sort` tinyint(3) NULL DEFAULT NULL COMMENT '排序',
  `game_id` bigint(20) NULL DEFAULT NULL,
  `page_id` bigint(20) NULL DEFAULT NULL COMMENT '评分文章',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏评分表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_score
-- ----------------------------
INSERT INTO `gms_score` VALUES (1, 5, 1, 'aaaa', '11111', '2022-02-07 15:07:40', '2022-02-07 15:07:40', 4, 3, NULL);
INSERT INTO `gms_score` VALUES (2, 1, 0, 'xxx', 'aaa', '2022-02-07 15:09:11', '2022-02-07 15:09:11', 4, 3, NULL);

-- ----------------------------
-- Table structure for gms_series
-- ----------------------------
DROP TABLE IF EXISTS `gms_series`;
CREATE TABLE `gms_series`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `game_id` bigint(20) NULL DEFAULT NULL,
  `series_id` bigint(20) NULL DEFAULT NULL COMMENT '系列',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏同系列' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_series
-- ----------------------------

-- ----------------------------
-- Table structure for gms_tags
-- ----------------------------
DROP TABLE IF EXISTS `gms_tags`;
CREATE TABLE `gms_tags`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `start` int(10) NULL DEFAULT NULL,
  `is_del` tinyint(3) NULL DEFAULT NULL,
  `sort` int(10) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_tags
-- ----------------------------
INSERT INTO `gms_tags` VALUES (1, '经典大作', '2022-01-22 21:52:49', 0, NULL, 10, '2022-01-22 21:59:21');
INSERT INTO `gms_tags` VALUES (4, '开放世界', '2022-01-22 21:59:59', 0, NULL, 1, '2022-01-22 21:59:59');
INSERT INTO `gms_tags` VALUES (5, '科幻', '2022-01-22 22:00:50', 0, NULL, 6, '2022-01-22 22:00:50');
INSERT INTO `gms_tags` VALUES (6, '太空', '2022-01-22 22:01:02', 0, NULL, 0, '2022-01-22 22:01:02');
INSERT INTO `gms_tags` VALUES (7, '沙盒1', '2022-01-22 22:01:48', 0, NULL, 0, '2022-01-27 15:52:53');

-- ----------------------------
-- Table structure for gms_type
-- ----------------------------
DROP TABLE IF EXISTS `gms_type`;
CREATE TABLE `gms_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` tinyint(3) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '游戏类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gms_type
-- ----------------------------
INSERT INTO `gms_type` VALUES (2, '动作', 1, '2022-01-22 20:28:13', '2022-01-22 20:28:13');
INSERT INTO `gms_type` VALUES (3, '角色', 0, '2022-01-22 20:28:24', '2022-01-22 20:28:24');
INSERT INTO `gms_type` VALUES (4, '射击', 0, '2022-01-22 20:28:44', '2022-01-22 20:28:44');
INSERT INTO `gms_type` VALUES (5, '策略', 0, '2022-01-22 20:30:17', '2022-01-22 20:30:17');
INSERT INTO `gms_type` VALUES (6, '冒险', 0, '2022-01-22 20:31:01', '2022-01-22 20:31:01');
INSERT INTO `gms_type` VALUES (7, '体育', 0, '2022-01-22 20:31:06', '2022-01-22 20:31:06');
INSERT INTO `gms_type` VALUES (8, '模拟', 0, '2022-01-22 20:31:10', '2022-01-22 20:31:10');

SET FOREIGN_KEY_CHECKS = 1;
