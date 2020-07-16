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

