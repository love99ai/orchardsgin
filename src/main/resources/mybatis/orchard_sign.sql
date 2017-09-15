/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : orchard_sign

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-15 18:08:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `bt_right`
-- ----------------------------
DROP TABLE IF EXISTS `bt_right`;
CREATE TABLE `bt_right` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) NOT NULL COMMENT '栏目',
  `action` varchar(50) DEFAULT NULL COMMENT '栏目操作访问',
  `description` varchar(50) DEFAULT NULL COMMENT '操作描述',
  `parentId` int(10) NOT NULL DEFAULT '0' COMMENT '父ID',
  `indexs` int(11) DEFAULT NULL COMMENT '排序标示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bt_right
-- ----------------------------
INSERT INTO `bt_right` VALUES ('-6', '系统管理', null, '系统管理', '0', '6');
INSERT INTO `bt_right` VALUES ('-5', '运营管理', null, '运营管理', '0', '5');
INSERT INTO `bt_right` VALUES ('-4', '资金管理', null, '资金管理', '0', '4');
INSERT INTO `bt_right` VALUES ('-3', '区域管理', null, '区域管理', '0', '3');
INSERT INTO `bt_right` VALUES ('-2', '商品管理', null, '商品管理', '0', '2');
INSERT INTO `bt_right` VALUES ('-1', '用户管理', null, '用户管理', '0', '1');
INSERT INTO `bt_right` VALUES ('1', '商户管理', '/admin/business', '商户管理', '-1', '1');
INSERT INTO `bt_right` VALUES ('2', '用户管理', null, '用户管理', '-1', '2');
INSERT INTO `bt_right` VALUES ('3', '角色', '/admin/groupList', '角色管理', '-6', '1');
INSERT INTO `bt_right` VALUES ('4', '管理员', null, '管理员管理', '-6', '2');

-- ----------------------------
-- Table structure for `bt_role_rights`
-- ----------------------------
DROP TABLE IF EXISTS `bt_role_rights`;
CREATE TABLE `bt_role_rights` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rightsId` int(10) NOT NULL COMMENT '操作栏',
  `roleId` int(10) NOT NULL COMMENT '权限组',
  PRIMARY KEY (`id`),
  KEY `rights_id` (`rightsId`),
  KEY `role_id` (`roleId`),
  CONSTRAINT `rights_id` FOREIGN KEY (`rightsId`) REFERENCES `bt_right` (`id`),
  CONSTRAINT `role_id` FOREIGN KEY (`roleId`) REFERENCES `tb_admin_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bt_role_rights
-- ----------------------------
INSERT INTO `bt_role_rights` VALUES ('1', '-1', '1');
INSERT INTO `bt_role_rights` VALUES ('2', '-2', '1');
INSERT INTO `bt_role_rights` VALUES ('3', '-3', '1');
INSERT INTO `bt_role_rights` VALUES ('4', '-4', '1');
INSERT INTO `bt_role_rights` VALUES ('5', '-5', '1');
INSERT INTO `bt_role_rights` VALUES ('6', '-6', '1');
INSERT INTO `bt_role_rights` VALUES ('7', '1', '1');
INSERT INTO `bt_role_rights` VALUES ('8', '2', '1');
INSERT INTO `bt_role_rights` VALUES ('9', '3', '1');
INSERT INTO `bt_role_rights` VALUES ('10', '4', '1');

-- ----------------------------
-- Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission` int(10) DEFAULT NULL COMMENT '权限范围（组）',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `uName` varchar(20) NOT NULL COMMENT '登录用户名',
  `uPwd` varchar(18) NOT NULL COMMENT '登录密码',
  `createTime` datetime NOT NULL COMMENT '注册时间',
  `isEnable` int(1) NOT NULL DEFAULT '0' COMMENT '是否启用 1是：0否',
  `loginTime` datetime DEFAULT NULL COMMENT '登录时间',
  `loginIp` varchar(20) DEFAULT NULL COMMENT '登录Ip地址',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_name` (`uName`),
  KEY `admin_group` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', '1', '管理员', 'admin', '123456', '2017-09-15 17:53:49', '0', null, null, null);
INSERT INTO `tb_admin` VALUES ('2', '2', '万达12', 'shanghu', '', '2017-09-07 14:30:44', '1', null, null, '15826183882');
INSERT INTO `tb_admin` VALUES ('4', '3', '大柯米', 'dakemi', '111111', '2017-09-15 10:00:09', '1', null, null, '19999999999');

-- ----------------------------
-- Table structure for `tb_admin_group`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_group`;
CREATE TABLE `tb_admin_group` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '管理组id',
  `groupName` varchar(20) NOT NULL COMMENT '组名',
  `groupMsg` varchar(150) DEFAULT NULL COMMENT '权限组描述',
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_name` (`groupName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin_group
-- ----------------------------
INSERT INTO `tb_admin_group` VALUES ('1', '超级管理员', '王一般的存在');
INSERT INTO `tb_admin_group` VALUES ('2', '商家', null);
INSERT INTO `tb_admin_group` VALUES ('4', '收银员', '平台资金管理');

-- ----------------------------
-- View structure for `v_admin`
-- ----------------------------
DROP VIEW IF EXISTS `v_admin`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_admin` AS select `tb_admin`.`id` AS `id`,`tb_admin`.`permission` AS `permission`,`tb_admin`.`nickname` AS `nickname`,`tb_admin`.`uName` AS `uName`,`tb_admin`.`uPwd` AS `uPwd`,`tb_admin`.`createTime` AS `createTime`,`tb_admin`.`isEnable` AS `isEnable`,`tb_admin`.`loginTime` AS `loginTime`,`tb_admin`.`loginIp` AS `loginIp`,`tb_admin`.`phone` AS `phone`,`tb_admin_group`.`groupName` AS `groupName` from (`tb_admin` join `tb_admin_group` on((`tb_admin_group`.`id` = `tb_admin`.`permission`)));

-- ----------------------------
-- View structure for `v_role_rights`
-- ----------------------------
DROP VIEW IF EXISTS `v_role_rights`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_role_rights` AS select `bt_right`.`id` AS `id`,`bt_role_rights`.`roleId` AS `roleId`,`bt_right`.`name` AS `name`,`bt_right`.`action` AS `action`,`bt_right`.`description` AS `description`,`bt_right`.`parentId` AS `parentId`,`bt_right`.`indexs` AS `indexs` from (`bt_role_rights` join `bt_right` on((`bt_role_rights`.`rightsId` = `bt_right`.`id`)));
