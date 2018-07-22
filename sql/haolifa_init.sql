	# ************************************************************
	# Sequel Pro SQL dump
	# Version 4541
	#
	# http://www.sequelpro.com/
	# https://github.com/sequelpro/sequelpro
	#
	# Host: 127.0.0.1 (MySQL 5.7.22)
	# Database: haolifa
	# Generation Time: 2018-07-21 14:31:06 +0000
	# ************************************************************


	/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
	/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
	/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
	/*!40101 SET NAMES utf8 */;
	/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
	/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
	/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


	# Dump of table entrust_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `entrust_info`;

	CREATE TABLE `entrust_info` (
	  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
	  `order_num` varchar(20) NOT NULL DEFAULT '' COMMENT '委托合同编号',
	  `product_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '委托产品id',
	  `figure_num` varchar(50) NOT NULL DEFAULT '' COMMENT '产品图号',
	  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '委托数量',
	  `entrust_person` varchar(255) NOT NULL DEFAULT '' COMMENT '委托人',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0',
	  `create_time` bigint(20) unsigned NOT NULL DEFAULT '0',
	  `update_time` bigint(20) unsigned NOT NULL DEFAULT '0',
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='委托加工信息表';



	# Dump of table finance_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `finance_info`;

	CREATE TABLE `finance_info` (
	  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	  `order_num` varchar(20) NOT NULL DEFAULT '' COMMENT '订单合同编号',
	  `type` tinyint(4) unsigned NOT NULL COMMENT '类型：0  订单合同编号 1 采购编号',
	  `total_amount` int(11) unsigned NOT NULL COMMENT '总金额',
	  `state` tinyint(4) unsigned NOT NULL COMMENT '状态： 0 未收款 1 未打款 2 退款中 3 待收款',
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='财务管理表';



	# Dump of table material
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `material`;

	CREATE TABLE `material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
	  `material_classify_id` char(36) NOT NULL DEFAULT '' COMMENT '原料分类业务Id',
	  `material_classify_name` char(36) NOT NULL DEFAULT '' COMMENT '原料分类名称',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '原料名称',
	  `material` varchar(64) NOT NULL DEFAULT '' COMMENT '材料',
	  `material_id` char(36) NOT NULL DEFAULT '' COMMENT '原料业务Id',
	  `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '图号',
	  `unit` varchar(64) NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
	  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '原料状态',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原料表';



	# Dump of table material_classify
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `material_classify`;

	CREATE TABLE `material_classify` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
	  `material_classify_id` char(36) NOT NULL DEFAULT '' COMMENT '原料分类业务Id',
	  `classify_name` varchar(64) NOT NULL COMMENT '分类名称（如：阀体，阀座等）',
	  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '分类状态（0启用，1弃用）',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原料分类表';



	# Dump of table order
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `order`;

	CREATE TABLE `order` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建订单用户',
	  `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '更新订单用户',
	  `order_id` char(36) NOT NULL COMMENT '订单Id',
	  `product_id` varchar(64) NOT NULL DEFAULT '' COMMENT '产品Id',
	  `flow_step_id` varchar(64) NOT NULL DEFAULT '' COMMENT '流程步骤Id（标识这个订单走到哪个流程）',
	  `order_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '订单状态',
	  `product_name` varchar(64) NOT NULL DEFAULT '' COMMENT '产品名称',
	  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '产品型号',
	  `lable` varchar(64) NOT NULL DEFAULT '' COMMENT '标签属性',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '规格',
	  `color` varchar(32) NOT NULL DEFAULT '' COMMENT '颜色',
	  `number` varchar(32) NOT NULL DEFAULT '' COMMENT '数量',
	  `material_description` varchar(1024) NOT NULL DEFAULT '' COMMENT '材质说明',
	  `remark` varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
	  `repayment_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '还款类型：1-到期一次性还本付息',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `total_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '总价',
	  `discount_total_price` decimal(12,4) NOT NULL COMMENT '优惠后总价',
	  `demand side` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方',
	  `supply side` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方',
	  `contract_number` varchar(32) NOT NULL DEFAULT '' COMMENT '合同编号',
	  `contract_sign_date` varchar(32) NOT NULL DEFAULT '' COMMENT '合同签订日期',
	  `special_require` varchar(256) NOT NULL DEFAULT '' COMMENT '特殊要求',
	  `warranty_period` varchar(256) NOT NULL DEFAULT '' COMMENT '质保期限',
	  `delivery_time` varchar(32) NOT NULL DEFAULT '' COMMENT '发货时间',
	  `receipt_info` varchar(256) NOT NULL DEFAULT '' COMMENT '收货信息',
	  `transport_type` varchar(32) NOT NULL DEFAULT '' COMMENT '运输方式',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_order_id` (`order_id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表(商务销售发起订单流程的时候插入)';



	# Dump of table order_material
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `order_material`;

	CREATE TABLE `order_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `order_id` char(36) NOT NULL COMMENT '订单Id',
	  `material_id` char(36) NOT NULL DEFAULT '' COMMENT '原料业务Id',
	  `material_count` char(36) NOT NULL DEFAULT '' COMMENT '需要的原料数量',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单原料关联表（一个订单需要哪些原料）';



	# Dump of table product
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `product`;

	CREATE TABLE `product` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
	  `product_id` varchar(36) NOT NULL DEFAULT '' COMMENT '产品Id（行业规范如：D7A1X3P-16Q-DN50）',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '产品名称',
	  `fit_component` varchar(64) NOT NULL DEFAULT '' COMMENT '适配组件',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '成品规格（如：DN65，DN80）',
	  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '产品状态',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品表';



	# Dump of table product_material
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `product_material`;

	CREATE TABLE `product_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `product_id` varchar(36) NOT NULL DEFAULT '' COMMENT '产品Id（行业规范如：D7A1X3P-16Q-DN50）',
	  `material_id` char(36) NOT NULL DEFAULT '' COMMENT '原料Id',
	  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '关联状态（0关联，1不关联）',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品原料关联表（主要记录一个产品是由哪些原料组成，多对多的关系）';



	# Dump of table purchase_order_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `purchase_order_info`;

	CREATE TABLE `purchase_order_info` (
	  `purchase_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '采购单id',
	  `order_num` varchar(20) NOT NULL DEFAULT '' COMMENT '订单编号',
	  `order_state` tinyint(255) unsigned NOT NULL DEFAULT '0' COMMENT '订单状态',
	  `supplier` varchar(255) NOT NULL DEFAULT '' COMMENT '提供方',
	  `demander` varchar(255) NOT NULL DEFAULT '' COMMENT '需方',
	  `supplier_linkman` varchar(255) NOT NULL DEFAULT '' COMMENT '供方联系人',
	  `demander_linkman` varchar(255) NOT NULL DEFAULT '' COMMENT '需方联系人',
	  `supplier_addr` varchar(255) NOT NULL DEFAULT '' COMMENT '供方地址',
	  `demander_addr` varchar(255) NOT NULL DEFAULT '' COMMENT '需方地址',
	  `suppiler_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '供方联系人电话',
	  `demander_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '需方联系人电话',
	  `delivery_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '交货日期',
	  `suppiler_confirm` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '订单确认  0 false 1 true',
	  `
	order_approver` varchar(255) NOT NULL DEFAULT '' COMMENT '订单批准人',
	  `approve_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '批准日期',
	  `order_
	auditor` varchar(255) NOT NULL DEFAULT '' COMMENT '订单审核人',
	  `
	audit_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '审核日期',
	  `order_operator` varchar(255) NOT NULL DEFAULT '' COMMENT '订单经办人',
	  `operate_date` bigint(20) unsigned NOT NULL COMMENT '经办日期',
	  `create_time` bigint(20) unsigned NOT NULL COMMENT '创建日期',
	  `update_time` bigint(20) unsigned NOT NULL COMMENT '更新日期',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1 已删除',
	  PRIMARY KEY (`purchase_id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='采购订单信息表';



	# Dump of table purchase_order_item_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `purchase_order_item_info`;

	CREATE TABLE `purchase_order_item_info` (
	  `item_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '采购单单项id',
	  `order_num` varchar(20) NOT NULL COMMENT '采购单编号',
	  `product_id` bigint(20) NOT NULL COMMENT '产品id',
	  `product_name` varchar(255) NOT NULL COMMENT '产品名称',
	  `figure_number` varchar(50) NOT NULL COMMENT '图号',
	  `specification` varchar(50) NOT NULL COMMENT '规格',
	  `material` varchar(20) NOT NULL COMMENT '材质',
	  `unit` varchar(20) NOT NULL COMMENT '单位',
	  `quantity` int(11) NOT NULL COMMENT '数量',
	  `unit_weight` int(11) NOT NULL COMMENT '单重',
	  `unit_price` int(11) NOT NULL COMMENT '单价',
	  `remark` varchar(255) NOT NULL COMMENT '备注',
	  PRIMARY KEY (`item_id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='采购订单单项表';



	# Dump of table stock
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `stock`;

	CREATE TABLE `stock` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `stock_id` char(36) NOT NULL DEFAULT '' COMMENT '库存业务Id',
	  `store_room_rack_id` char(36) NOT NULL DEFAULT '' COMMENT '库房货架业务ID',
	  `product_id` char(36) NOT NULL DEFAULT '' COMMENT '产品Id',
	  `material_id` char(36) NOT NULL DEFAULT '' COMMENT '原料Id',
	  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '库存数量(编码时候考虑并发)',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房库存表（包括原料库存，产品库存）';



	# Dump of table store_room
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `store_room`;

	CREATE TABLE `store_room` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `store_room_id` char(36) NOT NULL DEFAULT '' COMMENT '库房业务Id',
	  `name` varchar(36) NOT NULL DEFAULT '' COMMENT '库房名称',
	  `number` tinyint(4) NOT NULL DEFAULT '0' COMMENT '库房编号',
	  `address` varchar(64) NOT NULL DEFAULT '' COMMENT '货号（如：1号成品库 1101 1102 1103  1201 1202 1301 1302），通过这个就能确定是哪个库，哪个货架，哪个货位',
	  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1.原料库；2：成品库；3.既有原料，又有成品;',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房配置表';



	# Dump of table store_room_rack
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `store_room_rack`;

	CREATE TABLE `store_room_rack` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `store_room_rack_id` char(36) NOT NULL DEFAULT '' COMMENT '库房货架业务ID',
	  `store_room_id` char(36) NOT NULL DEFAULT '' COMMENT '库房业务ID',
	  `store_room_number` char(36) NOT NULL DEFAULT '' COMMENT '库房编号（冗余）',
	  `rack_no` varchar(36) NOT NULL DEFAULT '' COMMENT '货架号',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房货架关联配置表';



	# Dump of table store_room_record
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `store_room_record`;

	CREATE TABLE `store_room_record` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '更新时间',
	  `order_id` char(36) NOT NULL DEFAULT '' COMMENT '订单Id',
	  `product_id` char(36) NOT NULL DEFAULT '' COMMENT '产品Id',
	  `material_id` char(36) NOT NULL DEFAULT '' COMMENT '原料Id',
	  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1.成品；2：原料;',
	  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '出库，入库的数量',
	  `store_room_rack_id` char(36) NOT NULL DEFAULT '' COMMENT '库房货架业务ID，从哪个货架出库，或者入库哪个货架',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库，入库记录表（和订单相关联）,出库，入库的时候，修改库存表的数量';



	# Dump of table suppiler_equipment_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `suppiler_equipment_info`;

	CREATE TABLE `suppiler_equipment_info` (
	  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
	  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '数量',
	  `type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '类型 0  制造设备 1 检测设备',
	  `specification` varchar(255) NOT NULL DEFAULT '' COMMENT '型号规格',
	  `product_factory` varchar(255) NOT NULL DEFAULT '' COMMENT '生产厂商',
	  `serviced_years` int(11) NOT NULL DEFAULT '0' COMMENT '已服役年限',
	  `create_time` bigint(20) unsigned NOT NULL COMMENT '创建时间',
	  `update_time` bigint(20) unsigned NOT NULL COMMENT '更新时间',
	  `is_delete` tinyint(4) unsigned NOT NULL COMMENT '是否删除',
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='供应商设备清单';



	# Dump of table suppiler_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `suppiler_info`;

	CREATE TABLE `suppiler_info` (
	  `id` int(11) NOT NULL,
	  `suppiler_num` int(11) DEFAULT NULL,
	  `suppiler_name` varchar(255) DEFAULT NULL,
	  `website` varchar(255) DEFAULT NULL,
	  `nature` varchar(255) DEFAULT NULL,
	  `phone` varchar(255) DEFAULT NULL,
	  `address` varchar(255) DEFAULT NULL,
	  `postcode` varchar(255) DEFAULT NULL,
	  `fax` varchar(255) DEFAULT NULL,
	  `legal_person` varchar(255) DEFAULT NULL,
	  `legal_person_phone` varchar(255) DEFAULT NULL,
	  `total_factory_area` varchar(255) DEFAULT NULL,
	  `total_archit_area` varchar(255) DEFAULT NULL,
	  `work_type` varchar(255) DEFAULT NULL,
	  `staff_info` varchar(255) DEFAULT NULL,
	  `credentials_info` varchar(255) DEFAULT NULL,
	  `financial_info` varchar(255) DEFAULT NULL,
	  `main_organ` varchar(255) DEFAULT NULL,
	  `quality_assurance_info` varchar(255) DEFAULT NULL,
	  `process_route` varchar(255) DEFAULT NULL,
	  `suppiler_preparer` varchar(255) DEFAULT NULL,
	  `responsible_person` varchar(255) DEFAULT NULL,
	  `create_time` datetime DEFAULT NULL,
	  `is_delete` varchar(255) DEFAULT NULL,
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='供应商信息表';



	# Dump of table supplier_evaluation_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `supplier_evaluation_info`;

	CREATE TABLE `supplier_evaluation_info` (
	  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	  `supplier_num` varchar(20) NOT NULL DEFAULT '' COMMENT '供应商编号',
	  `qc_way` varchar(20) NOT NULL DEFAULT '' COMMENT '质量控制方式：进货检验 0；  进货外观验证 1；  本公司到供方现场验证 2；\r\n顾客到供方现场验证 3；  顾客到本公司现场验证 4',
	  `year` varchar(20) NOT NULL DEFAULT '' COMMENT '年度（例如：2017）',
	  `quality_score` int(11) unsigned DEFAULT '0' COMMENT '质量得分',
	  `quality_person` varchar(255) NOT NULL DEFAULT '' COMMENT '质量评分人',
	  `quality_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '质量得分日期',
	  `deliver_score` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '按期交货得分',
	  `deliver_person` varchar(255) NOT NULL COMMENT '按期交货评分人',
	  `deliver_score_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '按期交货得分日期',
	  `other_score` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '其他评分',
	  `other_person` varchar(255) NOT NULL COMMENT '其他评分人',
	  `other_score_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '其他评分日期',
	  `price_score` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '价格得分',
	  `price_person` varchar(255) NOT NULL COMMENT '价格评分人',
	  `price_score_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '价格评价日期',
	  `total_score` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '总分',
	  `total_person` varchar(255) NOT NULL COMMENT '总分核算人',
	  `total_score_date` bigint(20) unsigned NOT NULL COMMENT '总分核算日期',
	  `manager_opinions` varchar(255) NOT NULL COMMENT '总经理意见',
	  `manager_person` varchar(255) NOT NULL COMMENT '总经理签字',
	  `manager_opinions_date` bigint(20) unsigned NOT NULL COMMENT '总经理签字日期',
	  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
	  `is_delete` tinyint(4) unsigned NOT NULL COMMENT '是否删除',
	  `create_data` bigint(20) unsigned NOT NULL COMMENT '创建日期',
	  `update_time` bigint(20) unsigned NOT NULL COMMENT '更新日期',
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='供应商年度评价信息表';



	# Dump of table supplier_product_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `supplier_product_info`;

	CREATE TABLE `supplier_product_info` (
	  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	  `suppiler_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '供应商id',
	  `product_name` varchar(50) NOT NULL DEFAULT '' COMMENT '产品名称',
	  `annual_production` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '年产量',
	  `main_customer` varchar(255) NOT NULL DEFAULT '' COMMENT '主要客户，多个逗号分隔',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1 已删除',
	  `create_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建日期',
	  `update_time` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '更新日期',
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='供应商供应的产品信息表';



	# Dump of table sys_department
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `sys_department`;

	CREATE TABLE `sys_department` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `dept_name` varchar(20) NOT NULL COMMENT '部门名',
	  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '描述',
	  `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父部门id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_dept` (`dept_name`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';



	# Dump of table sys_permission
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `sys_permission`;

	CREATE TABLE `sys_permission` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `perm_name` varchar(32) NOT NULL COMMENT '权限名',
	  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '权限描述',
	  `url` varchar(64) NOT NULL COMMENT '权限对应的菜单链接',
	  `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父权限id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_perm` (`perm_name`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';



	# Dump of table sys_permission_role
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `sys_permission_role`;

	CREATE TABLE `sys_permission_role` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `role_id` int(11) unsigned NOT NULL COMMENT '角色id',
	  `permission_id` int(11) unsigned NOT NULL COMMENT '权限id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_permission_role` (`role_id`,`permission_id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限角色中间表';



	# Dump of table sys_role
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `sys_role`;

	CREATE TABLE `sys_role` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `dept_id` int(11) unsigned NOT NULL COMMENT '部门id',
	  `role_name` varchar(20) NOT NULL COMMENT '角色名',
	  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '描述',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_role` (`role_name`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';



	# Dump of table sys_role_user
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `sys_role_user`;

	CREATE TABLE `sys_role_user` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `sys_user_id` int(11) unsigned NOT NULL COMMENT '用户id',
	  `sys_role_id` int(11) unsigned NOT NULL COMMENT '角色id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_role_user` (`sys_user_id`,`sys_role_id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色用户中间表';



	# Dump of table sys_user
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `sys_user`;

	CREATE TABLE `sys_user` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `user_id` varchar(36) NOT NULL COMMENT '用户业务id',
	  `username` varchar(32) NOT NULL COMMENT '账号',
	  `password` varchar(64) NOT NULL COMMENT '密码',
	  `real_name` varchar(32) NOT NULL COMMENT '真实姓名',
	  `user_no` varchar(64) NOT NULL DEFAULT '' COMMENT '编号',
	  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别：0-未知，1-男，2-女',
	  `native_place` varchar(64) DEFAULT '' COMMENT '籍贯',
	  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
	  `id_card` varchar(20) NOT NULL DEFAULT '' COMMENT '身份证号',
	  `photo_url` varchar(128) NOT NULL DEFAULT '' COMMENT '照片链接',
	  `entry_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入职时间',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_username` (`username`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';



	# Dump of table t_flow
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `t_flow`;

	CREATE TABLE `t_flow` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `name` varchar(255) DEFAULT NULL,
	  `description` varchar(500) DEFAULT NULL,
	  `create_time` timestamp NULL DEFAULT NULL,
	  `update_time` timestamp NULL DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;



	# Dump of table t_flow_history
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `t_flow_history`;

	CREATE TABLE `t_flow_history` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `start_user_id` int(11) DEFAULT NULL COMMENT '发起人id',
	  `flow_id` int(11) DEFAULT NULL COMMENT 'l流程id',
	  `current_step` int(11) DEFAULT NULL COMMENT 'stepId',
	  `creat_time` timestamp NULL DEFAULT NULL,
	  `update_time` timestamp NULL DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;



	# Dump of table t_flow_step
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `t_flow_step`;

	CREATE TABLE `t_flow_step` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `flow_id` int(11) DEFAULT NULL COMMENT '流程id',
	  `step_id` int(11) DEFAULT NULL COMMENT '步骤id',
	  `order_step` int(11) DEFAULT NULL COMMENT '序号',
	  `create_time` timestamp NULL DEFAULT NULL,
	  `update_time` timestamp NULL DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;



	# Dump of table t_order_review
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `t_order_review`;

	CREATE TABLE `t_order_review` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `order_id` int(11) DEFAULT NULL COMMENT '订单',
	  `delivery_time` timestamp NULL DEFAULT NULL COMMENT '交货期',
	  `review_form` varchar(100) DEFAULT NULL COMMENT '评审形式',
	  `tech_user` int(11) DEFAULT NULL COMMENT '技术负责人',
	  `tech_remark` varchar(255) DEFAULT NULL COMMENT '技术备注',
	  `tech_time` timestamp NULL DEFAULT NULL COMMENT '技术签字日期',
	  `store_user` int(11) DEFAULT NULL COMMENT '库房审核人',
	  `store_remark` varchar(255) DEFAULT NULL COMMENT '库房核料反馈',
	  `store_review_time` timestamp NULL DEFAULT NULL COMMENT '核料日期',
	  `purchase_user` int(11) DEFAULT NULL COMMENT '采购人员',
	  `purchase_remark` varchar(255) DEFAULT NULL COMMENT '采购内容',
	  `purchase_time` timestamp NULL DEFAULT NULL COMMENT '回复日期',
	  `quality_user` int(11) DEFAULT NULL COMMENT '质量人员',
	  `quality_remark` varchar(255) DEFAULT NULL COMMENT '质量备注',
	  `quality_time` timestamp NULL DEFAULT NULL COMMENT '质量签字日期',
	  `produce_user` int(11) DEFAULT NULL COMMENT '生产者',
	  `produce_remark` varchar(255) DEFAULT NULL COMMENT '生产者备注',
	  `produce_time` timestamp NULL DEFAULT NULL COMMENT '生产签字日期',
	  `manager` int(11) DEFAULT NULL COMMENT '总经理',
	  `manager_remark` varchar(255) DEFAULT NULL COMMENT '总经理意见',
	  `manager_time` timestamp NULL DEFAULT NULL COMMENT '总经理签署日期',
	  `insert_time` timestamp NULL DEFAULT NULL,
	  `update_time` timestamp NULL DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;



	# Dump of table t_role
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `t_role`;

	CREATE TABLE `t_role` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `name` varchar(100) DEFAULT NULL,
	  `description` varchar(255) DEFAULT NULL,
	  `create_time` timestamp NULL DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;



	# Dump of table t_step
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `t_step`;

	CREATE TABLE `t_step` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `name` varchar(100) DEFAULT NULL,
	  `description` varchar(255) DEFAULT NULL,
	  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
	  `form_id` int(11) DEFAULT NULL COMMENT '表单id',
	  `create_time` timestamp NULL DEFAULT NULL,
	  `update_time` timestamp NULL DEFAULT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;



	# Dump of table unqualified_pro_info
	# ------------------------------------------------------------

	DROP TABLE IF EXISTS `unqualified_pro_info`;

	CREATE TABLE `unqualified_pro_info` (
	  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
	  `order_num` varchar(20) NOT NULL DEFAULT '' COMMENT '采购单编号',
	  `testing_unit` varchar(255) NOT NULL DEFAULT '' COMMENT '检测单位',
	  `testing_process` varchar(255) NOT NULL DEFAULT '' COMMENT '检测工序',
	  `product_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '产品id',
	  `testing_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '检测数量',
	  `unqualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数',
	  `testing_person` varchar(255) NOT NULL DEFAULT '' COMMENT '操作人',
	  `technical_requirements` varchar(255) NOT NULL DEFAULT '' COMMENT '技术要求',
	  `testing_result` varchar(255) NOT NULL DEFAULT '' COMMENT '检测结果',
	  `inspector` varchar(255) NOT NULL DEFAULT '' COMMENT '检验员',
	  `inspecte_date` bigint(20) NOT NULL DEFAULT '0' COMMENT '检验日期',
	  `reason` varchar(255) NOT NULL DEFAULT '' COMMENT '不合格原因',
	  `responsible_department` varchar(255) NOT NULL DEFAULT '' COMMENT '责任单位',
	  `department_leader` varchar(255) NOT NULL DEFAULT '' COMMENT '责任认定部门签字',
	  `responsible_analyze_date` bigint(20) NOT NULL DEFAULT '0' COMMENT '责任认定日期',
	  `technical_department_opinion` varchar(255) NOT NULL DEFAULT '' COMMENT '技术部意见',
	  `technical_leader` varchar(255) NOT NULL DEFAULT '' COMMENT '技术部签字',
	  `technical_analyze_date` bigint(20) NOT NULL DEFAULT '0' COMMENT '签字日期',
	  `quailty_department_opinion` varchar(255) NOT NULL DEFAULT '' COMMENT '质量部意见',
	  `quailty_leader` varchar(255) NOT NULL DEFAULT '' COMMENT '质量部签字',
	  `quality_analyze_date` bigint(20) NOT NULL DEFAULT '0' COMMENT '签字日期',
	  `tracking_verify_opinion` varchar(255) NOT NULL DEFAULT '' COMMENT '质量跟踪验证意见',
	  `tracking_leader` varchar(255) NOT NULL DEFAULT '' COMMENT '质量部签字',
	  `tracking_analyze_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '签字日期',
	  `create_time` bigint(20) unsigned NOT NULL DEFAULT '0',
	  `update_time` bigint(20) unsigned NOT NULL DEFAULT '0',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0',
	  PRIMARY KEY (`id`) USING BTREE
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='不合格通知表';




	/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
	/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
	/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
	/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
	/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
	/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
