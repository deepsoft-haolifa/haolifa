alter table inspect add column `freight` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '运费' after unqualified_number;




drop table if EXISTS product ;
CREATE TABLE `product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品号（例如：prod_123123）',
  `product_model` varchar(36) NOT NULL DEFAULT '' COMMENT '成品型号（行业规范如：D7A1X3P-16Q-DN50）',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '成品名称',
  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '成品规格（如：DN65，DN80）',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '成品状态',
  `qty` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '成品库存',
  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` int(11) NOT NULL COMMENT '创建用户',
  `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='成品表';

drop table if EXISTS product_stock_log ;
CREATE TABLE `product_stock_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_no` varchar(64) NOT NULL DEFAULT '' COMMENT '订单号',
  `entry_out_record_id` int(11) NOT NULL DEFAULT 0 COMMENT '出入库记录Id',
  `product_no` varchar(36) NOT NULL DEFAULT '' COMMENT '成品号',
  `product_model` varchar(36) NOT NULL DEFAULT '' COMMENT '成品型号（行业规范如：D7A1X3P-16Q-DN50）',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '成品名称',
  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '成品规格（如：DN65，DN80）',
  `qty` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '成品库存',
  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` int(11) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='成品库存记录表';

-- 添加菜单
INSERT INTO `sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (157, 'm', '订单列表（可修改产品信息）', 'ddlbproduct', 87, 0, NOW(),NOW());
INSERT INTO `sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (158, 'm', '成品库存列表', 'cpkclb', 50, 0, NOW(),NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 157, NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 158,  NOW(), NOW());
