/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : pugna

 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 08/22/2017 18:21:36 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bills`
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `交易号` char(50) NOT NULL,
  `商户订单号` varchar(100) DEFAULT NULL,
  `交易创建时间` datetime DEFAULT NULL,
  `付款时间` datetime DEFAULT NULL,
  `最近修改时间` datetime DEFAULT NULL,
  `交易来源地` varchar(20) DEFAULT NULL,
  `类型` varchar(10) DEFAULT NULL,
  `交易对方` varchar(50) DEFAULT NULL,
  `商品名称` varchar(200) DEFAULT NULL,
  `金额` double DEFAULT NULL,
  `收支` char(2) DEFAULT NULL,
  `交易状态` varchar(20) DEFAULT NULL,
  `服务费` double DEFAULT NULL,
  `成功退款` double DEFAULT NULL,
  `备注` varchar(200) DEFAULT NULL,
  `资金状态` varchar(20) DEFAULT NULL,
  `账户` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`交易号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `call_records`
-- ----------------------------
DROP TABLE IF EXISTS `call_records`;
CREATE TABLE `call_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `call_id` int(11) DEFAULT NULL COMMENT '通话记录id',
  `is_read` int(11) DEFAULT NULL COMMENT '是否查看',
  `type` int(5) DEFAULT NULL COMMENT '1 呼入  2  呼出   3 未接',
  `number` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `name` varchar(20) DEFAULT NULL COMMENT '通话人',
  `duration` int(11) DEFAULT NULL COMMENT '通话时长',
  `date` timestamp NULL DEFAULT NULL,
  `call_new` int(11) DEFAULT NULL,
  `call_count` int(11) DEFAULT NULL,
  `cached_photo_uri` varchar(255) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  `owner_mobile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=804 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `comments_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `blog_id` int(11) DEFAULT NULL COMMENT '博客id',
  `comments_title` varchar(255) DEFAULT NULL COMMENT '评论主题',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `report_num` int(11) DEFAULT NULL COMMENT '举报人数',
  `start_num` int(11) DEFAULT NULL COMMENT '喜欢人数',
  `parent_id` int(11) DEFAULT NULL COMMENT '父评论id',
  `comments_url` varchar(255) DEFAULT NULL COMMENT '评论路径',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `ip` varchar(255) DEFAULT NULL,
  `comment_user` int(11) DEFAULT NULL COMMENT '评论人',
  `create_time` datetime DEFAULT NULL,
  `create_user` int(255) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`comments_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `config_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `config_type` varchar(20) NOT NULL COMMENT '类型code',
  `config_name` varchar(50) NOT NULL COMMENT '类型名称',
  `config_value` varchar(225) NOT NULL COMMENT '值',
  `config_status` varchar(10) NOT NULL COMMENT '是否启用',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `config_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `config_attribute`;
CREATE TABLE `config_attribute` (
  `attribute_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_id` bigint(20) NOT NULL,
  `attribute_name` varchar(255) NOT NULL,
  `attribute_value` varchar(255) NOT NULL,
  `attribute_desc` varchar(255) NOT NULL,
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `contact_name` varchar(255) DEFAULT NULL COMMENT '联系人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`contact_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `currency`
-- ----------------------------
DROP TABLE IF EXISTS `currency`;
CREATE TABLE `currency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currency_id` smallint(6) DEFAULT NULL,
  `currency_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `prepare_sub_amount` double DEFAULT NULL,
  `freeze_cash_amount` double DEFAULT NULL,
  `cash_amount` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`currency_id`,`create_time`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `dota2_game_items`
-- ----------------------------
DROP TABLE IF EXISTS `dota2_game_items`;
CREATE TABLE `dota2_game_items` (
  `id` smallint(6) NOT NULL,
  `name` char(20) DEFAULT NULL,
  `cost` smallint(6) DEFAULT NULL,
  `secret_shop` bit(1) DEFAULT NULL,
  `side_shop` bit(1) DEFAULT NULL,
  `recipe` bit(1) DEFAULT NULL,
  `localized_name` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `dota2_heros`
-- ----------------------------
DROP TABLE IF EXISTS `dota2_heros`;
CREATE TABLE `dota2_heros` (
  `id` smallint(6) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `localized_name` char(10) DEFAULT NULL,
  `sb_png` varchar(100) DEFAULT NULL,
  `lg_png` varchar(100) DEFAULT NULL,
  `full_png` varchar(100) DEFAULT NULL,
  `vert_jpg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `dota2_leagues`
-- ----------------------------
DROP TABLE IF EXISTS `dota2_leagues`;
CREATE TABLE `dota2_leagues` (
  `leagueid` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` text,
  `tournament_url` varchar(200) DEFAULT NULL,
  `itemdef` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`leagueid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `dota2_match_details`
-- ----------------------------
DROP TABLE IF EXISTS `dota2_match_details`;
CREATE TABLE `dota2_match_details` (
  `match_id` bigint(20) NOT NULL COMMENT '比赛id',
  `radiant_win` char(5) DEFAULT NULL,
  `duration` smallint(6) DEFAULT NULL,
  `season` varchar(255) DEFAULT NULL,
  `start_time` int(10) DEFAULT NULL,
  `match_seq_num` bigint(20) DEFAULT NULL,
  `tower_status_radiant` int(10) DEFAULT NULL,
  `tower_status_dire` int(10) DEFAULT NULL,
  `barracks_status_radiant` int(11) DEFAULT NULL,
  `barracks_status_dire` smallint(6) DEFAULT NULL,
  `cluster` smallint(6) DEFAULT NULL,
  `first_blood_time` smallint(6) DEFAULT NULL,
  `lobby_type` bit(10) DEFAULT NULL,
  `human_players` smallint(2) DEFAULT NULL,
  `leagueid` smallint(6) DEFAULT NULL,
  `positive_votes` smallint(6) DEFAULT NULL,
  `negative_votes` smallint(6) DEFAULT NULL,
  `game_mode` smallint(2) DEFAULT NULL,
  `flags` int(2) DEFAULT NULL,
  `engine` int(2) DEFAULT NULL,
  `radiant_score` int(3) DEFAULT NULL,
  `dire_score` int(3) DEFAULT NULL,
  `radiant_team_id` int(11) DEFAULT NULL,
  `radiant_name` varchar(50) DEFAULT NULL,
  `radiant_logo` bigint(20) DEFAULT NULL,
  `radiant_team_complete` smallint(2) DEFAULT NULL,
  `dire_team_id` smallint(6) DEFAULT NULL,
  `dire_name` varchar(50) DEFAULT NULL,
  `dire_logo` bigint(20) DEFAULT NULL,
  `dire_team_complete` smallint(2) DEFAULT NULL,
  `radiant_captain` int(11) DEFAULT NULL,
  `dire_captain` int(11) DEFAULT NULL,
  `player` text,
  `picks_ban` text,
  PRIMARY KEY (`match_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) DEFAULT NULL COMMENT '文件名称',
  `file_type` varchar(100) DEFAULT NULL COMMENT '文件类型',
  `file_extension` varchar(100) DEFAULT NULL COMMENT '文件扩展名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `upload_id` int(11) DEFAULT NULL COMMENT '上传人id',
  `file_path` varchar(100) DEFAULT NULL COMMENT '文件路径',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述信息',
  `link_id` int(10) DEFAULT NULL COMMENT '关联id',
  `save_time` datetime DEFAULT NULL COMMENT '删除时间',
  `is_delete` int(11) DEFAULT NULL COMMENT '是否删除',
  `upload_ip` varchar(100) DEFAULT NULL COMMENT '上传ip',
  `is_enable` int(10) DEFAULT NULL COMMENT '是否启用',
  `file_size` decimal(20,0) DEFAULT NULL COMMENT '文件大小',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) DEFAULT NULL COMMENT '用户id',
  `lng` double(15,7) DEFAULT NULL COMMENT '经度',
  `lat` double(15,7) DEFAULT NULL COMMENT '纬度',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户足迹表';

-- ----------------------------
--  Table structure for `plan`
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `plan_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '计划人id',
  `plan_content` varchar(1000) DEFAULT NULL,
  `plan_date` date DEFAULT NULL COMMENT '计划日期',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `create_people` int(11) DEFAULT NULL,
  `update_people` int(11) DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `sms`
-- ----------------------------
DROP TABLE IF EXISTS `sms`;
CREATE TABLE `sms` (
  `sms_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sms_ids` int(11) DEFAULT NULL COMMENT '短消息序号',
  `thread_id` int(11) DEFAULT NULL COMMENT '对话的序号',
  `address` varchar(255) DEFAULT NULL COMMENT '发件人地址',
  `address_mobile` varchar(255) DEFAULT NULL COMMENT '不带+86',
  `person` varchar(255) DEFAULT NULL COMMENT '发件人',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `protocol` varchar(255) DEFAULT NULL COMMENT ' 协议 0 SMS_RPOTO, 1 MMS_PROTO   ',
  `read` int(11) DEFAULT NULL COMMENT '是否阅读 0未读， 1已读',
  `status` int(11) DEFAULT NULL COMMENT '状态 -1接收，0 complete, 64 pending, 128 failed   ',
  `type` int(11) DEFAULT NULL COMMENT '类型 1是接收到的，2是已发出  ',
  `body` varchar(1000) DEFAULT NULL COMMENT '短消息内容',
  `service_center` varchar(255) DEFAULT NULL COMMENT '短信服务中心号码编号',
  `owner_id` int(11) DEFAULT NULL COMMENT '拥有者id',
  `owner_mobile` varchar(255) DEFAULT NULL COMMENT '拥有者手机',
  PRIMARY KEY (`sms_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1310 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `system_log`
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_content` varchar(1000) DEFAULT NULL COMMENT '日志内容',
  `user_id` int(10) DEFAULT NULL COMMENT '登录人',
  `log_date` datetime DEFAULT NULL COMMENT '日志日期',
  `log_level` int(11) DEFAULT NULL COMMENT '日志级别',
  `log_type` varchar(255) NOT NULL COMMENT '日志类型',
  `log_url` varchar(255) DEFAULT NULL COMMENT '日志发生路径',
  `create_people` int(11) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '日志创建日期',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `update_people` int(10) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_authentication`
-- ----------------------------
DROP TABLE IF EXISTS `t_authentication`;
CREATE TABLE `t_authentication` (
  `id` varchar(25) NOT NULL,
  `person_id` varchar(25) DEFAULT NULL COMMENT '拥有者',
  `auth_type` tinyint(4) DEFAULT NULL COMMENT '认证类别:1,个人；2，单位；',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(26) DEFAULT NULL COMMENT '手机号',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `office_address` varchar(200) DEFAULT NULL COMMENT '办公地址',
  `auth_status` tinyint(4) DEFAULT NULL COMMENT '认证状态：1，未认证；2，认证审核中；3，认证审核通过；4，认证审核不通过；',
  `img_front_id` varchar(25) DEFAULT NULL COMMENT '前图片ID',
  `img_back_id` varchar(25) DEFAULT NULL COMMENT '后图片ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='认证表';

-- ----------------------------
--  Table structure for `t_authority_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_authority`;
CREATE TABLE `t_authority_authority` (
  `id` varchar(25) NOT NULL COMMENT '权限ID',
  `code` varchar(200) DEFAULT NULL COMMENT '权限编码',
  `relative_url` varchar(256) DEFAULT NULL COMMENT '菜单相对url是不含系统url的部分',
  `descr` varchar(40) DEFAULT NULL COMMENT '描述',
  `authority_group` varchar(100) DEFAULT NULL COMMENT '权限组:系统设置权限组等等，通过枚举类统一定义',
  `authority_type` tinyint(4) DEFAULT NULL COMMENT '权限类型:1.纯权限点;2后端菜（点击菜单通过controller控制)；3前端菜单(前后分离时view层定义菜单,无相对url,点击菜单不受controller控制，前端js自行控制)；',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表(权限)';

-- ----------------------------
--  Table structure for `t_menu_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_authority`;
CREATE TABLE `t_menu_authority` (
  `id` varchar(25) NOT NULL COMMENT '菜单ID',
  `show_chars` varchar(40) DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(200) DEFAULT NULL COMMENT '权限编码:同权限表中权限编码',
  `p_menu_id` varchar(25) DEFAULT NULL COMMENT '上级菜单ID',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表(权限)';

-- ----------------------------
--  Table structure for `t_org_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_org_authority`;
CREATE TABLE `t_org_authority` (
  `id` varchar(25) NOT NULL COMMENT '组织ID',
  `name` varchar(20) DEFAULT NULL COMMENT '组织名称：各组织或部门名称或楼栋、楼层',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  `p_org_id` varchar(25) DEFAULT NULL COMMENT '上级组织ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表(权限)';

-- ----------------------------
--  Table structure for `t_person_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_person_authority`;
CREATE TABLE `t_person_authority` (
  `id` varchar(25) NOT NULL COMMENT '用户ID',
  `login_name` varchar(40) DEFAULT NULL COMMENT '登录名',
  `nickname` varchar(40) DEFAULT NULL COMMENT '昵称',
  `pwd` varchar(40) DEFAULT NULL COMMENT '密码',
  `role_code` varchar(200) DEFAULT NULL COMMENT '人员类型（角色）',
  `head_pic` varchar(500) DEFAULT NULL COMMENT '头像图片路径',
  `tel` varchar(15) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `auth_status` tinyint(4) DEFAULT NULL COMMENT '认证状态:1，未认证；2，认证审核中；3，认证审核通过；4，认证审核不通过；',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_unique_personauthority_login_name` (`login_name`),
  UNIQUE KEY `index_unique_personauthority_email` (`email`),
  UNIQUE KEY `index_unique_personauthority_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员表(权限)';

-- ----------------------------
--  Table structure for `t_person_org_relation_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_person_org_relation_authority`;
CREATE TABLE `t_person_org_relation_authority` (
  `id` varchar(25) NOT NULL COMMENT '人员组织关系ID',
  `persoin_id` varchar(25) DEFAULT NULL COMMENT '人员ID',
  `org_id` varchar(25) DEFAULT NULL COMMENT '组织ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员组织关系表(权限)';

-- ----------------------------
--  Table structure for `t_person_role_relation_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_person_role_relation_authority`;
CREATE TABLE `t_person_role_relation_authority` (
  `id` varchar(25) NOT NULL COMMENT '关系表ID',
  `person_id` varchar(25) DEFAULT NULL COMMENT '人员ID',
  `role_code` varchar(200) DEFAULT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员角色关系表(权限)';

-- ----------------------------
--  Table structure for `t_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority` (
  `id` varchar(25) NOT NULL COMMENT '角色ID',
  `code` varchar(200) DEFAULT NULL COMMENT '角色编号：admin等，编号唯一不重复',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称:超级管理员',
  `descr` varchar(200) DEFAULT NULL COMMENT '角色描述',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_roleauthority_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表(权限)';

-- ----------------------------
--  Table structure for `t_role_authority_relation_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority_relation_authority`;
CREATE TABLE `t_role_authority_relation_authority` (
  `id` varchar(25) NOT NULL COMMENT '关系表ID',
  `role_code` varchar(200) DEFAULT NULL COMMENT '角色编号',
  `authority_code` varchar(200) DEFAULT NULL COMMENT '权限编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表(权限)';

SET FOREIGN_KEY_CHECKS = 1;
