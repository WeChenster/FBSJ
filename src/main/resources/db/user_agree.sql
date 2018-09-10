/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : socialmodel

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-09-10 17:59:52
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_agree
-- ----------------------------
INSERT INTO `user_agree` VALUES ('1', '3', '1', '测试请求', '2018-09-06 16:52:11', '0', '2', null);
