/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : hrms

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2017-12-31 18:47:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` int(6) NOT NULL DEFAULT '0',
  `Name` varchar(20) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `Birth` varchar(20) DEFAULT NULL,
  `Nat` varchar(30) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123', '123', ' ', ' ', ' ', ' ', ' ');
INSERT INTO `admin` VALUES ('331', '331', '陈志安', '男', '2017-12-29', '汉族', '广东');
INSERT INTO `admin` VALUES ('666', '666', '90后测试员', '密码666', '1996-12-31', 'MySQL', 'JAVA');

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `DeptID` int(12) NOT NULL,
  `B_Dept` varchar(20) DEFAULT NULL,
  `S_Dept` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DeptID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '财务部', '文秘');
INSERT INTO `dept` VALUES ('2', '财务部', '出纳');
INSERT INTO `dept` VALUES ('3', '销售部', '客服');
INSERT INTO `dept` VALUES ('4', '销售部', '文秘');
INSERT INTO `dept` VALUES ('5', '人事部', '文秘');
INSERT INTO `dept` VALUES ('6', '人事处', '规划');
INSERT INTO `dept` VALUES ('7', '质检部', '文秘');
INSERT INTO `dept` VALUES ('8', '质检部', '检测员');
INSERT INTO `dept` VALUES ('9', '经济运营部', '广告策划');
INSERT INTO `dept` VALUES ('10', '经济运营部', '新媒体管理');
INSERT INTO `dept` VALUES ('11', '车间', '挖矿');
INSERT INTO `dept` VALUES ('12', '车间', '搬砖');
INSERT INTO `dept` VALUES ('13', '车间', '上瓦');
INSERT INTO `dept` VALUES ('14', '车间', '挖土');
INSERT INTO `dept` VALUES ('17', '车间', '砸铁');
INSERT INTO `dept` VALUES ('19', '熔炉', '烧炭');
INSERT INTO `dept` VALUES ('20', '美舰', '密探');

-- ----------------------------
-- Table structure for `histrjn`
-- ----------------------------
DROP TABLE IF EXISTS `histrjn`;
CREATE TABLE `histrjn` (
  `JourNo` int(11) NOT NULL,
  `FromAcc` varchar(20) DEFAULT NULL,
  `OldInfo` varchar(50) DEFAULT NULL,
  `NewInfo` varchar(50) DEFAULT NULL,
  `RegDate` varchar(20) DEFAULT NULL,
  `ChgTime` int(11) DEFAULT NULL,
  `PersonID` int(11) DEFAULT NULL,
  PRIMARY KEY (`JourNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of histrjn
-- ----------------------------
INSERT INTO `histrjn` VALUES ('1', '人员调动', '1', '1', '2017-12-28 23-05-31', '1', '2');
INSERT INTO `histrjn` VALUES ('2', '人员调动', '6', '6', '2017-12-29 13-21-35', '2', '2');
INSERT INTO `histrjn` VALUES ('3', '劳资分配', '-100', '100', '2017-12-29 13-21-57', '1', '2');
INSERT INTO `histrjn` VALUES ('4', '劳资分配', '100', '200', '2017-12-29 13-22-13', '2', '2');
INSERT INTO `histrjn` VALUES ('5', '劳资分配', '3000', '200', '2017-12-29 13-22-23', '1', '3');
INSERT INTO `histrjn` VALUES ('6', '人员调动', '3', '3', '2017-12-29 13-24-40', '1', '4');
INSERT INTO `histrjn` VALUES ('7', '人员调动', '3', '3', '2017-12-29 13-39-38', '2', '4');
INSERT INTO `histrjn` VALUES ('8', '人员调动', '3', '3', '2017-12-29 13-46-00', '1', '8');
INSERT INTO `histrjn` VALUES ('9', '人员调动', '3', '3', '2017-12-30 14-13-10', '1', '21');
INSERT INTO `histrjn` VALUES ('10', '人员调动', '4', '4', '2017-12-30 14-26-11', '1', '14');
INSERT INTO `histrjn` VALUES ('11', '人员调动', '4', '4', '2017-12-30 14-26-13', '2', '14');
INSERT INTO `histrjn` VALUES ('12', '人员调动', '4', '4', '2017-12-30 14-26-16', '3', '14');
INSERT INTO `histrjn` VALUES ('13', '人员调动', '2', '2', '2017-12-30 15-27-30', '1', '20');
INSERT INTO `histrjn` VALUES ('14', '人员调动', '6', '6', '2017-12-30 15-28-55', '2', '20');
INSERT INTO `histrjn` VALUES ('15', '人员调动', '17', '17', '2017-12-30 15-29-12', '1', '22');
INSERT INTO `histrjn` VALUES ('16', '人员考核', '未考核', '优秀', '2017-12-30 15-36-20', '1', '16');
INSERT INTO `histrjn` VALUES ('17', '劳资分配', '0', '20000', '2017-12-30 15-36-33', '1', '16');
INSERT INTO `histrjn` VALUES ('18', '人员调动', '16', '16', '2017-12-30 16-00-36', '1', '15');
INSERT INTO `histrjn` VALUES ('19', '人员考核', '未考核', '不合格', '2017-12-30 16-00-54', '1', '15');
INSERT INTO `histrjn` VALUES ('20', '人员调动', '1', '1', '2017-12-30 18-07-09', '1', '27');
INSERT INTO `histrjn` VALUES ('21', '人员调动', '19', '19', '2017-12-30 18-07-24', '1', '23');
INSERT INTO `histrjn` VALUES ('22', '人员调动', '14', '14', '2017-12-30 18-07-40', '1', '26');
INSERT INTO `histrjn` VALUES ('23', '人员调动', '12', '12', '2017-12-30 18-07-52', '2', '27');
INSERT INTO `histrjn` VALUES ('24', '人员考核', '未考核', '合格', '2017-12-30 18-08-03', '1', '23');
INSERT INTO `histrjn` VALUES ('25', '劳资分配', '0', '435', '2017-12-30 18-08-45', '1', '24');
INSERT INTO `histrjn` VALUES ('26', '人员调动', '20', '20', '2017-12-31 17-27-06', '3', '2');
INSERT INTO `histrjn` VALUES ('27', '人员调动', '13', '13', '2017-12-31 17-27-16', '1', '3');
INSERT INTO `histrjn` VALUES ('28', '人员调动', '19', '19', '2017-12-31 17-27-23', '2', '8');
INSERT INTO `histrjn` VALUES ('29', '人员调动', '13', '13', '2017-12-31 17-27-28', '1', '11');
INSERT INTO `histrjn` VALUES ('30', '人员调动', '5', '5', '2017-12-31 17-27-34', '1', '17');
INSERT INTO `histrjn` VALUES ('31', '人员调动', '3', '3', '2017-12-31 17-27-40', '1', '36');
INSERT INTO `histrjn` VALUES ('32', '人员调动', '8', '8', '2017-12-31 17-27-45', '1', '38');
INSERT INTO `histrjn` VALUES ('33', '人员调动', '6', '6', '2017-12-31 17-27-52', '1', '29');
INSERT INTO `histrjn` VALUES ('34', '人员调动', '17', '17', '2017-12-31 17-28-07', '4', '14');
INSERT INTO `histrjn` VALUES ('35', '人员调动', '3', '3', '2017-12-31 17-28-15', '2', '17');
INSERT INTO `histrjn` VALUES ('36', '人员调动', '7', '7', '2017-12-31 17-28-32', '1', '6');
INSERT INTO `histrjn` VALUES ('37', '人员调动', '9', '9', '2017-12-31 17-28-46', '1', '37');
INSERT INTO `histrjn` VALUES ('38', '人员考核', '未考核', '优秀', '2017-12-31 17-29-02', '1', '38');
INSERT INTO `histrjn` VALUES ('39', '劳资分配', '200', '-9999', '2017-12-31 17-29-23', '3', '2');
INSERT INTO `histrjn` VALUES ('40', '劳资分配', '0', '10.2', '2017-12-31 17-29-34', '1', '39');
INSERT INTO `histrjn` VALUES ('41', '人员调动', '14', '14', '2017-12-31 18-11-03', '2', '29');
INSERT INTO `histrjn` VALUES ('42', '人员调动', '1', '12', '2017-12-31 18-18-25', '1', '39');
INSERT INTO `histrjn` VALUES ('43', '人员调动', '车间', '销售部', '2017-12-31 18-26-45', '2', '39');
INSERT INTO `histrjn` VALUES ('44', '人员调动', '销售部', '车间', '2017-12-31 18-32-47', '3', '39');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `PersonID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `Birth` varchar(20) DEFAULT NULL,
  `Nat` varchar(20) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `DeptID` int(11) DEFAULT NULL,
  `Salary` varchar(10) DEFAULT NULL,
  `Assess` varchar(20) DEFAULT '未考核',
  `Other` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PersonID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('2', '李四', '女', '1981-09-17', '瓜皮族', '北京', '20', '-9999', '优秀', '');
INSERT INTO `person` VALUES ('3', '王五', '男', '1979-10-21', '满族', '北京', '13', '200', '合格', '');
INSERT INTO `person` VALUES ('4', '赵六', '男', '1978-06-02', '回族', '北京', '3', '9000', '合格', '架构师');
INSERT INTO `person` VALUES ('5', '宋七', '女', '1963-01-31', '回族', '北京', '1', '9000', '未考核', '1999年入校');
INSERT INTO `person` VALUES ('6', '柳八', '女', '1981-09-09', '满族', '天津', '7', '9000', '合格', '2010年入校');
INSERT INTO `person` VALUES ('8', '钱绿杨', '女', '3121-10-10', '汉族', '汕头', '19', '9000', '优秀', '架构师');
INSERT INTO `person` VALUES ('10', '张杨', '男', '3121-10-12', '汉族', '汕头', '10', '0', '优秀', '架构师');
INSERT INTO `person` VALUES ('11', '李树', '男', '3123-12-19', '汉族', '天津', '13', '100000', '优秀', '');
INSERT INTO `person` VALUES ('12', '吴海', '男', '3121-10-10', '满族', '呼和浩特', '10', '9000', '优秀', '');
INSERT INTO `person` VALUES ('15', '张杨杨', '男', '3121-11-10', '汉族', '北京', '16', '0', '不合格', '');
INSERT INTO `person` VALUES ('16', '155', '', '', '', '', '1', '0', '未考核', '');
INSERT INTO `person` VALUES ('17', '1231351', '', '', '', '', '3', '0', '未考核', '');
INSERT INTO `person` VALUES ('18', '1231351', '', '', '', '', '1', '0', '未考核', '');
INSERT INTO `person` VALUES ('29', '十大', '', '', '', '', '14', '0', '未考核', '');
INSERT INTO `person` VALUES ('34', '的是法国', '', '', '', '', '1', '0', '未考核', '');
INSERT INTO `person` VALUES ('36', '几个语句', '', '', '', '', '3', '0', '未考核', '');
INSERT INTO `person` VALUES ('37', '撒地方空间布局开发商 ', '', '', '', '', '9', '0', '未考核', '');
INSERT INTO `person` VALUES ('38', '打我师傅', '女', '', '', '', '8', '0', '优秀', '');
INSERT INTO `person` VALUES ('39', '发发', '', '', '', '', '17', '10.2', '未考核', '');
