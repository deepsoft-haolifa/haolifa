DROP TABLE IF EXISTS `step`;
CREATE TABLE `step` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) NOT NULL COMMENT '创建用户',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '步骤名字',
  `description` varchar(256) NOT NULL DEFAULT '' COMMENT '步骤描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='步骤定义表（也叫节点，可以认为一个审核就是一个步骤）';

DROP TABLE IF EXISTS `flow`;
CREATE TABLE `flow` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) NOT NULL COMMENT '创建用户',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '流程名字',
  `description` varchar(256) NOT NULL DEFAULT '' COMMENT '流程描述',
  `flow` ADD COLUMN `role_id` INT(11) unsigned NOT NULL DEFAULT 0 COMMENT '发起流程的角色id',  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程配置表（用来配置系统中用到的流程）';

DROP TABLE IF EXISTS `flow_step`;
CREATE TABLE `flow_step` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) NOT NULL COMMENT '创建用户',
  `flow_id` int(11) NOT NULL DEFAULT '0' COMMENT '流程id',
  `step_id` int(11) NOT NULL DEFAULT '0' COMMENT '步骤id',
  `user_id` varchar(255) NOT NULL DEFAULT '' COMMENT '节点关联的',
  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '关联角色id',
  `step_order` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程步骤关联表（一个流程关联多个步骤）';

DROP TABLE IF EXISTS `flow_instance`;
CREATE TABLE `flow_instance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键-流程实例id',
  `summary` varchar(255) NOT NULL COMMENT '流程实例描述',
  `form_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单编号（采购、生产）',
  `flow_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '流程id',
  `current_step_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '待处理节点id ',
  `next_step_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '下一个节点id',
  `prev_step_id` int(11) NOT NULL COMMENT '上一个节点id',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前节点处理人id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前节点处理人角色',
  `is_over` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '流程是否结束 1 结束 0 进行中',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '流程实例创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '流程实例更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='流程实例表';

DROP TABLE IF EXISTS `flow_history`;
CREATE TABLE `flow_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `instance_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '流程id',
  `step_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '步骤id',
  `audit_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '审核人',
  `audit_info` varchar(1024) NOT NULL DEFAULT '' COMMENT '审核备注',
  `allot_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '指定下一节点操作人（指定采购员、装配组等）',
  `audit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审批日期',
  `audit_result` tinyint(4) NOT NULL COMMENT '审核结果： 0 审核不通过 1 审核通过 2 退回 3 流程初始化',
  `form_type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '外部表单类型：默认0 无 1 生产订单 2 请购单 3 采购单 4 送检单 5 产品质检单 6 零件质检单 7 发票单 8 发货单',
  `form_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '表单Id',
  `form_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单编号（生产、采购等）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='流程记录表';


	DROP TABLE IF EXISTS `sys_department`;
	CREATE TABLE `sys_department` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `dept_no` varchar(20) NOT NULL COMMENT '部门代号',
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
	  `pid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '父角色id',
	  `role_no` varchar(20) NOT NULL COMMENT '角色代号',
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

	DROP TABLE IF EXISTS `stock`;
	CREATE TABLE `stock` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `room_no` varchar(32) NOT NULL DEFAULT ''  COMMENT '库房No',
	  `rack_no` varchar(32) NOT NULL DEFAULT '' COMMENT '冗余货号（如：1号成品库 1101 1102 1103  1201 1202 1301 1302），通过这个就能确定是哪个库，哪个货架，哪个货位',
	  `product_no` char(36) NOT NULL DEFAULT '' COMMENT '成品编号',
	  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号',
    `product_specifications` varchar(64) DEFAULT '' NOT NULL COMMENT '成品规格',
	  `material_batch_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件批次号',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '库存类型：1.成品；2：零件;',
	  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '库存数量(编码时候考虑并发)',
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
	  `room_no` varchar(36) NOT NULL DEFAULT '' COMMENT '库房编号',
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
	  `room_no` varchar(32) NOT NULL DEFAULT '' COMMENT '库房编号',
	  `rack_name` varchar(32) NOT NULL DEFAULT '' COMMENT '库位名称',
	  `rack_no` varchar(32) NOT NULL DEFAULT '' COMMENT '库号（如：1号成品库 1101 1102 1103  1201 1202 1301 1302），通过这个就能确定是哪个库，哪个货架，哪个货位',
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
	  `rack_no` varchar(32) NOT NULL DEFAULT '' COMMENT '库号',
	  `order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单号',
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品编号',
	  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号',
    `product_specifications` varchar(64) DEFAULT '' NOT NULL COMMENT '成品规格',
    `material_batch_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件批次号',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `operation_type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '操作类型：1.出库；2：入库;',
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '出入库类型：1.成品；2：零件;',
	  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '出库，入库的数量',
	  `amount` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '出库，入库金额',
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
	  `replace_graph_nos` varchar(256) NOT NULL DEFAULT '' COMMENT '可替换零件编号(可多个，用逗号分割)',
	  `graph_url` varchar(128) NOT NULL DEFAULT '' COMMENT '零件图纸url',
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
	  `lock_quantity` int(11) NOT NULL DEFAULT 0 COMMENT '锁定数量（核料成功锁定，零件出库的时候释放）',
	  `support_quantity` int(11) NOT NULL DEFAULT 1 COMMENT '配套数量（核料时用到，一个产品需要多少个零件）',
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
	  `order_no` varchar(64) NOT NULL COMMENT '订单编号（目前暂时和合同编号一致）',
	  `order_contract_no` varchar (128) NOT NULL DEFAULT '' COMMENT '合同编号',
	  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
	  `order_contract_url` varchar(128) NOT NULL DEFAULT '' COMMENT '订单合同url（默认价格隐藏）',
	  `order_contract_extend_url` varchar(128) NOT NULL DEFAULT '' COMMENT '订单合同url',
	  `technical_require` varchar(1024) NOT NULL DEFAULT '' COMMENT '技术清单要求（技术员填写）',
	  `finish_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '工厂反馈完成时间',
	  `feedback_time_confirm_user` varchar(32) NOT NULL DEFAULT '' COMMENT '反馈确认人',
	  `purchase_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '采购反馈时间',
	  `production_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '生产反馈时间',
	  `assembly_shop` varchar(32) NOT NULL DEFAULT '' COMMENT '装配车间',
	  `assembly_group` varchar(32) NOT NULL DEFAULT '' COMMENT '装配小组',
	  `demand_name` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方名称',
	  `demand_agent_name` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方代理人',
	  `demand_phone` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方电话',
	  `demand_fax` varchar(32) NOT NULL DEFAULT '' COMMENT '需求方传真',
	  `demand_bank_name` varchar(32) NOT NULL DEFAULT '' COMMENT '需求开户银行',
	  `demand_bank_card_no` varchar(64) NOT NULL DEFAULT '' COMMENT '需求开户银行账号',
	  `supply_name` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方',
	  `supply_agent_name` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方代理人',
	  `supply_phone` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方电话',
	  `supply_fax` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方传真',
	  `supply_bank_name` varchar(32) NOT NULL DEFAULT '' COMMENT '供应方开户银行',
	  `contract_bank_card_no` varchar(64) NOT NULL DEFAULT '' COMMENT '供应方开户银行账号',
	  `delivery_place` varchar(64) NOT NULL DEFAULT '' COMMENT '交货地点',
	  `delivery_date` varchar(64) NOT NULL DEFAULT '' COMMENT '交货日期',
	  `contract_sign_date` varchar(32) NOT NULL DEFAULT '' COMMENT '合同签订日期',
	  `total_count` int(11) NOT NULL DEFAULT 0 COMMENT '数量合计',
	  `discount_total_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '优惠后总价',
	  `total_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '总价',
	  `special_require` varchar(256) NOT NULL DEFAULT '' COMMENT '特殊要求',
	  `cargo_information` varchar(256) NOT NULL DEFAULT '' COMMENT '随货资料',
	  `sign_board` varchar(256) NOT NULL DEFAULT '' COMMENT '标牌',
	  `acceptance_criteria` varchar(256) NOT NULL DEFAULT '' COMMENT '验收标准',
	  `warranty_period` varchar(256) NOT NULL DEFAULT '' COMMENT '质保期限',
	  `packaging_specification` varchar(256) NOT NULL DEFAULT '' COMMENT '包装规范',
	  `remark` varchar(256) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_order_no` (`order_no`),
	  UNIQUE KEY `uk_order_contract_no` (`order_contract_no`),
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品订单表(商务销售发起订单流程的时候插入)';

	DROP TABLE IF EXISTS `order_product_associate`;
	CREATE TABLE `order_product_associate` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `order_no` varchar(64) NOT NULL COMMENT '订单编号',
	  `product_no` varchar(64) NOT NULL DEFAULT '' COMMENT '成品编号',
	  `product_name` varchar(64) NOT NULL DEFAULT '' COMMENT '成品名称',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '成品规格',
	  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号',
	  `lable` varchar(64) NOT NULL DEFAULT '' COMMENT '标签属性',
	  `product_color` varchar(32) NOT NULL DEFAULT '' COMMENT '颜色',
	  `product_number` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `total_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '合计价格',
	  `material_description` varchar(1024) NOT NULL DEFAULT '' COMMENT '材质说明',
	  `product_remark` varchar(1024) NOT NULL DEFAULT '' COMMENT '成品备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单成品关联表（一个订单多个成品）';


	DROP TABLE IF EXISTS `order_material`;
	CREATE TABLE `order_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `order_no` varchar(64) NOT NULL COMMENT '订单编号',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `material_name` varchar(64) NOT NULL DEFAULT '' COMMENT '零件名称',
	  `replace_material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '替换料零件图号',
	  `replace_material_name` varchar(64) NOT NULL DEFAULT '' COMMENT '替换料零件名称',
	  `audit_result` tinyint(4) NOT NULL DEFAULT 0 COMMENT '替换料审核结果（1.同意；2.不同意）',
	  `material_count` int(11) NOT NULL DEFAULT 0 COMMENT '需要的零件数量',
	  `lack_material_count` int(11) NOT NULL DEFAULT 0 COMMENT '缺少的零件数量',
	  `check_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态（1.核料成功，2.缺料，需要采购,3.替换,4.释放料.5.领料完成）',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY uk_order_graph(`order_no`,`material_graph_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单零件关联表（一个订单需要哪些零件,核料完成之后生成）';

  DROP TABLE IF EXISTS `check_material_log`;
	CREATE TABLE `check_material_log` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `check_user_id` int(11) NOT NULL COMMENT '核料人',
	  `order_no` varchar(64) NOT NULL COMMENT '订单号',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件号',
	  `current_material_count` int(11) NOT NULL DEFAULT 0 COMMENT '当前零件库存',
	  `need_material_count` int(11) NOT NULL DEFAULT 0 COMMENT '需要的零件库存',
	  `check_state` varchar(64) NOT NULL DEFAULT '' COMMENT '核料状态',
	  `check_result` varchar(64) NOT NULL DEFAULT '' COMMENT '核料结果',
	  PRIMARY KEY (`id`),
	  INDEX idx_order_no(`order_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='核料日志记录表';


--   DROP TABLE IF EXISTS `material_requisition`;
-- 	CREATE TABLE `material_requisition` (
-- 	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
-- 	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
-- 	  `create_user` int(11) NOT NULL COMMENT '创建用户',
-- 	  `receive_no` char(36) NOT NULL COMMENT '领料单号',
-- 	  `order_no` varchar(64) NOT NULL default '' COMMENT '订单号',
-- 	  `receive_department` varchar(36) NOT NULL DEFAULT '' COMMENT '领料部门',
-- 	  `receive_user_id` varchar(36) NOT NULL DEFAULT '' COMMENT '领料用户Id',
-- 	  `receive_user_name` varchar(36) NOT NULL DEFAULT '' COMMENT '领料用户姓名',
-- 	  `order_material_id` int(11) NOT NULL DEFAULT 0 COMMENT '订单零件关联表ID',
-- 	  PRIMARY KEY (`id`),
-- 	  UNIQUE KEY `uk_receive_no` (`receive_no`)
-- 	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='领料单表';


	DROP TABLE IF EXISTS `product`;
	CREATE TABLE `product` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品号（例如：prod_123123）',
	  `product_model` varchar(36) NOT NULL DEFAULT '' COMMENT '成品型号（行业规范如：D7A1X3P-16Q-DN50）',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '成品名称',
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
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品号（自己生成唯一）',
	  `product_model` varchar(36) NOT NULL DEFAULT '' COMMENT '成品型号（行业规范如：D7A1X3P-16Q-DN50）',
	  `specification` varchar(36) NOT NULL DEFAULT '' COMMENT '成品规格',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `material_count` int(11) NOT NULL DEFAULT 0 COMMENT '零件数量',
	  `replace_material_graph_nos` varchar(256) NOT NULL DEFAULT '' COMMENT '可替换零件编号(可多个，用逗号分割)',
	  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '关联状态（0关联，1不关联）',
	  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_multi` (`product_no`,`material_graph_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品零件关联表（主要记录一个成品是由哪些零件组成，多对多的关系）';


	DROP TABLE IF EXISTS `product_model_config`;
	CREATE TABLE `product_model_config` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `index_rule` varchar(36) NOT NULL DEFAULT '' COMMENT '索引规则（例如：Q/P/X）',
	  `material_graph_no_str` varchar(36) NOT NULL DEFAULT '' COMMENT '零件图号中对应的单词（例如：Qa/Qb/Qc）',
	  `material_graph_no_indexof` varchar(36) NOT NULL DEFAULT '' COMMENT '零件图号中对应的位置',
	  `material_type` varchar(36) NOT NULL DEFAULT '' COMMENT '类型（fati.阀体；fazuo.阀座；faban：阀板；fatiyali.阀体压力）',
	  `product_type` varchar(36) NOT NULL DEFAULT '' COMMENT '产品类型（D：蝶阀，H：止回阀）',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注描述',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品型号规则配置表';


DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `flow_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '流程id',
  `order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单合同编号',
  `invoice_no` varchar(64) NOT NULL DEFAULT '' COMMENT '发票号',
  `total_amount` decimal(11,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '总金额',
  `company` varchar(255) NOT NULL DEFAULT '' COMMENT '单位',
  `linkman` varchar(255) NOT NULL DEFAULT '' COMMENT '联系人',
  `mialing_address` varchar(255) NOT NULL DEFAULT '' COMMENT '邮寄地址',
  `details` varchar(255) NOT NULL DEFAULT '' COMMENT '明细',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0  未删除 1 已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-发票管理表';

DROP TABLE IF EXISTS `expenses`;
CREATE TABLE `expenses` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `total_amount` decimal(11,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '总金额',
  `expenses_classify` varchar(255) NOT NULL DEFAULT '' COMMENT '费用类别',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建人',
  `commit_user` varchar(255) NOT NULL DEFAULT '' COMMENT '提交人',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-费用管理';

DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单编号',
  `contract_name` varchar(255) NOT NULL DEFAULT '' COMMENT '合同名称',
  `contract_type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '合同类型：1 租赁 2 采购 3 装修 4 服务 5 印刷 6 教材编写 7 初版 8 加盟 9 收购 10 其他',
  `contract_duration` varchar(255) NOT NULL DEFAULT '' COMMENT '合同期间',
  `contract_subject` varchar(255) NOT NULL DEFAULT '' COMMENT '合同主体',
  `total_amount` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '总金额',
  `contract_party` varchar(255) NOT NULL DEFAULT '' COMMENT '合同方',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '地址',
  `linkman` varchar(255) NOT NULL DEFAULT '' COMMENT '联系人',
  `linkman_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '联系人电话',
  `leader` varchar(255) NOT NULL DEFAULT '' COMMENT '负责人',
  `leader_phone` varchar(11) NOT NULL DEFAULT '' COMMENT '负责人电话',
  `payment_cycle` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '支付周期：1 月付 2 两月付 3 季付 4 半年付 5 年付 6 其他',
  `payment_mode` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '付款方式：1 现金 2 支票 3 汇款',
  `contract_summary` varchar(1023) NOT NULL DEFAULT '' COMMENT '合同摘要及说明',
  `accessory` varchar(2047) NOT NULL DEFAULT '' COMMENT '合同附件：json格式；{“附件名称”："附件地址"}',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建人',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表单-合同表';


DROP TABLE IF EXISTS `apply_buy`;
CREATE TABLE `apply_buy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `flow_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '流程id',
  `apply_no` varchar(64) NOT NULL DEFAULT '' COMMENT '请购单号',
  `product_order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '生产订单编号',
  `target_time` timestamp NOT NULL COMMENT '预期时间',
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
  `purchase_order_no` varchar(32) NOT NULL DEFAULT '' COMMENT '订单编号',
  `supplier_no` varchar(255) NOT NULL DEFAULT '' COMMENT '供应商编号',
  `supplier_name` varchar(255) NOT NULL DEFAULT '' COMMENT '提供方',
  `demander` varchar(255) NOT NULL DEFAULT '' COMMENT '需方',
  `supplier_linkman` varchar(30) NOT NULL DEFAULT '' COMMENT '供方联系人',
  `demander_linkman` varchar(30) NOT NULL DEFAULT '' COMMENT '需方联系人',
  `supplier_addr` varchar(100) NOT NULL DEFAULT '' COMMENT '供方地址',
  `demander_addr` varchar(100) NOT NULL DEFAULT '' COMMENT '需方地址',
  `suppiler_phone` varchar(15) NOT NULL DEFAULT '' COMMENT '供方联系人电话',
  `demander_phone` varchar(15) NOT NULL DEFAULT '' COMMENT '需方联系人电话',
  `delivery_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '交货日期',
  `operator_user_name` varchar(30) NOT NULL DEFAULT '0' COMMENT '订单经办人',
  `operate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '经办日期',
  `supplier_confirmer` varchar(255) NOT NULL DEFAULT '' COMMENT '供方确认人',
  `confirm_time` timestamp NOT NULL COMMENT '确认时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除 0 未删除 1 已删除',
  `create_user_id` int(11) unsigned NOT NULL COMMENT '创建者id',
  `wreck_amount` decimal(12,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '折损金额',
  `wreck_reason` varchar(255) NOT NULL DEFAULT '' COMMENT '折损原因',
  `status` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '订单状态：1 待审批 2 审批中 3 采购中 4 审批不通过 5 采购完成',
  `pay_type` varchar(255) NOT NULL DEFAULT '' COMMENT '付款方式',
  `order_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 采购订单 1 外部机加工订单',
  `file_url` varchar(1024) NOT NULL DEFAULT '' COMMENT '订单附件下载地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单信息表';


DROP TABLE IF EXISTS `purchase_order_item`;
CREATE TABLE `purchase_order_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '单项id',
  `purchase_order_no` varchar(64) NOT NULL COMMENT '采购订单编号',
  `apply_no` varchar(64) NOT NULL COMMENT '请购单编号',
  `material_name` varchar(20) NOT NULL DEFAULT '' COMMENT '物料名称',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '物料图号',
  `specification` varchar(50) NOT NULL DEFAULT '' COMMENT '规格',
  `material` varchar(20) NOT NULL DEFAULT '' COMMENT '材质',
  `unit` varchar(20) NOT NULL DEFAULT '' COMMENT '单位',
  `number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '数量',
  `unit_weight` decimal(12,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '单重',
  `unit_price` decimal(12,4) unsigned NOT NULL DEFAULT '0.0000' COMMENT '单价',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `purpose` varchar(255) NOT NULL DEFAULT '' COMMENT '用途--请购单',
  `valuation` double(12,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '估价-请购单',
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
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新日期',
  `create_user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程/业务表单-送检反馈信息表';


DROP TABLE IF EXISTS `pro_inspect_record`;
CREATE TABLE `pro_inspect_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(36) NOT NULL DEFAULT '' COMMENT '生产订单编号',
  `product_no` varchar(64) NOT NULL DEFAULT '' COMMENT '成品号',
  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号',
  `product_specifications` varchar(64) DEFAULT '' NOT NULL COMMENT '成品规格',
  `testing_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '检测数量',
  `qualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '合格数',
  `unqualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数',
  `reason` varchar(128) NOT NULL DEFAULT '' COMMENT '不合格原因',
  `storage_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1.待入库，2.入库完成',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) unsigned NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品质检记录';

DROP TABLE IF EXISTS `pressure_inspect_record`;
CREATE TABLE `pressure_inspect_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(36) NOT NULL DEFAULT '' COMMENT '生产订单编号',
  `product_no` varchar(64) NOT NULL DEFAULT '' COMMENT '成品号',
  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号',
  `product_specifications` varchar(64) DEFAULT '' NOT NULL COMMENT '成品规格',
   `testing_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '检测数量',
  `reinspect_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '复检数量',
  `qualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '合格数',
  `unqualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数',
  `reason` varchar(128) NOT NULL DEFAULT '' COMMENT '不合格原因',
  `testing_person` varchar(32) NOT NULL DEFAULT '' COMMENT '操作人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user_id` int(11) unsigned NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='压力测试记录';




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


DROP TABLE IF EXISTS `delivery_record`;
CREATE TABLE `delivery_record` (
	`id` INT (11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
	`create_user_id` INT (11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '创建者id',
	`delivery_classify` tinyint(4) unsigned NOT NULL DEFAULT 0 COMMENT '发货分类（1.销售订单；2.售后订单；3.外调货；4.调压箱；5.其他）',
	`delivery_notice_no` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '发货通知单号',
	`contract_order_no` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '合同订单号',
	`delivery_time` TIMESTAMP DEFAULT NULL COMMENT '发货日期/到货日期',
	`operation_no` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '运营单号',
	`customer_no` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '客户代号',
	`product_count` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '成品发货数量',
	`packing_mode` VARCHAR (32) NOT NULL DEFAULT '' COMMENT '包装方式',
	`piece_count` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '件数',
	`transport_company` VARCHAR (32) NOT NULL DEFAULT '' COMMENT '承运单位',
	`courier_no` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '运单号',
	`collect_provice` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '省市',
	`collect_address` VARCHAR (128) NOT NULL DEFAULT '' COMMENT '地址',
	`collect_name` VARCHAR (32) NOT NULL DEFAULT '' COMMENT '收货人',
	`collect_phone` VARCHAR (32) NOT NULL DEFAULT '' COMMENT '收货人电话',
	`weight_piece` decimal(10,3)  DEFAULT NULL COMMENT '重量/件数',
	`price_piece` decimal(10,4) DEFAULT NULL COMMENT '单价/计件',
	`delivery_fee` decimal(10,4) DEFAULT NULL COMMENT '送货费',
	`total_fee` decimal(10,4) DEFAULT NULL COMMENT '运费总金额',
	`settlement_way` VARCHAR (32) NOT NULL DEFAULT '' COMMENT '结算方式',
	`remark` VARCHAR (256) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '发货记录表单';


DROP TABLE IF EXISTS `delivery_notice`;
CREATE TABLE `delivery_notice` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`create_user_id` INT (11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者id',
	`delivery_url` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '发货通知单Url',
	`contract_order_no` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '合同订单号',
  `delivery_no` varchar(64) NOT NULL DEFAULT '' COMMENT '发货通知单号',
  `audit_user_id` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '审核人',
  `audit_info` varchar(1024) NOT NULL DEFAULT '' COMMENT '审核备注',
  `audit_time` timestamp  DEFAULT NULL  COMMENT '审批日期',
  `audit_result` tinyint(4) NOT NULL DEFAULT 0  COMMENT '审核结果： 0 未审核 1审核不通过 2 审核通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='发货通知单';

	DROP TABLE IF EXISTS `replace_material`;
	CREATE TABLE `replace_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user_id` INT (11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者id',
	  `replace_material_no` varchar(64) NOT NULL DEFAULT ''  COMMENT '更换单号（自动生成）',
	  `order_no` varchar(64) NOT NULL DEFAULT ''  COMMENT '订单编号',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `material_name` varchar(64) NOT NULL DEFAULT '' COMMENT '零件名称',
	  `material_unit` varchar(64) NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
	  `material_count` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
	  `replace_reason` varchar(128) NOT NULL DEFAULT '' COMMENT '更换原因',
	  `responsible_person` varchar(32) NOT NULL DEFAULT '' COMMENT '责任人',
	  `audit_user_id` int(11) unsigned NOT NULL DEFAULT 0 COMMENT '技术审核人',
    `audit_info` varchar(1024) NOT NULL DEFAULT '' COMMENT '技术审核备注',
    `audit_time` timestamp  DEFAULT NULL  COMMENT '技术审批日期',
    `audit_result` tinyint(4) NOT NULL DEFAULT 0  COMMENT '技术审核结果： 0 未审核 1审核不通过 2 审核通过 3 已出库',
	  `remark` varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='更换零件表（车间主任中间要求替换料）';

DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `type` tinyint(4) NOT NULL COMMENT '类型：1-新闻，2-消息',
  `show_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '展示时间',
  `create_user` int(11) NOT NULL COMMENT '创建者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='消息/新闻表';

DROP TABLE IF EXISTS `file_record`;
CREATE TABLE `file_record` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `file_name` varchar(64) NOT NULL DEFAULT '' COMMENT '文件名称',
  `file_url` varchar(64) NOT NULL DEFAULT '' COMMENT '文件url',
  `type` TINYINT(4) NOT NULL COMMENT '类型：1-零件图纸，2-成品图纸',
  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '文件备注',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='文件记录列表（图纸管理）';


DROP TABLE IF EXISTS `price_product`;
	CREATE TABLE `price_product` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品号',
	  `model` varchar(36) NOT NULL DEFAULT '' COMMENT '型号',
	  `connection_mode` varchar(32) NOT NULL DEFAULT '' COMMENT '连接方式',
	  `structural_style` varchar(32) NOT NULL DEFAULT '' COMMENT '结构形式',
	  `nominal_pressure` varchar(32) NOT NULL DEFAULT '' COMMENT '公称压力',
	  `fati_material` varchar(32) NOT NULL DEFAULT '' COMMENT '阀体材质',
	  `faban_material` varchar(32) NOT NULL DEFAULT '' COMMENT '阀板材质',
	  `seal_form` varchar(32) NOT NULL DEFAULT '' COMMENT '密封形式',
	  `fazhou_material` varchar(32) NOT NULL DEFAULT '' COMMENT '阀轴材质',
	  `accessories` varchar(32) NOT NULL DEFAULT '' COMMENT '辅料',
	  `drive` varchar(32) NOT NULL DEFAULT '' COMMENT '驱动',
	  `haoli_model` varchar(32) NOT NULL DEFAULT '' COMMENT '好利型号',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '规格（如：DN65，DN80）',
	  `product_price` varchar(32) NOT NULL DEFAULT '' COMMENT '成品单价(元)',
	  `price_book` varchar(32) NOT NULL DEFAULT '' COMMENT '价格书',
	  `fati_price` varchar(32) NOT NULL DEFAULT '' COMMENT '阀体单价(元)',
	  `faban_price` varchar(32) NOT NULL DEFAULT '' COMMENT '阀板单价(元)',
	  `fazuo_price` varchar(32) NOT NULL DEFAULT '' COMMENT '阀座单价(元)',
	  `fazhou_price` varchar(32) NOT NULL DEFAULT '' COMMENT '阀轴单价(元)',
	  `accessories_price` varchar(32) NOT NULL DEFAULT '' COMMENT '辅料单价(元)',
	  `drive_price` varchar(32) NOT NULL DEFAULT '' COMMENT '驱动单价(元)',
	  `total_price` varchar(32) NOT NULL DEFAULT '' COMMENT '合计单价(元)',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品价格管理表';

DROP TABLE IF EXISTS `price_material`;
	CREATE TABLE `price_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `material_classify_name` char(36) NOT NULL DEFAULT '' COMMENT '零件分类名称',
	  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '零件名称',
	  `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '图号',
	   `model` varchar(64) NOT NULL DEFAULT '' COMMENT '型号',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '规格',
	  `material` varchar(64) NOT NULL DEFAULT '' COMMENT '材料',
	  `unit` varchar(64) NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
	  `actual_weight` varchar(32) NOT NULL DEFAULT '' COMMENT '实际重量',
	  `ton_price` varchar(32) NOT NULL DEFAULT '' COMMENT '吨价(元)',
	  `blank_cost` varchar(32) NOT NULL DEFAULT '' COMMENT '毛坯费（元）',
	  `process_cost` varchar(32) NOT NULL DEFAULT '' COMMENT '加工费（元）',
	  `product_price` varchar(32) NOT NULL DEFAULT '' COMMENT '成品价（元）',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件价格管理表';

DROP TABLE IF EXISTS `spray`;
CREATE TABLE `spray` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spray_no` varchar(64) NOT NULL DEFAULT '',
  `planner` varchar(255) NOT NULL DEFAULT '',
	`total_number` int(11) not null default 0 COMMENT '喷涂总数量',
  `qualified_number` int(11) not null default 0 COMMENT '合格数',
	`status` TINYINT(4) not null default 0 COMMENT '喷涂状态：0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工',
	`file_url` VARCHAR(255) not null default '' comment '文件地址；需上传',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='喷涂单';

DROP TABLE IF EXISTS `spray_item`;
CREATE TABLE `spray_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spray_no` varchar(64) NOT NULL DEFAULT '' COMMENT '喷涂号',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '图号',
  `specifications` varchar(255) NOT NULL DEFAULT '' COMMENT '规格',
  `model` varchar(255) NOT NULL DEFAULT '' COMMENT '型号',
  `material_classify_name` varchar(255) NOT NULL DEFAULT '' COMMENT '物料名称',
  `material` varchar(255) NOT NULL DEFAULT '' COMMENT '材质',
  `special_requires` varchar(255) NOT NULL DEFAULT '' COMMENT '特殊要求',
  `spray_color` varchar(255) NOT NULL DEFAULT '' COMMENT '喷涂颜色',
  `number` int(11) NOT NULL DEFAULT '0' COMMENT '喷涂数量',
  `qualified_number` int(11) NOT NULL DEFAULT '0' COMMENT '检验合格数量',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `complete_time` varchar(255) NOT NULL DEFAULT '' COMMENT '完成时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='喷涂单项';

DROP TABLE IF EXISTS `spray_inspect_history`;
CREATE TABLE `spray_inspect_history` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `spray_no` varchar(64) NOT NULL DEFAULT '' COMMENT '质检单号',
  `original_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '原图号',
  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '物料图号',
  `material_graph_name` varchar(255) NOT NULL DEFAULT '' COMMENT '物料名称',
  `test_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '检测数量',
  `qualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '合格数量',
  `unqualified_number` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数量',
  `handling_suggestion` varchar(255) NOT NULL DEFAULT '' COMMENT '处理意见',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `status` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '状态：1 待入库 2 已入库',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '喷涂检验历史';

DROP TABLE IF EXISTS `order_file`;
CREATE TABLE `order_file` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单号',
  `file_name` varchar(64) NOT NULL DEFAULT '' COMMENT '文件名称',
  `file_url` varchar(64) NOT NULL DEFAULT '' COMMENT '文件url',
  `file_type` varchar(64) NOT NULL DEFAULT '' COMMENT '文件类型',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订单附件记录表';
