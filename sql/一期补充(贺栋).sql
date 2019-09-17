DROP TABLE IF EXISTS `customer_graph_no`;
CREATE TABLE `customer_graph_no` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `customer_code` varchar(64) NOT NULL DEFAULT '' COMMENT '客户代号',
  `customer_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '大客户的图号',
  `haoli_graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '好利图号'
  PRIMARY KEY (`id`),
  KEY `ids_customer_graph_no` (`customer_graph_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大客户图号对应表';
