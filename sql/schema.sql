-- MySQL dump 10.13  Distrib 5.6.28, for Win64 (x86_64)
--
-- Host: localhost    Database: sp-assets
-- ------------------------------------------------------
-- Server version	5.6.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asset_discover_config`
--
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sp-assets` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sp-assets`;

DROP TABLE IF EXISTS `asset_discover_config`;
CREATE TABLE `asset_discover_config`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `ip_range` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'IP范围',
  `filterexp` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '过滤条件',
  `status` int(4) NULL DEFAULT 0 COMMENT '状态：0等待中、1进行中、2已结束',
  `is_open` int(4) NULL DEFAULT 0 COMMENT '启/停：1/0',
  `from` int(4) NULL DEFAULT NULL COMMENT '预备资产来源类型：0.未知 1.事件 2.漏洞 3.自动发现 4.流量',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `createdBy` datetime(0) NULL DEFAULT NULL COMMENT '创建者',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `extra` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '额外字段，备用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for asset_group
-- ----------------------------
DROP TABLE IF EXISTS `asset_group`;
CREATE TABLE `asset_group`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `parent_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统节点',
  `root_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '当前资产组节点的父级节点ID,顶级节点为0',
  `asset_group_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产组名称',
  `value` int(4) NULL DEFAULT 0 COMMENT '资产组内资产的价值',
  `grade` int(4) NULL DEFAULT 1 COMMENT '资产组的等保级别',
  `levelcode` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '当前资产组节点级次码，包括本节点ID,格式为:/1/22/85/',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标文件路径',
  `iconClass` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用fonticon显示图标',
  `display_index` int(11) NULL DEFAULT NULL COMMENT '资产组显示顺序',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '资产组创建时间',
  `modified` datetime(0) NULL DEFAULT NULL COMMENT '资产组最后修改时间',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产组描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资产组表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for asset_object
-- ----------------------------
DROP TABLE IF EXISTS `asset_object`;
CREATE TABLE `asset_object`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `type_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类型ID',
  `type_code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类型Code',
  `code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产型号',
  `os` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `os_version` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统版本',
  `firmware` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固件',
  `asset_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产名称',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产主IP',
  `mask` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产管理IP或主IP默认网关',
  `mac` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产管理IP接口的MAC地址',
  `hostname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产主机名',
  `contact` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产联系人',
  `location` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产地理位置',
  `manufacturer` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产生产厂商',
  `warranty_from` datetime(0) NULL DEFAULT NULL COMMENT '资产质保开始日期',
  `warranty_to` datetime(0) NULL DEFAULT NULL COMMENT '资产质保结束日期',
  `sn` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产序列号',
  `is_virtual` int(4) NULL DEFAULT 0 COMMENT '资产形态：0物理设备/1虚拟设备',
  `host_on` int(20) NULL DEFAULT 0 COMMENT '当资产为数据库、中间件、虚拟资产时，宿主主机资产ID',
  `area` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产所属区域/单位',
  `status` int(4) NULL DEFAULT 1 COMMENT '资产状态：1在线，0下线',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产描述',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '资产创建时间',
  `modified` datetime(0) NULL DEFAULT NULL COMMENT '资产最后修改时间',
  `confidentiality` int(4) NULL DEFAULT NULL COMMENT '资产机密性(1-很低 2-低 3-中等 4-高 5-很高)',
  `integrity` int(4) NULL DEFAULT NULL COMMENT '资产完整性(1-很低 2-低 3-中等 4-高 5-很高)',
  `availability` int(4) NULL DEFAULT NULL COMMENT '资产可用性 (1-很低 2-低 3-中等 4-高 5-很高)',
  `value` int(4) NULL DEFAULT NULL COMMENT '资产价值，NULL时代表自动计算资产价值；资产价值等级：1-很低 2-低 3-中 4-高 5-很高',
  `grade` int(4) NULL DEFAULT NULL COMMENT '资产等保级别：xxx即代表SxAxGx  ',
  `levelcode` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产所属资产组级次码，格式为: /1/22/85/+资产ID ',
  `third_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当资产从第三方同步时记录的第三方资产编号',
  `third_type` int(4) NULL DEFAULT 0 COMMENT '预备资产来源类型：0.录入或导入 1.事件 2.漏洞 3.自动发现 4.流量',
  `create_org_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属组织机构',
  `physics_position` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物理位置',
  `is_domestic` int(4) NULL DEFAULT NULL COMMENT '是否国内 是：1，否：0，不确定：9',
  `department` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `asset_code` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编号',
  `create_man` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_man` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` int(11) NULL DEFAULT 1 COMMENT '0   未删除    1  真删除',
  `inter_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口IP',
  `inter_mac` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口Mac',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资产对象表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for asset_object_pre
-- ----------------------------
DROP TABLE IF EXISTS `asset_object_pre`;
CREATE TABLE `asset_object_pre`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `type_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类型ID',
  `type_code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类型Code',
  `code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产型号',
  `os` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `os_version` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统版本',
  `firmware` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固件',
  `asset_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产名称',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产主IP',
  `mask` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产管理IP或主IP默认网关',
  `mac` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产管理IP接口的MAC地址',
  `hostname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产主机名',
  `contact` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产联系人',
  `location` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产地理位置',
  `manufacturer` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产生产厂商',
  `warranty_from` datetime(0) NULL DEFAULT NULL COMMENT '资产质保开始日期',
  `warranty_to` datetime(0) NULL DEFAULT NULL COMMENT '资产质保结束日期',
  `sn` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产序列号',
  `is_virtual` int(4) NULL DEFAULT 0 COMMENT '资产形态：0物理设备/1虚拟设备',
  `host_on` int(20) NULL DEFAULT 0 COMMENT '当资产为数据库、中间件、虚拟资产时，宿主主机资产ID',
  `area` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产所属区域/单位',
  `status` int(4) NULL DEFAULT 1 COMMENT '资产状态：1在线，0下线',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产描述',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '资产创建时间',
  `modified` datetime(0) NULL DEFAULT NULL COMMENT '资产最后修改时间',
  `confidentiality` int(4) NULL DEFAULT NULL COMMENT '资产机密性 低：0，中等：2，高：3，极高：4',
  `integrity` int(4) NULL DEFAULT NULL COMMENT '资产完整性 低：0，中等：2，高：3，极高：4',
  `availability` int(4) NULL DEFAULT NULL COMMENT '资产可用性 低：0，中等：2，高：3，极高：4',
  `value` int(4) NULL DEFAULT NULL COMMENT '资产价值，NULL时代表自动计算资产价值，资产价值划分为五个等级：低：0、中低：1、高：2、中高：3、高：4',
  `grade` int(4) NULL DEFAULT NULL COMMENT '资产等保级别：xxx即代表SxAxGx  ',
  `levelcode` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产所属资产组级次码，格式为: /1/22/85/+资产ID ',
  `third_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当资产从第三方同步时记录的第三方资产编号',
  `third_type` int(4) NULL DEFAULT 0 COMMENT '预备资产来源类型：0.录入或导入 1.事件 2.漏洞 3.自动发现 4.流量',
  `create_org_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属组织机构',
  `physics_position` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物理位置',
  `asset_score` float(30, 0) NULL DEFAULT NULL COMMENT '资产得分',
  `is_domestic` int(4) NULL DEFAULT NULL COMMENT '是否国内 是：1，否：0，不确定：9',
  `department` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `asset_code` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编号',
  `create_man` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_man` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` int(11) NULL DEFAULT 0 COMMENT '0   未删除    1  真删除',
  `asset_tag_name` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产标签',
  `inter_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口IP',
  `inter_mac` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接口Mac',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资产对象表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for asset_tag
-- ----------------------------
DROP TABLE IF EXISTS `asset_tag`;
CREATE TABLE `asset_tag`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签ID',
  `group_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签组ID',
  `tag_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  `color` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签颜色值(十六进制)',
  `display_index` int(11) NULL DEFAULT NULL COMMENT '标签显示顺序',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '标签创建时间',
  `creator_id` int(20) NULL DEFAULT NULL COMMENT '标签创建人员ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_19`(`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for asset_tag_group
-- ----------------------------
DROP TABLE IF EXISTS `asset_tag_group`;
CREATE TABLE `asset_tag_group`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签组ID',
  `parent_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统父节点ID',
  `root_id` int(20) NOT NULL COMMENT '当前组节点的父级节点ID,顶级节点为0',
  `tag_group_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签组名称',
  `levelcode` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前标签组节点级次码，包括本节点ID,格式为:/1/22/85/',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标文件路径',
  `icon_Class` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用fonticon显示图标',
  `display_index` int(11) NULL DEFAULT 0 COMMENT '标签组显示顺序',
  `creator_id` int(20) NULL DEFAULT NULL COMMENT '标签组创建人员ID',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '标签组创建时间',
  `modified` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签组描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签组表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for asset_tag_object_rlt
-- ----------------------------
DROP TABLE IF EXISTS `asset_tag_object_rlt`;
CREATE TABLE `asset_tag_object_rlt`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关系ID',
  `tag_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签ID',
  `asset_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签与资产关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for asset_type
-- ----------------------------
DROP TABLE IF EXISTS `asset_type`;
CREATE TABLE `asset_type`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类型ID',
  `parent_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统父节点ID',
  `root_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前资产类型的父级节点ID,顶级节点为0',
  `asset_type_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类型名称',
  `code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类型编码',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产类型的图标名称',
  `icon_class` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '使用fonticon显示图标',
  `levelcode` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产类型节点级次码，包括本节点ID,格式为:/1/22/85/',
  `is_builtin` int(4) NULL DEFAULT 0 COMMENT '是否内置类型',
  `is_cvs` int(4) NULL DEFAULT 0 COMMENT '是否支持配置核查',
  `is_common` int(4) NULL DEFAULT 0 COMMENT '是否为通用类型',
  `display_index` int(11) NULL DEFAULT 0 COMMENT '显示顺序',
  `created` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modified` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产类型描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资产类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sa_asset_alert
-- ----------------------------
DROP TABLE IF EXISTS `sa_asset_alert`;
CREATE TABLE `sa_asset_alert`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `asset_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产ip',
  `type_code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产类型',
  `stat_time` int(20) NULL DEFAULT NULL COMMENT '统计时间',
  `num` int(11) NULL DEFAULT NULL COMMENT '告警数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sa_asset_vuln
-- ----------------------------
DROP TABLE IF EXISTS `sa_asset_vuln`;
CREATE TABLE `sa_asset_vuln`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `asset_id` int(20) NOT NULL COMMENT '资产id',
  `asset_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产ip',
  `high` int(11) NULL DEFAULT NULL COMMENT '漏洞级别高',
  `middle_high` int(11) NULL DEFAULT NULL COMMENT '漏洞级别中高',
  `middle` int(11) NULL DEFAULT NULL COMMENT '漏洞级别中',
  `middle_low` int(11) NULL DEFAULT NULL COMMENT '漏洞级别中低',
  `low` int(11) NULL DEFAULT NULL COMMENT '漏洞级别低',
  `normal` int(11) NULL DEFAULT NULL COMMENT '漏洞级别信息',
  `tag_new` int(11) NULL DEFAULT NULL COMMENT '新增',
  `tag_repeat` int(11) NULL DEFAULT NULL COMMENT '复现',
  `tag_left` int(11) NULL DEFAULT NULL COMMENT '遗留',
  `eliminated` int(11) NULL DEFAULT NULL COMMENT '已消除',
  `not_eliminated` int(11) NULL DEFAULT NULL COMMENT '未消除',
  `notto_eliminate` int(11) NULL DEFAULT NULL COMMENT '暂不消除',
  `misinformation` int(11) NULL DEFAULT NULL COMMENT '误报',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vuln_asset_relation
-- ----------------------------
DROP TABLE IF EXISTS `vuln_asset_relation`;
CREATE TABLE `vuln_asset_relation`  (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `task_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务ID',
  `asset_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产ID',
  `asset_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联资产名称',
  `host_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联资产IP',
  `import_time` datetime(0) NULL DEFAULT NULL COMMENT '导入时间',
  `high` int(11) NULL DEFAULT NULL COMMENT '高级',
  `middle_high` int(11) NULL DEFAULT NULL COMMENT '中高',
  `middle` int(11) NULL DEFAULT NULL COMMENT '中级',
  `middle_low` int(11) NULL DEFAULT NULL COMMENT '中低',
  `low` int(11) NULL DEFAULT NULL COMMENT '低级',
  `normal` int(11) NULL DEFAULT NULL COMMENT '信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '漏扫漏洞资产关联表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
