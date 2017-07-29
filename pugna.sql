/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : pugna

 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 07/29/2017 12:07:16 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '博客id（主键）',
  `blog_title` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '博客标题',
  `blog_description` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '博文描述',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` int(11) DEFAULT NULL COMMENT '跟新人',
  `update_time` datetime DEFAULT NULL COMMENT '跟新时间',
  `blogger` int(11) DEFAULT NULL COMMENT '博客作者',
  `blog_type` int(11) DEFAULT NULL COMMENT '博客类型',
  `start` int(11) DEFAULT NULL,
  `blog_content` varchar(10000) CHARACTER SET utf8 DEFAULT NULL COMMENT '文章内容',
  PRIMARY KEY (`blog_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

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
  `config_value` varchar(20) DEFAULT NULL COMMENT '值',
  `config_status` varchar(10) NOT NULL COMMENT '是否启用',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `config_detail`
-- ----------------------------
DROP TABLE IF EXISTS `config_detail`;
CREATE TABLE `config_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `config_id` int(11) NOT NULL COMMENT '外键',
  `detail_code` varchar(20) NOT NULL COMMENT '编码',
  `detail_value` varchar(20) NOT NULL COMMENT '值',
  `detail_name` varchar(20) NOT NULL COMMENT '名称',
  `enable_flag` varchar(10) NOT NULL COMMENT '是否有效',
  `note` varchar(10) NOT NULL COMMENT '备注',
  `sort` int(10) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
--  Table structure for `hour`
-- ----------------------------
DROP TABLE IF EXISTS `hour`;
CREATE TABLE `hour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hour` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

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
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名字',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单url',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_person` varchar(100) DEFAULT NULL COMMENT '修改人',
  `update_person_id` int(10) DEFAULT NULL COMMENT '更新人',
  `level` int(10) DEFAULT NULL COMMENT '等级',
  `p_id` int(10) DEFAULT NULL COMMENT '父id',
  `is_locked` varchar(10) DEFAULT '' COMMENT '是否锁住能否被删除修改',
  `enable_flag` varchar(10) DEFAULT NULL COMMENT '是否可用',
  `menu_sort` varchar(10) DEFAULT NULL COMMENT '菜单排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `message_board`
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `message_content` varchar(500) DEFAULT NULL COMMENT '留言板内容',
  `creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `ip` varchar(255) DEFAULT NULL,
  `ip_city` varchar(255) DEFAULT NULL COMMENT '城市',
  `user_id` int(11) DEFAULT NULL COMMENT '关联user表',
  `ip_country` varchar(255) DEFAULT NULL COMMENT '国家',
  `lat` varchar(255) DEFAULT NULL COMMENT '纬度',
  `lon` varchar(255) DEFAULT NULL COMMENT '经度',
  `country_code` varchar(255) DEFAULT NULL COMMENT '国家编号',
  `region` varchar(255) DEFAULT NULL COMMENT '地区',
  `regionName` varchar(255) DEFAULT NULL COMMENT '地区名字',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `status_type` varchar(255) DEFAULT NULL COMMENT '状态类型 关联config表',
  PRIMARY KEY (`board_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块id',
  `module_code` varchar(100) DEFAULT NULL COMMENT '模块code',
  `module_name` varchar(100) DEFAULT NULL COMMENT '模块名字',
  `module_url` varchar(100) DEFAULT NULL COMMENT '模块url',
  `enable_flag` varchar(10) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `permissions`
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `pri_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pri_code` varchar(100) DEFAULT NULL COMMENT '权限code',
  `pri_name` varchar(100) DEFAULT NULL COMMENT '权限名字',
  `enable_flag` varchar(10) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

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
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主机id',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名字',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色编码',
  `enable_flag` varchar(100) DEFAULT '' COMMENT '是否可用',
  `is_locked` varchar(10) DEFAULT '' COMMENT '是否锁住（能否能被修改和删除）',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `menu_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `menu_id` int(11) NOT NULL COMMENT '菜单Id',
  `role_id` int(11) NOT NULL COMMENT '用户Id',
  `permission_type` int(11) DEFAULT NULL COMMENT '操作权限  1：录入 2：浏览 3：修改 4：删除 ',
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menu_role_id`)
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
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(100) DEFAULT '' COMMENT '用户真实姓名',
  `is_locked` varchar(10) DEFAULT NULL COMMENT '是否锁住能否被删除',
  `enable_flag` varchar(10) DEFAULT NULL COMMENT '是否可用',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `tel` varchar(100) DEFAULT NULL COMMENT '电话号',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
