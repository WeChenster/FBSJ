/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : socialmodel

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-09-10 18:00:01
*/

SET FOREIGN_KEY_CHECKS=0;

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
