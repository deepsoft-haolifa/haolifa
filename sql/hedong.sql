  DROP TABLE IF EXISTS `flow`;
	CREATE TABLE `flow` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	 	`name` varchar(64) NOT NULL DEFAULT '' COMMENT '流程名字',
	  `description` varchar(256) NOT NULL DEFAULT '' COMMENT '流程描述',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程配置表（用来配置系统中用到的流程）';


	DROP TABLE IF EXISTS `step`;
	CREATE TABLE `step` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user` int(11) NOT NULL COMMENT '创建用户',
    `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '步骤名字',
	  `description` varchar(256)  NOT NULL DEFAULT '' COMMENT '步骤描述',
	  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色id',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='步骤配置表（也叫节点，可以认为一个审核就是一个步骤）';

 	DROP TABLE IF EXISTS `flow_step`;
	CREATE TABLE `flow_step` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user` int(11) NOT NULL COMMENT '创建用户',
    `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `flow_id` int(11) NOT NULL DEFAULT 0 COMMENT '流程id',
	  `step_id` int(11) NOT NULL  DEFAULT 0 COMMENT '步骤id',
	  `order_step` int(11) DEFAULT NULL COMMENT '序号',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程步骤关联表（一个流程关联多个步骤）';


 	DROP TABLE IF EXISTS `flow_history`;
	CREATE TABLE `flow_history` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user` int(11) NOT NULL COMMENT '发起人用户Id',
	  `flow_id` int(11) NOT NULL DEFAULT 0 COMMENT '流程id',
	  `step_id` int(11) NOT NULL  DEFAULT 0 COMMENT '步骤id',
	  `next_step_id` int(11) NOT NULL  DEFAULT 0  COMMENT '下一步流程Id',
	  `audit_user_id` int(11) DEFAULT NULL DEFAULT 0 COMMENT '审核人',
	  `audit_info` varchar(1024) NOT NULL DEFAULT '' COMMENT '审核备注',
    `audit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审批日期',
	  `buy_no` char(36) NOT NULL DEFAULT '' COMMENT '采购号',
	  `order_no` char(36) NOT NULL DEFAULT '' COMMENT '订单Id',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程记录表';


	DROP TABLE IF EXISTS `sys_department`;
	CREATE TABLE `sys_department` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `dept_name` varchar(20) NOT NULL COMMENT '部门名',
	  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '描述',
	  `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父部门id',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_dept` (`dept_name`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';


	DROP TABLE IF EXISTS `sys_permission`;
	CREATE TABLE `sys_permission` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `perm_name` varchar(32) NOT NULL COMMENT '权限名',
	  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '权限描述',
	  `url` varchar(64) NOT NULL COMMENT '权限对应的菜单链接',
	  `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父权限id',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_perm` (`perm_name`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';



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

	DROP TABLE IF EXISTS `sys_role`;
	CREATE TABLE `sys_role` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `dept_id` int(11) unsigned NOT NULL COMMENT '部门id',
	  `role_name` varchar(20) NOT NULL COMMENT '角色名',
	  `description` varchar(64) NOT NULL DEFAULT '' COMMENT '描述',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_role` (`role_name`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


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
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `entry_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入职时间',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_username` (`username`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';




  DROP TABLE IF EXISTS `material`;
	CREATE TABLE `material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `material_classify_id` int(11) NOT NULL DEFAULT 0 COMMENT '原料分类Id',
	  `material_classify_name` char(36) NOT NULL DEFAULT '' COMMENT '原料分类名称',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '原料名称',
	  `material` varchar(64) NOT NULL DEFAULT '' COMMENT '材料',
	  `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '图号',
	  `unit` varchar(64) NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '规格',
	  `model` varchar(64) NOT NULL DEFAULT '' COMMENT '型号',
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '原料状态',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_graph_no` (`graph_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原料表';



	DROP TABLE IF EXISTS `material_classify`;
	CREATE TABLE `material_classify` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `classify_name` varchar(64) NOT NULL COMMENT '分类名称（如：阀体，阀座等）',
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '分类状态（0启用，1弃用）',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原料分类表';




	DROP TABLE IF EXISTS `order`;
	CREATE TABLE `order` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `order_no` char(36) NOT NULL COMMENT '订单编号',
	  `product_no` varchar(64) NOT NULL DEFAULT '' COMMENT '产品编号',
	  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
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
	  UNIQUE KEY `uk_order_no` (`order_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表(商务销售发起订单流程的时候插入)';



	DROP TABLE IF EXISTS `order_material`;
	CREATE TABLE `order_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	   `order_no` char(36) NOT NULL COMMENT '订单号',
	  `material_id` int(11) NOT NULL DEFAULT 0 COMMENT '原料业务Id',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '原料图号',
	  `material_count` char(36) NOT NULL DEFAULT '' COMMENT '需要的原料数量',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单原料关联表（一个订单需要哪些原料）';


  DROP TABLE IF EXISTS `material_receive_record`;
	CREATE TABLE `material_receive_record` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `receive_no` char(36) NOT NULL COMMENT '领料单号',
	  `order_no` char(36) NOT NULL COMMENT '订单号',
	  `receive_department` varchar(36) NOT NULL DEFAULT '' COMMENT '领料部门',
	  `receive_user_id` varchar(36) NOT NULL DEFAULT '' COMMENT '领料用户Id',
	  `material_id` int(11) NOT NULL DEFAULT 0 COMMENT '原料业务Id',
	  `material_graph_no` char(36) NOT NULL DEFAULT '' COMMENT '原料图号',
	  `material_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '平均单价',
	  `start_material_count` char(36) NOT NULL DEFAULT '' COMMENT '期初领料数量',
	  `start_material_amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '期初领料金额',
	  `actual_material_count` char(36) NOT NULL DEFAULT '' COMMENT '本期领料数量',
	  `actual_material_amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '本期领料金额',
	  `end_material_count` char(36) NOT NULL DEFAULT '' COMMENT '期末领料数量',
	  `end_material_amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '期末领料金额',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_receive_no` (`receive_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领料记录表（一个订单需要哪些原料）';


	DROP TABLE IF EXISTS `product`;
	CREATE TABLE `product` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '产品编号（行业规范如：D7A1X3P-16Q-DN50）',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '产品名称',
	  `fit_component` varchar(64) NOT NULL DEFAULT '' COMMENT '适配组件',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '成品规格（如：DN65，DN80）',
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '产品状态',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品表';


	DROP TABLE IF EXISTS `product_material`;
	CREATE TABLE `product_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '产品编号（行业规范如：D7A1X3P-16Q-DN50）',
    `material_id` int(11) NOT NULL DEFAULT 0 COMMENT '原料业务Id',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '原料图号',	 
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '关联状态（0关联，1不关联）',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品原料关联表（主要记录一个产品是由哪些原料组成，多对多的关系）';


	DROP TABLE IF EXISTS `stock`;
	CREATE TABLE `stock` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `stock_id` char(36) NOT NULL DEFAULT '' COMMENT '库存业务Id',
	  `store_room_rack_id` char(36) NOT NULL DEFAULT '' COMMENT '库房货架业务ID',
	  `store_room_rack_position_no` varchar(32) NOT NULL DEFAULT '' COMMENT '冗余货号（如：1号成品库 1101 1102 1103  1201 1202 1301 1302），通过这个就能确定是哪个库，哪个货架，哪个货位',
	  `product_no` char(36) NOT NULL DEFAULT '' COMMENT '产品编号',
	  `material_id` int(11) NOT NULL DEFAULT 0 COMMENT '原料业务Id',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '原料图号',
	  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '库存数量(编码时候考虑并发)',
	  `safe_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '安全库存量（上浮10%提醒）',
	  `safety_factor` varchar(16) NOT NULL DEFAULT '' COMMENT '存库安全系数',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房库存表（包括原料库存，产品库存）';



	DROP TABLE IF EXISTS `store_room`;
	CREATE TABLE `store_room` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `name` varchar(36) NOT NULL DEFAULT '' COMMENT '库房名称',
	  `number` tinyint(4) NOT NULL DEFAULT 0 COMMENT '库房编号',
	  `rack_no` varchar(32) NOT NULL DEFAULT '' COMMENT '货号（如：1号成品库 1101 1102 1103  1201 1202 1301 1302），通过这个就能确定是哪个库，哪个货架，哪个货位',
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1.原料库；2：成品库；3.既有原料，又有成品;',
	  `address` varchar(36) NOT NULL DEFAULT '' COMMENT '库房地址',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房配置表';



	DROP TABLE IF EXISTS `store_room_rack`;
	CREATE TABLE `store_room_rack` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `store_room_id` int(11) NOT NULL DEFAULT 0 COMMENT '库房ID',
	  `rack_no` varchar(32) NOT NULL DEFAULT '' COMMENT '货号（如：1号成品库 1101 1102 1103  1201 1202 1301 1302），通过这个就能确定是哪个库，哪个货架，哪个货位',
	  `status` tinyInt(4) NOT NULL DEFAULT 0 COMMENT '状态',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房货架关联配置表';



	DROP TABLE IF EXISTS `store_room_record`;
	CREATE TABLE `store_room_record` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `record_id` char(36) NOT NULL DEFAULT '' COMMENT '业务字段Id',
	  `order_no` char(36) NOT NULL DEFAULT '' COMMENT '订单号',
	  `product_no` char(36) NOT NULL DEFAULT '' COMMENT '产品编号',
	  `material_id` int(11) NOT NULL DEFAULT 0 COMMENT '原料业务Id',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '原料图号',
	  `operation_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作类型：1.出库；2：入库;',
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '出入库类型：1.成品；2：原料;',
	  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '出库，入库的数量',
	  `amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '出库，入库金额',
	  `store_room_rack_id` int(11) NOT NULL DEFAULT 0 COMMENT '库房货架业务ID，从哪个货架出库，或者入库哪个货架',
	  `product_department` varchar(36) NOT NULL DEFAULT '' COMMENT '生产部门',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出库，入库记录表（和订单相关联）,出库，入库的时候，修改库存表的数量';



	DROP TABLE IF EXISTS `order_review`;
	CREATE TABLE `order_review` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `order_no` char(36) NOT NULL DEFAULT '' COMMENT '订单号',
	  `delivery_time` timestamp NOT  NULL DEFAULT '2000-01-01 00:00:00' COMMENT '交货期',
	  `review_form` varchar(100) NOT NULL DEFAULT '' COMMENT '评审形式',
	  `tech_user` int(11) NOT NULL DEFAULT 0 COMMENT '技术负责人',
	  `tech_remark` varchar(255) NOT NULL DEFAULT '' COMMENT '技术备注',
	  `tech_time` timestamp NOT NULL  DEFAULT '2000-01-01 00:00:00' COMMENT '技术签字日期',
	  `store_user` int(11) NOT NULL DEFAULT 0 COMMENT '库房审核人',
	  `store_remark` varchar(255) NOT NULL DEFAULT '' COMMENT '库房核料反馈',
	  `store_review_time` timestamp NOT  NULL DEFAULT '2000-01-01 00:00:00' COMMENT '核料日期',
	  `purchase_user` int(11) NOT NULL DEFAULT 0 COMMENT '采购人员',
	  `purchase_remark` varchar(255) NOT NULL DEFAULT '' COMMENT '采购内容',
	  `purchase_time` timestamp NOT  NULL DEFAULT '2000-01-01 00:00:00' COMMENT '回复日期',
	  `quality_user` int(11) NOT NULL DEFAULT 0 COMMENT '质量人员',
	  `quality_remark` varchar(255) NOT NULL DEFAULT '' COMMENT '质量备注',
	  `quality_time` timestamp NOT  NULL DEFAULT '2000-01-01 00:00:00' COMMENT '质量签字日期',
	  `produce_user` int(11) NOT NULL DEFAULT 0 COMMENT '生产者',
	  `produce_remark` varchar(255) NOT NULL DEFAULT '' COMMENT '生产者备注',
	  `produce_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '生产签字日期',
	  `manager` int(11) NOT NULL DEFAULT 0 COMMENT '总经理',
	  `manager_remark` varchar(255) DEFAULT '' COMMENT '总经理意见',
	  `manager_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '总经理签署日期',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='订单审批表';






