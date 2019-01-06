
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
-- 部门数据
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('01', '总经理办公室', '', '0');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('02', '经营管理部', '', '0');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('03', '生产制造部', '', '0');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('04', '技术管理中心', '', '0');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('05', '质量管理中心', '', '0');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('06', '采购管理部', '', '0');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('07', '财务管理部', '', '0');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('0301', '阀门装配车间', '', '3');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('0302', '机加工车间', '', '3');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('0303', '自控设备车间', '', '3');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('0304', '半成品库房', '', '3');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('0305', '配套库房', '', '3');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('0306', '毛坯库房', '', '3');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('0401', '产品研发实验室', '', '4');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('030101', '装配一组', '', '8');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('030102', '装配二组', '', '8');
INSERT INTO `haolifa`.`sys_department` ( `dept_no`, `dept_name`, `description`, `pid`) VALUES ('030103', '装配三组', '', '8');

-- 角色数据
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (0, '00', 'ROLE_ADMIN', '系统管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (0, '01', 'ROLE_ZJL', '总经理');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (2, '0101', 'ROLE_JGFZ', '经管副总');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (2, '0102', 'ROLE_SCFZ', '生产副总');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (2, '0103', 'ROLE_ZG', '总工');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (3, '010101', 'ROLE_JYGLBJL', '经营管理部经理');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (3, '010102', 'ROLE_ZLGLBJL', '质量管理部经理');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (4, '010201', 'ROLE_SCZZBJL', '生产制造部经理');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (4, '010202', 'ROLE_CGGLBJL', '采购管理部经理');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (5, '010301', 'ROLE_JSGLZXJL', '技术管理中心经理');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (5, '010302', 'ROLE_JSGLZXFJL', '技术管理中心副经理');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (0, '010401', 'ROLE_ZJLBGSZR', '总经理办公室主任');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (0, '010501', 'ROLE_CWGLZXFZR', '财务管理中心负责人');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (6, '01010101', 'ROLE_JGGLY', '价格管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (6, '01010102', 'ROLE_ZHJHY', '综合计划员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (6, '01010103', 'ROLE_HTGLY', '合同管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (6, '01010104', 'ROLE_FHY', '发货员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010201', 'ROLE_TXWH', '体系维护');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010202', 'ROLE_CPZLJD', '产品质量监督');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010203', 'ROLE_SHGLY', '售后管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010204', 'ROLE_JHJYY', '进货检验员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010205', 'ROLE_JJJYY', '机加检验员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010206', 'ROLE_YLCSY', '压力测试员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010207', 'ROLE_CPJYY', '成品检验员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (7, '01010208', 'ROLE_ZKSBJYY', '自控设备检验员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (8, '01020101', 'ROLE_SCJJDD', '生产计划调度');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (8, '01020101', 'ROLE_FMZPCJZR', '阀门装配车间主任');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (8, '01020101', 'ROLE_JJGCJZR', '机加工车间主任');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (8, '01020101', 'ROLE_KFZG', '库房主管');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (8, '01020101', 'ROLE_ZKSBCJZR', '自控设备车间主任');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (9, '01020201', 'ROLE_CGZG', '采购主管');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (9, '01020202', 'ROLE_CGY', '采购员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (10, '01030101', 'ROLE_DDSHJSY', '订单审核技术员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (10, '01030102', 'ROLE_XCJSGCS', '现场技术工程师');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (10, '01030103', 'ROLE_SJS', '设计师');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (10, '01030104', 'ROLE_SYSGLY', '实验室管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (10, '01030105', 'ROLE_JSWJGLY', '技术文件管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (12, '01040101', 'ROLE_RLZYYLY', '人力资源管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (12, '01040102', 'ROLE_CZSWGLY', '行政事务管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (12, '01040103', 'ROLE_ZJLMS', '总经理秘书');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (12, '01040104', 'ROLE_AQSCJDGLY', '安全生产监督管理员');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (13, '01050101', 'ROLE_ZGKJ', '主管会计');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (13, '01050102', 'ROLE_XSKJ', '销售会计');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (13, '01050103', 'ROLE_CGKJ', '采购会计');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (13, '01050104', 'ROLE_CLKJ', '材料会计');
INSERT INTO `haolifa`.`sys_role` (`pid`, `role_no`, `role_name`, `description`) VALUES (13, '01050105', 'ROLE_CN', '出纳');




