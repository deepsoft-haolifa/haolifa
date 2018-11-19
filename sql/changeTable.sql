
	DROP TABLE IF EXISTS `order_product`;
	CREATE TABLE `order_product` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `order_no` varchar(128) NOT NULL COMMENT '订单编号（自己生成）',
	  `order_contract_no` varchar (128) NOT NULL DEFAULT '' COMMENT '合同编号',
	  `order_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单状态',
	  `order_contract_url` varchar(64) NOT NULL DEFAULT '' COMMENT '订单合同url',
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
	  `finish_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '工厂反馈完成时间',
	  `feedback_time_confirm_user` varchar(32) NOT NULL DEFAULT '' COMMENT '反馈确认人',
	  `purchase_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '采购反馈时间',
	  `production_feedback_time` varchar(32) NOT NULL DEFAULT '' COMMENT '生产反馈时间',
	  `special_require` varchar(256) NOT NULL DEFAULT '' COMMENT '特殊要求',
	  `cargo_information` varchar(256) NOT NULL DEFAULT '' COMMENT '随货资料',
	  `sign_board` varchar(256) NOT NULL DEFAULT '' COMMENT '标牌',
	  `acceptance_criteria` varchar(256) NOT NULL DEFAULT '' COMMENT '验收标准',
	  `warranty_period` varchar(256) NOT NULL DEFAULT '' COMMENT '质保期限',
	  `packaging_specification` varchar(256) NOT NULL DEFAULT '' COMMENT '包装规范',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_order_no` (`order_no`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品订单表(商务销售发起订单流程的时候插入)';

	DROP TABLE IF EXISTS `order_product_associate`;
	CREATE TABLE `order_product_associate` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `order_no` varchar(128) NOT NULL COMMENT '订单编号（自己生成）',
	  `product_no` varchar(64) NOT NULL DEFAULT '' COMMENT '成品编号',
	  `product_name` varchar(64) NOT NULL DEFAULT '' COMMENT '成品名称',
	  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '成品规格',
	  `product_model` varchar(64) NOT NULL DEFAULT '' COMMENT '成品型号',
	  `lable` varchar(64) NOT NULL DEFAULT '' COMMENT '标签属性',
	  `product_color` varchar(32) NOT NULL DEFAULT '' COMMENT '颜色',
	  `product_number` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
	  `price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
	  `total_price` decimal(12,4) NOT NULL DEFAULT '0.0000' COMMENT '合计价格',
	  `material_description` varchar(128) NOT NULL DEFAULT '' COMMENT '材质说明',
	  `product_remark` varchar(1024) NOT NULL DEFAULT '' COMMENT '成品备注',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单成品关联表（一个订单多个成品）';


	DROP TABLE IF EXISTS `order_material`;
	CREATE TABLE `order_material` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	  `create_user` int(11) NOT NULL COMMENT '创建用户',
	  `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
	  `order_no` char(36) NOT NULL COMMENT '订单号',
	  `order_product_associate_id` int(11) NOT NULL  default 0 COMMENT '订单成品Id',
	  `material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零件图号',
	  `replace_material_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '可替换零件图号',
	  `material_count` int(11) NOT NULL DEFAULT 0 COMMENT '需要的零件数量',
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单零件关联表（一个订单需要哪些零件）';


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
	  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类型（1.阀座；2.阀板；3：阀体；4.阀体压力）',
	  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注描述',
	  PRIMARY KEY (`id`),
	  UNIQUE KEY `uk_multi` (`index_rule`,`type`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成品型号规则配置表';

