/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : socialmodel

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-09-10 17:59:56
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comments
-- ----------------------------
