
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

-- 生产流程
INSERT INTO `flow_step` VALUES ('7', NOW(),  NOW(), '1', '1', '50', '31', '78', '0');
INSERT INTO `flow_step` VALUES ('8', NOW(),  NOW(), '1', '1', '51', '28', '75', '1');
INSERT INTO `flow_step` VALUES ('9', NOW(),  NOW(), '1', '1', '52', '19', '4', '2');
INSERT INTO `flow_step` VALUES ('10', NOW(),  NOW(), '1', '1', '53', '21', '9', '3');
INSERT INTO `flow_step` VALUES ('11', NOW(),  NOW(), '1', '1', '54', '21', '9', '4');
INSERT INTO `flow_step` VALUES ('12', NOW(),  NOW(), '1', '1', '55', '21', '9', '5');
INSERT INTO `flow_step` VALUES ('13', NOW(),  NOW(), '1', '1', '56', '19', '4', '6');
INSERT INTO `flow_step` VALUES ('14', NOW(),  NOW(), '1', '1', '57', '26', '73', '7');
INSERT INTO `flow_step` VALUES ('15', NOW(),  NOW(), '1', '1', '58', '25', '72', '8');
INSERT INTO `flow_step` VALUES ('16', NOW(),  NOW(), '1', '1', '74', '22', '68', '9');
INSERT INTO `flow_step` VALUES ('17', NOW(),  NOW(), '1', '1', '59', '27', '74', '19');

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
INSERT INTO `product_model_config` VALUES ('1', '2018-12-01 09:35:59', 'Q', 'Qa', '', '1', '');
INSERT INTO `product_model_config` VALUES ('2', '2018-12-01 09:36:05', 'Q', 'Qb', '', '1', '');
INSERT INTO `product_model_config` VALUES ('3', '2018-12-01 09:36:10', 'Q', 'Qc', '', '1', '');
INSERT INTO `product_model_config` VALUES ('4', '2018-12-01 09:36:38', 'Z', 'Za', '', '1', '');
INSERT INTO `product_model_config` VALUES ('5', '2018-12-01 09:36:47', 'Z', 'Zb', '', '1', '');
INSERT INTO `product_model_config` VALUES ('6', '2018-12-01 09:36:55', 'Z', 'Zc', '', '1', '');
INSERT INTO `product_model_config` VALUES ('7', '2018-12-01 09:37:52', 'X', 'E0', '', '2', '');
INSERT INTO `product_model_config` VALUES ('8', '2018-12-01 09:38:01', 'X', 'E1', '', '2', '');
INSERT INTO `product_model_config` VALUES ('9', '2018-12-01 09:38:07', 'X', 'E2', '', '2', '');
INSERT INTO `product_model_config` VALUES ('10', '2018-12-01 09:38:16', 'X', 'E3', '', '2', '');
INSERT INTO `product_model_config` VALUES ('11', '2018-12-01 09:38:32', 'X', 'Na', '', '2', '');
INSERT INTO `product_model_config` VALUES ('12', '2018-12-01 09:38:37', 'X', 'Nb', '', '2', '');
INSERT INTO `product_model_config` VALUES ('13', '2018-12-01 09:38:49', 'F', 'Fa', '', '2', '');
INSERT INTO `product_model_config` VALUES ('14', '2018-12-01 09:39:33', 'P', 'Hc', '', '3', '');
INSERT INTO `product_model_config` VALUES ('15', '2018-12-01 09:39:41', 'R', 'Hd', '', '3', '');
INSERT INTO `product_model_config` VALUES ('16', '2018-12-01 09:39:48', 'L', 'He', '', '3', '');
INSERT INTO `product_model_config` VALUES ('17', '2018-12-01 09:39:58', 'H', 'Hf', '', '3', '');
INSERT INTO `product_model_config` VALUES ('18', '2018-12-01 09:40:05', 'H', 'Hg', '', '3', '');
INSERT INTO `product_model_config` VALUES ('19', '2018-12-01 09:40:08', 'H', 'Hh', '', '3', '');
INSERT INTO `product_model_config` VALUES ('20', '2018-12-01 09:40:32', 'N', 'QN', '', '3', '');
INSERT INTO `product_model_config` VALUES ('21', '2018-12-01 09:40:41', 'D', 'QD', '', '3', '');
INSERT INTO `product_model_config` VALUES ('22', '2018-12-01 09:40:49', 'T', 'Ta', '', '3', '');
INSERT INTO `product_model_config` VALUES ('23', '2018-12-01 09:42:22', '10', 'a', '', '4', '');
INSERT INTO `product_model_config` VALUES ('24', '2018-12-01 09:42:39', '10', 'b', '', '4', '');
INSERT INTO `product_model_config` VALUES ('25', '2018-12-01 09:42:43', '10', 'd', '', '4', '');
INSERT INTO `product_model_config` VALUES ('26', '2018-12-01 09:42:48', '16', 'a', '', '4', '');
INSERT INTO `product_model_config` VALUES ('27', '2018-12-01 09:42:51', '16', 'b', '', '4', '');
INSERT INTO `product_model_config` VALUES ('28', '2018-12-01 09:42:56', '16', 'e', '', '4', '');
