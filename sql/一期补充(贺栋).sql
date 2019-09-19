DROP TABLE IF EXISTS `graph_no_rel`;
CREATE TABLE `graph_no_rel` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
   `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '正式图号',
  `graph_no_m` varchar(64) NOT NULL DEFAULT '' COMMENT '毛坯图号',
  `graph_no_j` varchar(64) NOT NULL DEFAULT '' COMMENT '机加工图号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图号关联表';