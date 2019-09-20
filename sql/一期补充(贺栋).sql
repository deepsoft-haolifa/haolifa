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



-- 添加新的核料规则（记得删除redis缓存）

INSERT INTO `product_model_config`(`create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), 'Q', 'QaEa', '', 'fati', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '10', 'p', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '16', 'p', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '150LB', 'a', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '150LB', 'b', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '150LB', 'c', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '150LB', 'g', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '10K', 'a', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '10K', 'b', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '10K', 'h', '', 'fatiyali', 'D', '');
INSERT INTO `product_model_config`(`create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), 'Hc', 'Hi', '', 'faban', 'D', '');

INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '10', 'p', '', 'fatiyali', 'H', '');
INSERT INTO `product_model_config`( `create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), '16', 'p', '', 'fatiyali', 'H', '');
INSERT INTO `product_model_config`(`create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), 'Hb', 'Hf', '', 'faban', 'H', '');
INSERT INTO `product_model_config`(`create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), 'Ha', 'Hg', '', 'faban', 'H', '');
INSERT INTO `product_model_config`(`create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), 'Hd', 'Hh', '', 'faban', 'H', '');
INSERT INTO `product_model_config`(`create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), 'Hc', 'Hi', '', 'faban', 'H', '');
INSERT INTO `product_model_config`(`create_time`, `index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES (NOW(), 'D', 'QD', '', 'faban', 'H', '');
