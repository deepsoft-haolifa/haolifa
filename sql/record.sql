
-- 用户表
-- 1	小李
-- 13	哈哈
-- 14	test
-- 16	好利阀
-- 17	总经理
-- 18	生产副总
-- 19	总工程师
-- 20	材料会计
-- 21	经管经理
-- 22	库房主管
-- 23	采购主管
-- 24	采购员
-- 25	物资经理
-- 26	生产调度员
-- 27	车间主任
-- 28	技术员
-- 29	质检主管
-- 30	质检员
-- 31	商务销售
-- 32	发货员
-- 33	财务主管

-- 角色表
-- 1	管理员
-- 2	总经理
-- 3	生产副总
-- 4	总工程师
-- 6	材料会计
-- 9	经管经理
-- 68	库房主管
-- 70	采购主管
-- 71	采购员
-- 72	物资经理
-- 73	生产调度员
-- 74	车间主任
-- 75	技术员
-- 76	质检主管
-- 77	质检员
-- 78	商务/销售
-- 79	发货员
-- 80	财务主管
-- 82	TEST

INSERT INTO `flow_step` VALUES ('7', NOW(),  NOW(), '1', '1', '50', '40', '84', '0','0','0','');
INSERT INTO `flow_step` VALUES ('8', NOW(),  NOW(), '1', '1', '51', '28', '75', '7','0','0','');
INSERT INTO `flow_step` VALUES ('9', NOW(),  NOW(), '1', '1', '52', '19', '4', '8','0','0','');
INSERT INTO `flow_step` VALUES ('10', NOW(),  NOW(), '1', '1', '53', '22', '68', '9','11','12','');
INSERT INTO `flow_step` VALUES ('11', NOW(),  NOW(), '1', '1', '54', '24', '71', '10','0','0','');
INSERT INTO `flow_step` VALUES ('12', NOW(),  NOW(), '1', '1', '55', '41', '85', '10','0','0','');
INSERT INTO `flow_step` VALUES ('13', NOW(),  NOW(), '1', '1', '56', '26', '73', '12','0','0','');
INSERT INTO `flow_step` VALUES ('14', NOW(),  NOW(), '1', '1', '57', '27', '74', '13','0','0','');


-- 成品质检流程
INSERT INTO `flow_step` VALUES ('18', NOW(),  NOW(), '1', '8', '60', '27', '74', '0');
INSERT INTO `flow_step` VALUES ('19', NOW(),  NOW(), '1', '8', '75', '29', '76', '1');
INSERT INTO `flow_step` VALUES ('20', NOW(),  NOW(), '1', '8', '62', '30', '77', '2');
INSERT INTO `flow_step` VALUES ('21', NOW(),  NOW(), '1', '8', '63', '22', '68', '3');

-- 发货流程
INSERT INTO `flow_step` VALUES ('22', NOW(),  NOW(), '1', '4', '64', '31', '78', '0');
INSERT INTO `flow_step` VALUES ('23', NOW(),  NOW(), '1', '4', '65', '32', '79', '0');
INSERT INTO `flow_step` VALUES ('24', NOW(),  NOW(), '1', '4', '66', '33', '80', '0');
INSERT INTO `flow_step` VALUES ('25', NOW(),  NOW(), '1', '4', '67', '32', '79', '0');
INSERT INTO `flow_step` VALUES ('26', NOW(),  NOW(), '1', '4', '76', '31', '78', '0');


-- 产品核料配置
-- ----------------------------
-- Records of product_model_config
-- ----------------------------
-- 蝶阀核料规则配置
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Q', 'Qa', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Q', 'Qb', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Q', 'Qc', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Z', 'Za', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('C', 'Ca', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('L', 'La', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('P', 'Hc', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('R', 'Hd', '', 'fati', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('RL', 'He', '', 'fati', 'D', '');

INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'a', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'b', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'c', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'd', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'a', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'b', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'c', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'e', '', 'fatiyali', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('25', 'f', '', 'fatiyali', 'D', '');

INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X3', 'Ea', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X3', 'E0', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X6', 'Ed', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X6', 'E0', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X9', 'Eb', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X9', 'E0', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('XF', 'Ec', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('XF', 'E0', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X5', 'Na', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('F4', 'Fa', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X7', 'Xa', '', 'fazuo', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('X8', 'Xb', '', 'fazuo', 'D', '');


INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('P', 'Hc', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('R', 'Hd', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('RL', 'He', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Hb', 'Hf', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Ha', 'Hg', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Hd', 'Hh', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('N', 'QN', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('D', 'QD', '', 'faban', 'D', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('T', 'Ta', '', 'faban', 'D', '');

-- 止回阀规则
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Q', '00Qa', '', 'fati', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('Q', 'QaEa', '', 'fati', 'H', '');

INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'a', '', 'fatiyali', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'b', '', 'fatiyali', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'c', '', 'fatiyali', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('10', 'd', '', 'fatiyali', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'a', '', 'fatiyali', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'b', '', 'fatiyali', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'c', '', 'fatiyali', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('16', 'e', '', 'fatiyali', 'H', '');

INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('P', 'Hc', '', 'faban', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('R', 'Hd', '', 'faban', 'H', '');
INSERT INTO `haolifa`.`product_model_config` (`index_rule`, `material_graph_no_str`, `material_graph_no_indexof`, `material_type`, `product_type`, `remark`) VALUES ('RL', 'He', '', 'faban', 'H', '');


