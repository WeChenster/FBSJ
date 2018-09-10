/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : socialmodel

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-09-10 17:59:47
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_setting
-- ----------------------------
