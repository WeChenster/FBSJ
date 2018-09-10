/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : socialmodel

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-09-10 18:00:06
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_friends
-- ----------------------------
INSERT INTO `user_friends` VALUES ('5', '3', '1', '2018-09-07 10:32:04', null, '0', '0', null, '0', '0', '0', null);
INSERT INTO `user_friends` VALUES ('6', '1', '3', '2018-09-07 10:32:04', null, '0', '0', null, '0', '0', '0', null);
