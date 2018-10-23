/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : socialmodel

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-10-23 15:30:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `base_users`
-- ----------------------------
DROP TABLE IF EXISTS `base_users`;
CREATE TABLE `base_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chan_add` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_users
-- ----------------------------
INSERT INTO `base_users` VALUES ('1', 'test1', '2018-09-20 17:56:52', '0', '测试数据');
INSERT INTO `base_users` VALUES ('2', 'test2', '2018-09-20 17:57:43', '0', 'asdasd');
INSERT INTO `base_users` VALUES ('3', 'test3', '2018-09-21 17:26:40', '0', 'mybatis??');
INSERT INTO `base_users` VALUES ('6', 'test4', '2018-09-21 17:59:48', '0', 'mybatis插入');
INSERT INTO `base_users` VALUES ('7', 'test5', '2018-09-21 18:00:32', '0', 'mybatis插入');
INSERT INTO `base_users` VALUES ('9', 'test7', '2018-10-22 14:35:35', '0', 'huni');
INSERT INTO `base_users` VALUES ('8', 'test6', '2018-09-29 14:48:54', '0', '');

-- ----------------------------
-- Table structure for `sys_setting`
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_url` varchar(100) DEFAULT NULL,
  `trade_url` varchar(100) DEFAULT NULL,
  `life_url` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `host` varchar(100) DEFAULT NULL,
  `app_key` varchar(100) DEFAULT NULL,
  `app_secret` varchar(100) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_setting
-- ----------------------------

-- ----------------------------
-- Table structure for `user_agree`
-- ----------------------------
DROP TABLE IF EXISTS `user_agree`;
CREATE TABLE `user_agree` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `src_id` bigint(20) DEFAULT NULL,
  `reason` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `friend_from` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_agree
-- ----------------------------
INSERT INTO `user_agree` VALUES ('4', '2', '1', 'test_agree_request', '2018-10-23 09:34:05', '1', '2', '0', null);

-- ----------------------------
-- Table structure for `user_comments`
-- ----------------------------
DROP TABLE IF EXISTS `user_comments`;
CREATE TABLE `user_comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `img` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `rec_user` bigint(20) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comments
-- ----------------------------

-- ----------------------------
-- Table structure for `user_dyn_msg`
-- ----------------------------
DROP TABLE IF EXISTS `user_dyn_msg`;
CREATE TABLE `user_dyn_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `rec_user` bigint(20) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `img` varchar(3000) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `good_num` int(11) DEFAULT NULL,
  `comm_num` int(11) DEFAULT NULL,
  `forward_num` int(11) DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `is_strange` int(11) DEFAULT NULL,
  `is_forward` int(11) DEFAULT NULL,
  `forward_res` varchar(200) DEFAULT NULL,
  `msg_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_dyn_msg
-- ----------------------------

-- ----------------------------
-- Table structure for `user_friends`
-- ----------------------------
DROP TABLE IF EXISTS `user_friends`;
CREATE TABLE `user_friends` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `rec_user` bigint(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `friend_memo` varchar(50) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  `msg_not` int(11) DEFAULT NULL,
  `backg` varchar(500) DEFAULT NULL,
  `hide_me` int(11) DEFAULT NULL,
  `hide_her` int(11) DEFAULT NULL,
  `is_blacklist` int(11) DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_friends
-- ----------------------------
INSERT INTO `user_friends` VALUES ('5', '2', '1', '2018-10-23 15:00:41', null, '0', '0', null, '0', '0', '0', '0', null);
INSERT INTO `user_friends` VALUES ('6', '1', '2', '2018-10-23 15:00:41', null, '0', '0', null, '0', '0', '0', '0', null);

-- ----------------------------
-- Table structure for `user_time_stamp`
-- ----------------------------
DROP TABLE IF EXISTS `user_time_stamp`;
CREATE TABLE `user_time_stamp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `udmsg_id` bigint(20) DEFAULT NULL,
  `is_mine` int(11) DEFAULT NULL,
  `id_del` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_time_stamp
-- ----------------------------
