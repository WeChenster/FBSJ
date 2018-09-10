/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : socialmodel

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-09-10 17:59:42
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
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_users
-- ----------------------------
INSERT INTO `base_users` VALUES ('1', 'a1sd123dsaed12312sdq', '2018-09-06 16:44:23', null);
INSERT INTO `base_users` VALUES ('2', 'a2sad1sd1sd12', '2018-09-06 16:44:35', null);
INSERT INTO `base_users` VALUES ('3', 'a3asdasdqdsadcd12', '2018-09-06 16:45:23', null);
INSERT INTO `base_users` VALUES ('4', '1775951*****lwt2018-09-10 17:52:55', '2018-09-10 17:52:55', null);
