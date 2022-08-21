CREATE TABLE `technical_detailed` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(64) NOT NULL DEFAULT '' COMMENT '产品名称',
  `product_model` varchar(64) DEFAULT '' COMMENT '型号',
  `specifications` varchar(64) DEFAULT ''  COMMENT '规格',
  `upper_flange_standard` varchar(64) DEFAULT ''  COMMENT '上法兰标准',
  `connecting_hole` varchar(64) DEFAULT ''  COMMENT '连接孔',
  `angle` varchar(64) DEFAULT '' COMMENT  '角度',
  `center_distance` varchar(64) DEFAULT ''  COMMENT '中心距',
  `output_shaft_type` varchar(64) DEFAULT ''  COMMENT '出轴型式',
  `output_shaft_length` varchar(64) DEFAULT '' COMMENT '出轴长度',
  `axis_drawing_no` varchar(64) DEFAULT '' COMMENT '轴图号',
  `connecting_sleeve` varchar(64) DEFAULT '' COMMENT '连接套',
  `transition_plate` varchar(64) DEFAULT '' COMMENT '过渡盘',
  `static_torque` varchar(64) DEFAULT '' COMMENT '静扭矩',
  `actuator_model` varchar(64) DEFAULT '' COMMENT '执行器型号',
  `remark` varchar(128) DEFAULT '' COMMENT '备注',
  `create_user` varchar(20) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_user` varchar(20) NOT NULL DEFAULT '' COMMENT '更新人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='技术清单';


CREATE TABLE `order_technical_detailed_rel` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) NOT NULL COMMENT '订单编号',
  `product_name` varchar(64) NOT NULL DEFAULT '' COMMENT '产品名称',
  `product_num` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `product_model` varchar(64) DEFAULT '' COMMENT '型号',
  `specifications` varchar(64) DEFAULT ''  COMMENT '规格',
  `upper_flange_standard` varchar(64) DEFAULT ''  COMMENT '上法兰标准',
  `connecting_hole` varchar(64) DEFAULT ''  COMMENT '连接孔',
  `angle` varchar(64) DEFAULT '' COMMENT  '角度',
  `center_distance` varchar(64) DEFAULT ''  COMMENT '中心距',
  `output_shaft_type` varchar(64) DEFAULT ''  COMMENT '出轴型式',
  `output_shaft_length` varchar(64) DEFAULT '' COMMENT '出轴长度',
  `axis_drawing_no` varchar(64) DEFAULT '' COMMENT '轴图号',
  `connecting_sleeve` varchar(64) DEFAULT '' COMMENT '连接套',
  `transition_plate` varchar(64) DEFAULT '' COMMENT '过渡盘',
  `static_torque` varchar(64) DEFAULT '' COMMENT '静扭矩',
  `actuator_model` varchar(64) DEFAULT '' COMMENT '执行器型号',
  `remark` varchar(128) DEFAULT '' COMMENT '备注',
  `create_user` varchar(20) NOT NULL DEFAULT '' COMMENT '创建人',
  `update_user` varchar(20) NOT NULL DEFAULT '' COMMENT '更新人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单-技术清单-关联';

INSERT INTO `sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES ('241', 'm', '技术清单', 'jsqd', '89', '0', NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 241, NOW(), NOW());
