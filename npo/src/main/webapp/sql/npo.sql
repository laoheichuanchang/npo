/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50638
Source Host           : 127.0.0.1:3306
Source Database       : npo

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2018-03-16 10:00:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_sys_operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_operation_log`;
CREATE TABLE `t_sys_operation_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OPERATION_NAME` varchar(30) NOT NULL COMMENT '业务名称',
  `OPERATION_TYPE` char(2) NOT NULL,
  `OPERATOR` int(11) NOT NULL,
  `OPERATION_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `REQUEST_PARAMS` varchar(500) DEFAULT NULL COMMENT '请求参数',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_org`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_org`;
CREATE TABLE `t_sys_org` (
  `CODE` varchar(50) DEFAULT NULL COMMENT '代码',
  `NAME` varchar(150) NOT NULL COMMENT '名称',
  `STATUS` tinyint(4) NOT NULL COMMENT '状态：\r\n            0 无效\r\n            1 有效\r\n            2 删除',
  `RMK` varchar(100) DEFAULT NULL COMMENT '描述',
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) NOT NULL,
  `CREATOR_ID` int(11) NOT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATOR_ID` int(11) NOT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_org
-- ----------------------------
INSERT INTO `t_sys_org` VALUES ('201803050000000001', '总部', '1', null, '1', '0', '1', '2018-03-05 16:31:27', '1', '2018-03-05 16:31:27');
INSERT INTO `t_sys_org` VALUES ('201803050000000002', '外勤', '1', null, '2', '1', '1', '2018-03-05 16:32:57', '1', '2018-03-05 16:32:57');
INSERT INTO `t_sys_org` VALUES ('201803050000000003', '内勤', '1', null, '3', '1', '1', '2018-03-05 16:34:42', '1', '2018-03-05 16:34:42');
INSERT INTO `t_sys_org` VALUES ('201803050000000004', '外勤A组', '1', null, '4', '2', '1', '2018-03-05 16:36:09', '1', '2018-03-05 16:36:09');
INSERT INTO `t_sys_org` VALUES ('201803050000000005', '外勤B组', '1', null, '5', '2', '1', '2018-03-05 16:36:32', '1', '2018-03-05 16:36:32');
INSERT INTO `t_sys_org` VALUES ('201803050000000006', '内勤A组', '1', null, '6', '3', '1', '2018-03-07 10:40:59', '1', '2018-03-07 10:40:59');

-- ----------------------------
-- Table structure for `t_sys_org_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_org_role_rel`;
CREATE TABLE `t_sys_org_role_rel` (
  `ROLE_ID` int(11) NOT NULL,
  `ORG_ID` int(11) NOT NULL,
  `CREATOR_ID` int(11) NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_org_role_rel
-- ----------------------------
INSERT INTO `t_sys_org_role_rel` VALUES ('1', '1', '1', '2018-03-14 14:09:45');

-- ----------------------------
-- Table structure for `t_sys_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permissions`;
CREATE TABLE `t_sys_permissions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(100) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `RES_ID` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL COMMENT '状态：\r\n            0 无效\r\n            1 有效\r\n            2 删除',
  `RMK` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_permissions
-- ----------------------------
INSERT INTO `t_sys_permissions` VALUES ('1', 'org.view.list', '列表', '3', '1', '组织结构列表');
INSERT INTO `t_sys_permissions` VALUES ('2', 'org.view.add', '新增', '3', '1', '新增组织机构');
INSERT INTO `t_sys_permissions` VALUES ('3', 'org.view.update', '编辑', '3', '1', '编辑组织机构');
INSERT INTO `t_sys_permissions` VALUES ('4', 'org.view.delete', '删除', '3', '1', '删除组织机构');
INSERT INTO `t_sys_permissions` VALUES ('5', 'org.staff.view.list', '列表', '2', '1', '员工管理列表');
INSERT INTO `t_sys_permissions` VALUES ('6', 'role.view.list', '列表', '4', '1', '角色管理列表');
INSERT INTO `t_sys_permissions` VALUES ('7', 'role.view.add', '新增', '4', '1', '新增角色');
INSERT INTO `t_sys_permissions` VALUES ('8', 'role.view.update', '修改', '4', '1', '修改角色');
INSERT INTO `t_sys_permissions` VALUES ('9', 'role.view.delete', '删除', '4', '1', '删除角色');
INSERT INTO `t_sys_permissions` VALUES ('10', 'user.view.list', '列表', '5', '1', '用户管理列表');
INSERT INTO `t_sys_permissions` VALUES ('11', 'user.view.add', '新增', '5', '1', '新增用户');
INSERT INTO `t_sys_permissions` VALUES ('12', 'user.view.update', '修改', '5', '1', '修改用户');
INSERT INTO `t_sys_permissions` VALUES ('13', 'user.view.delete', '删除', '5', '1', '删除用户');
INSERT INTO `t_sys_permissions` VALUES ('14', 'operationLog.view.list', '列表', '7', '1', '操作日志列表');
INSERT INTO `t_sys_permissions` VALUES ('15', 'loginLog.view.list', '列表', '8', '1', '登录日志列表');

-- ----------------------------
-- Table structure for `t_sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_resource`;
CREATE TABLE `t_sys_resource` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL COMMENT '名称',
  `PID` int(11) NOT NULL DEFAULT '0' COMMENT '上级菜单ID',
  `URL` varchar(500) DEFAULT NULL COMMENT '菜单URL',
  `METHOD` varchar(30) DEFAULT NULL,
  `ORDER_NUM` int(6) NOT NULL COMMENT '顺序',
  `STATUS` tinyint(4) NOT NULL COMMENT '0 无效\r\n            1 有效\r\n            2 删除',
  `RMK` varchar(100) DEFAULT NULL COMMENT '备注',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATOR_ID` int(11) NOT NULL,
  `CREATOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_resource
-- ----------------------------
INSERT INTO `t_sys_resource` VALUES ('1', '基本管理', '0', null, null, '1', '1', null, '2018-03-02 16:41:36', '2018-03-02 16:41:36', '1', '1');
INSERT INTO `t_sys_resource` VALUES ('2', '员工管理', '1', '/org/staffList', 'GET', '104', '1', null, '2018-03-02 16:43:21', '2018-03-02 16:43:21', '1', '1');
INSERT INTO `t_sys_resource` VALUES ('3', '组织机构', '1', '/org/orgList', 'GET', '101', '1', null, '2018-03-06 11:07:12', '2018-03-06 11:07:12', '1', '1');
INSERT INTO `t_sys_resource` VALUES ('4', '角色管理', '1', '/role/list', 'GET', '102', '1', null, '2018-03-08 09:31:51', '2018-03-08 09:31:51', '1', '1');
INSERT INTO `t_sys_resource` VALUES ('5', '用户管理', '1', '/user/list', 'GET', '103', '1', null, '2018-03-14 13:36:15', '2018-03-14 13:36:15', '1', '1');
INSERT INTO `t_sys_resource` VALUES ('6', '日志管理', '0', null, null, '2', '1', null, '2018-03-16 09:27:13', '2018-03-16 09:27:13', '1', '1');
INSERT INTO `t_sys_resource` VALUES ('7', '操作日志', '6', '/opeLog/list', 'GET', '201', '1', null, '2018-03-16 09:27:58', '2018-03-16 09:27:58', '1', '1');
INSERT INTO `t_sys_resource` VALUES ('8', '登录日志', '6', '/loginLog/list', 'GET', '202', '1', null, '2018-03-16 09:34:05', '2018-03-16 09:34:05', '1', '1');

-- ----------------------------
-- Table structure for `t_sys_resource_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_resource_role_rel`;
CREATE TABLE `t_sys_resource_role_rel` (
  `SOURCE_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `CREATOR_ID` int(11) NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATOR_ID` int(11) NOT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_resource_role_rel
-- ----------------------------
INSERT INTO `t_sys_resource_role_rel` VALUES ('3', '1', '1', '2018-03-14 14:09:45', '1', '2018-03-14 14:09:45');
INSERT INTO `t_sys_resource_role_rel` VALUES ('2', '1', '1', '2018-03-14 14:09:45', '1', '2018-03-14 14:09:45');
INSERT INTO `t_sys_resource_role_rel` VALUES ('4', '1', '1', '2018-03-14 14:09:45', '1', '2018-03-14 14:09:45');
INSERT INTO `t_sys_resource_role_rel` VALUES ('5', '1', '1', '2018-03-14 14:09:45', '1', '2018-03-14 14:09:45');
INSERT INTO `t_sys_resource_role_rel` VALUES ('1', '1', '1', '2018-03-14 14:09:45', '1', '2018-03-14 14:09:45');
INSERT INTO `t_sys_resource_role_rel` VALUES ('6', '1', '1', '2018-03-16 09:29:17', '1', '2018-03-16 09:29:17');
INSERT INTO `t_sys_resource_role_rel` VALUES ('7', '1', '1', '2018-03-16 09:29:17', '1', '2018-03-16 09:29:17');
INSERT INTO `t_sys_resource_role_rel` VALUES ('8', '1', '1', '2018-03-16 09:36:32', '1', '2018-03-16 09:36:32');

-- ----------------------------
-- Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(50) DEFAULT NULL,
  `NAME` varchar(150) NOT NULL,
  `STATUS` tinyint(4) NOT NULL COMMENT '0 无效\r\n            1 有效\r\n            2 删除',
  `RMK` varchar(100) DEFAULT NULL COMMENT '描述',
  `CREATOR_ID` int(11) NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATOR_ID` int(11) DEFAULT NULL,
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', '201803130000000001', '超级管理员', '1', '', '1', '2018-03-16 09:40:19', '1', '2018-03-16 09:40:19');

-- ----------------------------
-- Table structure for `t_sys_role_perm_rel`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_perm_rel`;
CREATE TABLE `t_sys_role_perm_rel` (
  `ROLE_ID` int(11) NOT NULL,
  `PERM_ID` int(11) NOT NULL,
  `RES_ID` int(11) NOT NULL,
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATUS` int(11) NOT NULL COMMENT '状态 0--申请;  1--审核中;2--审核通过,3--审核不通过',
  PRIMARY KEY (`RECORD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_role_perm_rel
-- ----------------------------
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '1', '3', '111', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '2', '3', '112', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '3', '3', '113', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '4', '3', '114', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '5', '2', '115', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '6', '4', '116', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '7', '4', '117', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '8', '4', '118', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '9', '4', '119', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '10', '5', '120', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '11', '5', '121', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '12', '5', '122', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '13', '5', '123', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '14', '7', '124', '1');
INSERT INTO `t_sys_role_perm_rel` VALUES ('1', '15', '8', '125', '1');

-- ----------------------------
-- Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `ACCOUNT` varchar(50) NOT NULL,
  `NAME` varchar(150) NOT NULL COMMENT '用户名称',
  `MOBILE` varchar(15) DEFAULT NULL,
  `TEL` varchar(20) DEFAULT NULL,
  `TYPE` varchar(4) NOT NULL DEFAULT '0' COMMENT '用户类型; 0-运营管理; 1-代理商用户;2-商户用户 ',
  `EMAIL` varchar(100) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL COMMENT '密码',
  `STATUS` int(4) NOT NULL COMMENT '0 无效\r\n            1 有效\r\n            2 删除\r\n            3 锁定',
  `RMK` varchar(100) DEFAULT NULL COMMENT '描述',
  `REG_TIME` date DEFAULT NULL COMMENT '入职时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UPDATOR_ID` int(11) DEFAULT NULL,
  `CREATOR_ID` int(11) DEFAULT NULL,
  `IS_DELETE` int(3) DEFAULT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', '2018030100000001', 'admin', 'admin', '18682032050', '18682032050', '0', '505027318@qq.com', '28587b488bba0c5d0665fba0d269e28d', '1', null, '2018-03-06', '2018-03-15 16:42:35', '1', '1', '0', '2018-03-01 10:15:17');

-- ----------------------------
-- Table structure for `t_sys_user_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_login_log`;
CREATE TABLE `t_sys_user_login_log` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(50) DEFAULT NULL COMMENT '用户编号',
  `LOGIN_IP` varchar(15) DEFAULT NULL COMMENT '登录IP',
  `LOGIN_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `LOGIN_UA` varchar(50) DEFAULT NULL COMMENT '登录UA',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sys_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role_rel`;
CREATE TABLE `t_sys_user_role_rel` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `CREATOR_ID` int(11) NOT NULL,
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user_role_rel
-- ----------------------------
INSERT INTO `t_sys_user_role_rel` VALUES ('1', '1', '1', '2018-03-13 17:32:48');

-- ----------------------------
-- Function structure for `getChildLst`
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildLst`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildLst`(rootId INT) RETURNS varchar(1000) CHARSET utf8
    DETERMINISTIC
BEGIN
	 DECLARE sTemp VARCHAR(1000);
	 DECLARE sTempChd VARCHAR(1000);

	 SET sTemp = '$';
	 SET sTempChd =cast(rootId as CHAR);

	 WHILE sTempChd is not null DO
		 SET sTemp = concat(sTemp,',',sTempChd);
		 SELECT group_concat(id) INTO sTempChd FROM T_SYS_ORG where FIND_IN_SET(pid,sTempChd)>0;
	 END WHILE;
	RETURN sTemp;
 END
;;
DELIMITER ;
