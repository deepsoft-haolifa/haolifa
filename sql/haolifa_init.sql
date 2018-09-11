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
	  `flow_id` int(11) NOT NULL DEFAULT '0' COMMENT '流程id',
    `step_id` int(11) NOT NULL DEFAULT '0' COMMENT '步骤id',
    `next_step_id` int(11) DEFAULT NULL COMMENT '下一步stepId',
    `pre_step_id` int(11) DEFAULT NULL COMMENT '暂时不用',
    `goto_step_id` int(11) DEFAULT NULL COMMENT 'false跳转节点暂时不用',
    `step_order` int(11) DEFAULT NULL COMMENT '序号',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程步骤关联表（一个流程关联多个步骤）';

  DROP TABLE IF EXISTS `flow_step_config`;
  CREATE TABLE `flow_step_config` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user` int(11) NOT NULL COMMENT '创建用户',
    `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
    `step_id` int(11) NOT NULL DEFAULT '0' COMMENT '步骤id',
    `approval_field_name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '节点审批字段中文名称',
    `english_name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '节点审批字段英文名称',
    `type` VARCHAR(10) NOT NULL DEFAULT '' COMMENT '字段类型,如string,int等',
    PRIMARY KEY (`id`)
  ) ENGINE = INNODB COMMENT '流程节点配置表';

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
	  UNIQUE KEY uk_perm_url (`perm_name`,`url`)
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
	  `dept_id` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '部门id',
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
	  `username` varchar(32) NOT NULL COMMENT '账号',
	  `password` varchar(64) NOT NULL COMMENT '密码',
	  `real_name` varchar(32) NOT NULL COMMENT '真实姓名',
	  `user_no` varchar(64) NOT NULL DEFAULT '' COMMENT '编号',
	  `sex` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '性别：0-未知，1-男，2-女',
	  `native_place` varchar(64) NOT NULL DEFAULT '' COMMENT '籍贯',
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
	  `material_classify_id` int(11) NOT NULL DEFAULT 0 COMMENT '零件分类Id',
	  `material_classify_name` char(36) NOT NULL DEFAULT '' COMMENT '零件分类名称',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '零件名称',
	  `material` varchar(64) NOT NULL DEFAULT '' COMMENT '材料',
	  `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '图号',
	  `unit` varchar(64) NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '规格',
	  `model` varchar(64) NOT NULL DEFAULT '' COMMENT '型号',
	  `actual_weight` varchar(32) NOT NULL DEFAULT '' COMMENT '实际重量',
	  `theoretical_weight` varchar(32) NOT NULL DEFAULT '' COMMENT '理论重量',
	  `tax_rate` varchar(32) NOT NULL DEFAULT '' COMMENT '税率',
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '零件状态',
	  `safe_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '安全库存量（上浮10%提醒）',
	  `safety_factor` varchar(16) NOT NULL DEFAULT '' COMMENT '存库安全系数',
	  `current_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '目前库存量（每次出库，入库的时候实时更新）',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_graph_no` (`graph_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件表';



	DROP TABLE IF EXISTS `material_classify`;
	CREATE TABLE `material_classify` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `classify_name` varchar(64) NOT NULL COMMENT '分类名称（如：阀体，阀座等）',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件分类表';




	DROP TABLE IF EXISTS `order_product`;
	CREATE TABLE `order_product` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `order_no` char(36) NOT NULL COMMENT '订单编号',
	  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
	  `order_contract_url` varchar(64) NOT NULL DEFAULT '' COMMENT '订单合同url',
	  `demand_name` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方名称',
	  `demand_agent_name` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方代理人',
	  `demand_telphone` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方电话',
	  `demand_fax` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方传真',
	  `demand_address` varchar(128) NOT NULL DEFAULT '' COMMENT '需求方地址',
	  `supply_name` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方',
	  `supply_agent_name` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方代理人',
	  `supply_telphone` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方电话',
	  `supply_fax` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方传真',
	  `supply_address` varchar(128) NOT NULL DEFAULT '' COMMENT '供应方地址',
	  `contract_number` varchar(32) NOT NULL DEFAULT '' COMMENT '合同编号',
	  `contract_sign_date` varchar(32) NOT NULL DEFAULT '' COMMENT '合同签订日期',
	  `product_no` varchar(64) NOT NULL DEFAULT '' COMMENT '成品编号',
	  `product_name` varchar(64) NOT NULL DEFAULT '' COMMENT '成品名称',
	  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号',
	  `lable` varchar(64) NOT NULL DEFAULT '' COMMENT '标签属性',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '规格',
	  `product_color` varchar(32) NOT NULL DEFAULT '' COMMENT '颜色',
	  `product_number` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `total_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '总价',
	  `discount_total_price` decimal(12,4) NOT NULL COMMENT '优惠后总价',
	  `material_description` varchar(128) NOT NULL DEFAULT '' COMMENT '材质说明',
	  `product_remark` varchar(1024) NOT NULL DEFAULT '' COMMENT '成品备注',
	  `purchase_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '采购反馈时间',
	  `production_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '生产反馈时间',
	  `special_require` varchar(256) NOT NULL DEFAULT '' COMMENT '特殊要求',
	  `cargo_information` varchar(128) NOT NULL DEFAULT '' COMMENT '随货资料',
	  `sign_board` varchar(32) NOT NULL DEFAULT '' COMMENT '标牌',
	  `acceptance_criteria` varchar(32) NOT NULL DEFAULT '' COMMENT '验收标准',
	  `warranty_period` varchar(64) NOT NULL DEFAULT '' COMMENT '质保期限',
	  `packaging_specification` varchar(64) NOT NULL DEFAULT '' COMMENT '包装规范',
	  `transport_type` varchar(32) NOT NULL DEFAULT '' COMMENT '运输方式',
	  `delivery_time` varchar(32) NOT NULL DEFAULT '' COMMENT '发货时间',
	  `receipt_info` varchar(256) NOT NULL DEFAULT '' COMMENT '收货信息',
	  `payment_method` varchar(32) NOT NULL DEFAULT '' COMMENT '付款方式',
	  `freight` varchar(32) NOT NULL DEFAULT '' COMMENT '运费承担',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_order_no` (`order_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品订单表(商务销售发起订单流程的时候插入)';



	DROP TABLE IF EXISTS `order_material`;
	CREATE TABLE `order_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	   `order_no` char(36) NOT NULL COMMENT '订单号',
	  `material_id` int(11) NOT NULL DEFAULT 0 COMMENT '零件业务Id',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `material_count` char(36) NOT NULL DEFAULT '' COMMENT '需要的零件数量',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单零件关联表（一个订单需要哪些零件）';


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
	  `material_id` int(11) NOT NULL DEFAULT 0 COMMENT '零件业务Id',
	  `material_graph_no` char(36) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `material_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '平均单价',
	  `start_material_count` char(36) NOT NULL DEFAULT '' COMMENT '期初领料数量',
	  `start_material_amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '期初领料金额',
	  `actual_material_count` char(36) NOT NULL DEFAULT '' COMMENT '本期领料数量',
	  `actual_material_amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '本期领料金额',
	  `end_material_count` char(36) NOT NULL DEFAULT '' COMMENT '期末领料数量',
	  `end_material_amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '期末领料金额',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_receive_no` (`receive_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领料记录表（一个订单需要哪些零件）';


	DROP TABLE IF EXISTS `product`;
	CREATE TABLE `product` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品编号（行业规范如：D7A1X3P-16Q-DN50）',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '成品名称',
	  `fit_component` varchar(64) NOT NULL DEFAULT '' COMMENT '适配组件',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '成品规格（如：DN65，DN80）',
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '成品状态',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品表';


	DROP TABLE IF EXISTS `product_material`;
	CREATE TABLE `product_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品编号（行业规范如：D7A1X3P-16Q-DN50）',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '关联状态（0关联，1不关联）',
	   `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_multi` (`product_no`,`material_graph_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品零件关联表（主要记录一个成品是由哪些零件组成，多对多的关系）';


	DROP TABLE IF EXISTS `stock`;
	CREATE TABLE `stock` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `stock_id` char(36) NOT NULL DEFAULT '' COMMENT '库存业务Id',
	  `store_room_id` int(11) NOT NULL DEFAULT 0  COMMENT '库房ID',
	  `store_room_rack_id` int(11) NOT NULL DEFAULT 0  COMMENT '库房货位ID',
	  `store_room_rack_no` varchar(32) NOT NULL DEFAULT '' COMMENT '冗余货号（如：1号成品库 1101 1102 1103  1201 1202 1301 1302），通过这个就能确定是哪个库，哪个货架，哪个货位',
	  `product_no` char(36) NOT NULL DEFAULT '' COMMENT '成品编号',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '库存类型：1.成品；2：零件;',
	  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '库存数量(编码时候考虑并发)',
	  `lock_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '锁定数量（核料成功锁定，零件出库的时候释放）',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房库存表（包括零件库存，成品库存）';



	DROP TABLE IF EXISTS `store_room`;
	CREATE TABLE `store_room` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `name` varchar(36) NOT NULL DEFAULT '' COMMENT '库房名称',
	  `room_no` tinyint(4) NOT NULL DEFAULT 0 COMMENT '库房编号',
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1.零件库；2：成品库；3.既有零件，又有成品;',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `status` tinyInt(4) NOT NULL DEFAULT 0 COMMENT '状态',
	  `address` varchar(36) NOT NULL DEFAULT '' COMMENT '库房地址',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_room_no` (`room_no`)
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
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库房货架关联配置表';



	DROP TABLE IF EXISTS `entry_out_store_record`;
	CREATE TABLE `entry_out_store_record` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `record_id` char(36) NOT NULL DEFAULT '' COMMENT '业务字段Id',
	  `order_no` char(36) NOT NULL DEFAULT '' COMMENT '订单号',
	  `product_no` char(36) NOT NULL DEFAULT '' COMMENT '成品编号',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `operation_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作类型：1.出库；2：入库;',
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '出入库类型：1.成品；2：零件;',
	  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '出库，入库的数量',
	  `amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '出库，入库金额',
	  `store_room_rack_id` int(11) NOT NULL DEFAULT 0 COMMENT '库房货架业务ID，从哪个货架出库，或者入库哪个货架',
	  `product_department` varchar(36) NOT NULL DEFAULT '' COMMENT '生产部门（成品入库时候有）',
	  `customer_no` varchar(36) NOT NULL DEFAULT '' COMMENT '客户代号（成品出库时候有）',
	  `customer_name` varchar(36) NOT NULL DEFAULT '' COMMENT '客户名称（成品出库时候有）',
	  `supplier` varchar(36) NOT NULL DEFAULT '' COMMENT '供应商（零件入库的时候有）',
	  `receive_department` varchar(36) NOT NULL DEFAULT '' COMMENT '领料部门（零件出库的时候有）',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价（如果成品出库，就是销售单价；零件入库，就是购买单价）',
    `status` tinyint(4) NOT NULL  DEFAULT 0 COMMENT'1：申请入库；2：入库完成；',
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
	
	
	DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单合同编号',
  `type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '类型：0  订单合同编号 1 采购编号',
  `total_amount` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '总金额',
  `status` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '状态： 0 未收款 1 未打款 2 打款中 3 收款中 4 处理完成',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0  未删除 1 已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-财务管理表';

DROP TABLE IF EXISTS `purchase_plan`;
CREATE TABLE `purchase_plan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `purchase_plan_no` varchar(64) NOT NULL DEFAULT '' COMMENT '采购计划号',
  `product_order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '生产订单号',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '物料图号',
  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '数量',
  `expected_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '期望到货时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1 已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '流程表单-采购计划表';

DROP TABLE IF EXISTS `apply_buy`;
CREATE TABLE `apply_buy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `flow_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '流程id',
  `apply_no` varchar(64) NOT NULL DEFAULT '' COMMENT '请购单号',
  `material_graph_no` varchar(30) NOT NULL DEFAULT '' COMMENT '零件图号',
  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '请购数量',
  `unit` varchar(10) NOT NULL DEFAULT '' COMMENT '单位（个）',
  `valuation` decimal(12,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '采购估价',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `purpose` varchar(255) NOT NULL DEFAULT '' COMMENT '用途',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0  未删除 1 已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程关联表单-请购单';

DROP TABLE IF EXISTS `product_purchase_record`;
CREATE TABLE `product_purchase_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `purchase_plan_no` varchar(64) NOT NULL DEFAULT '' COMMENT '采购计划单号',
  `product_order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '生产订单号',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '物料图号',
  `apply_buy_no` varchar(64) NOT NULL DEFAULT '' COMMENT '请购单号',
  `purchase_order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '采购单号',
  `stock_status` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '入库状态（以采购单号为准）：0 未入库 1 部分入库 2 全部入库',
  `purchase_order_status` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '采购单状态（预留字段）0 采购中 2 采购完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-采购计划，采购单，生产订单，物料关联表';

DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `flow_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '流程id',
  `purchase_order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单编号',
  `supplier_no` varchar(255) NOT NULL DEFAULT '' COMMENT '供应商编号',
  `supplier_name` varchar(255) NOT NULL DEFAULT '' COMMENT '提供方',
  `demander` varchar(255) NOT NULL DEFAULT '' COMMENT '需方',
  `supplier_linkman` varchar(30) NOT NULL DEFAULT '' COMMENT '供方联系人',
  `demander_linkman` varchar(30) NOT NULL DEFAULT '' COMMENT '需方联系人',
  `supplier_addr` varchar(100) NOT NULL DEFAULT '' COMMENT '供方地址',
  `demander_addr` varchar(100) NOT NULL DEFAULT '' COMMENT '需方地址',
  `suppiler_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '供方联系人电话',
  `demander_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '需方联系人电话',
  `delivery_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '交货日期',
  `operator_user_name` varchar(30) NOT NULL DEFAULT '0' COMMENT '订单经办人',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '经办日期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1 已删除',
  `create_user_id` int(11) unsigned NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单信息表';


DROP TABLE IF EXISTS `purchase_order_item`;
CREATE TABLE `purchase_order_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '采购单单项id',
  `purchase_order_no` varchar(20) NOT NULL COMMENT '采购单编号',
  `product_name` varchar(20) NOT NULL DEFAULT '' COMMENT '物料名称',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '物料图号',
  `specification` varchar(50) NOT NULL DEFAULT '' COMMENT '规格',
  `material` varchar(20) NOT NULL DEFAULT '' COMMENT '材质',
  `unit` varchar(20) NOT NULL DEFAULT '' COMMENT '单位',
  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '数量',
  `unit_weight` decimal(12,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '单重',
  `unit_price` decimal(12,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '单价',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单单项表';


DROP TABLE IF EXISTS `inspect`;
CREATE TABLE `inspect` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '编号',
  `type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '送检订单类型：0 采购单 1 机加委托订单号 2 生产订单号',
  `status` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '送检单状态：0 未送检  1 待处理 2处理中 3处理完成',
  `inspect_no` varchar(20) NOT NULL DEFAULT '' COMMENT '送检单编号，type:0 1 1对多物料 type2 1对1成品',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '物料图号：type为2时，不填。',
  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号：type为0，1时，不填。',
  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '送检数量',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程表单-送检单信息表';


DROP TABLE IF EXISTS `material_inspect_result`;
CREATE TABLE `material_inspect_result` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `flow_id` int(11) NOT NULL COMMENT '流程id',
  `inspect_no` varchar(20) NOT NULL DEFAULT '' COMMENT '送检单编号',
  `material_graph_no` varchar(20) NOT NULL DEFAULT '' COMMENT '零件图号',
  `material_name` varchar(20) NOT NULL DEFAULT '' COMMENT '零件名称',
  `inspect_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '送检数量',
  `unqualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数量',
  `handling_result` varchar(4) NOT NULL DEFAULT '' COMMENT '处理结果： 退货（报废） 让步接受 返工（机加委托）json格式字符串（几种处理结果可能都有）',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0 未删除 1 已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程/业务表单-送检反馈信息表';


DROP TABLE IF EXISTS `pro_inspect_result`;
CREATE TABLE `pro_inspect_result` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `inspect_no` varchar(20) NOT NULL DEFAULT '' COMMENT '送检单号',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '生产订单编号',
  `product_model` varchar(64) NOT NULL COMMENT '成品型号',
  `testing_unit` varchar(255) NOT NULL DEFAULT '' COMMENT '检测单位',
  `testing_process` varchar(255) NOT NULL DEFAULT '' COMMENT '检测工序',
  `testing_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '检测数量',
  `unqualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数',
  `testing_person` varchar(255) NOT NULL DEFAULT '' COMMENT '操作人',
  `technical_requirements` varchar(255) NOT NULL DEFAULT '' COMMENT '技术要求',
  `testing_result` varchar(255) NOT NULL DEFAULT '' COMMENT '检测结果',
  `inspector` varchar(255) NOT NULL DEFAULT '' COMMENT '检验员',
  `inspecte_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '检验日期',
  `reason` varchar(255) NOT NULL DEFAULT '' COMMENT '不合格原因',
  `responsible_department` varchar(20) NOT NULL DEFAULT '' COMMENT '责任单位',
  `department_leader` varchar(30) NOT NULL DEFAULT '' COMMENT '责任认定部门负责人',
  `responsible_analyze_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '责任认定日期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0 未删除 1 已删除',
  `create_user_id` int(11) unsigned NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程/业务表单-成品质检不合格通知表';


DROP TABLE IF EXISTS `entrust`;
CREATE TABLE `entrust` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `purchase_order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '采购编号',
  `entrust_no` varchar(20) NOT NULL DEFAULT '' COMMENT '委托合同编号',
  `material_graph_no` varchar(50) NOT NULL DEFAULT '' COMMENT '成品图号',
  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '委托数量',
  `status` tinyint(4) NOT NULL COMMENT '状态：0 待处理 1 处理中 2 已完成',
  `entrust_person` varchar(255) NOT NULL DEFAULT '' COMMENT '委托人',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0 未删除 1 已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `create_user_id` int(11) unsigned NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-委托加工信息表';


DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `suppiler_no` varchar(11) NOT NULL DEFAULT '' COMMENT '供应商编号',
  `suppiler_name` varchar(100) NOT NULL DEFAULT '' COMMENT '企业名称',
  `website` varchar(255) NOT NULL DEFAULT '' COMMENT '网址',
  `nature` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '企业性质：0 国有 1 三资 2集体 3 联营 4 私营',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '电话',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '地址',
  `postcode` varchar(255) NOT NULL DEFAULT '' COMMENT '邮编',
  `fax` varchar(255) NOT NULL DEFAULT '' COMMENT '传真',
  `legal_person` varchar(255) NOT NULL DEFAULT '' COMMENT '法人',
  `legal_person_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '法人联系电话',
  `total_factory_area` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '工厂总面积',
  `total_archit_area` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '建筑总面积',
  `work_type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '班次类型：0 正常 1 两班倒 2 三班倒',
  `staff_info` varchar(255) NOT NULL DEFAULT '' COMMENT '员工信息，各类岗位人员总数，json格式',
  `credentials_info` varchar(255) NOT NULL DEFAULT '' COMMENT '证书信息，各类证书有无情况 json格式',
  `financial_info` varchar(255) NOT NULL DEFAULT '' COMMENT '财务状况：营业额，近三年应收情况。json格式',
  `main_organ` varchar(255) NOT NULL DEFAULT '' COMMENT '主要机构信息：部门，负责人，联系方式。json格式',
  `quality_assurance_info` varchar(255) NOT NULL DEFAULT '' COMMENT '质量保证体系信息：json格式',
  `process_route` varchar(255) NOT NULL DEFAULT '' COMMENT '工艺路线',
  `suppiler_preparer` varchar(20) NOT NULL DEFAULT '' COMMENT '供应商填表人',
  `responsible_person` varchar(20) NOT NULL DEFAULT '' COMMENT '负责人',
  `evaluation` varchar(1024) NOT NULL DEFAULT '' COMMENT '供应商评价：富文本编辑',
  `is_qualified` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否合格；0 待评定 1 合格 2 不合格',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '表单创建者id',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商信息表';


DROP TABLE IF EXISTS `supplier_product`;
CREATE TABLE `supplier_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier_no` varchar(20) NOT NULL DEFAULT '' COMMENT '供应商编号',
  `material_type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '零件的类型：0 供应商供货零件  1 供应商有但不供货的零件',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
  `material_name` varchar(50) NOT NULL DEFAULT '' COMMENT '零件名称',
  `annual_production` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '年产量',
  `main_customer` varchar(255) NOT NULL DEFAULT '' COMMENT '主要客户，多个逗号分隔',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1 已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `create_user_id` int(11) NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-供应商供应的成品信息表';

DROP TABLE IF EXISTS `supplier_evaluation_record`;
CREATE TABLE `supplier_evaluation_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier_num` varchar(20) NOT NULL DEFAULT '' COMMENT '供应商编号',
  `qc_way` varchar(20) NOT NULL DEFAULT '' COMMENT '质量控制方式：进货检验 0；  进货外观验证 1；  本公司到供方现场验证 2；顾客到供方现场验证 3；  顾客到本公司现场验证 4',
  `year` varchar(20) NOT NULL DEFAULT '' COMMENT '年度（例如：2017）',
  `quality_score` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '质量得分',
  `quality_person` varchar(255) NOT NULL DEFAULT '' COMMENT '质量评分人',
  `quality_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '质量得分日期',
  `deliver_score` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '按期交货得分',
  `deliver_person` varchar(255) NOT NULL COMMENT '按期交货评分人',
  `deliver_score_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '按期交货得分日期',
  `other_score` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '其他评分',
  `other_person` varchar(255) NOT NULL COMMENT '其他评分人',
  `other_score_date` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '其他评分日期',
  `price_score` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '价格得分',
  `price_person` varchar(255) NOT NULL COMMENT '价格评分人',
  `price_score_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '价格评价日期',
  `total_score` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '总分',
  `total_person` varchar(255) NOT NULL COMMENT '总分核算人',
  `total_score_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '总分核算日期',
  `manager_opinions` varchar(255) NOT NULL COMMENT '总经理意见',
  `manager_person` varchar(255) NOT NULL COMMENT '总经理签字',
  `manager_opinions_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '总经理签字日期',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `is_delete` tinyint(4) unsigned NOT NULL COMMENT '是否删除',
  `create_data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商年度评价信息表';

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `equipment_no` varchar(20) NOT NULL DEFAULT '' COMMENT '设备编号 ',
  `equipment_status` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '设备状态（针对本企业设备而言）：0 正常 1 损坏待处理 2 处理中 3 处理完成',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '数量',
  `type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '类型 0  制造设备 1 检测设备',
  `specification` varchar(255) NOT NULL DEFAULT '' COMMENT '型号规格',
  `supplier_no` varchar(30) NOT NULL DEFAULT '' COMMENT '供应商编号：如果编号为0，则为本企业设备，不为空未对应企业编号的设备',
  `product_factory` varchar(255) NOT NULL DEFAULT '' COMMENT '生产厂商',
  `serviced_years` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '已服役年限',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) unsigned NOT NULL COMMENT '是否删除 0 未删除 1 已删除',
  `create_user_id` int(11) NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-供应商设备清单表（本企业设备清单和供应商设备清单使用同一张表单）';

DROP TABLE IF EXISTS `equipment_maintain_record`;
CREATE TABLE `equipment_maintain_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `maintain_reason` varchar(255) NOT NULL COMMENT '维修原因',
  `equipment_no` varchar(20) NOT NULL DEFAULT '' COMMENT '设备号',
  `maintainer` varchar(20) NOT NULL DEFAULT '' COMMENT '维修者',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-设备维修记录';
