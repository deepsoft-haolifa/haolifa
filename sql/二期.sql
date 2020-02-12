-- 添加菜单
INSERT INTO `sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (153, 'm', '订单缺料表', 'ddqlb', 87, 0, NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 153, NOW(), NOW());

-- expenses 费用添加年月字段
alter table expenses add COLUMN  `data_year` varchar(32) NOT NULL DEFAULT '' COMMENT '费用产生的年份',
 add COLUMN  `data_month` varchar(32) NOT NULL DEFAULT '' COMMENT '费用产生的月份';

-- 采购合同添加采购经理审批，合同盖章审批流程
INSERT INTO `step`(`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`) VALUES (83, NOW(), NOW(), 1, '采购部经理审批', '采购合同审批');
INSERT INTO `step`(`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`) VALUES (82, NOW(), NOW(), 1, '合同盖章', '采购合同审批');

INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2019-12-19 11:37:33', '2019-12-28 17:25:58', '1', '2', '82', '85', '40', '39', '0', '0', '77', '8');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2018-11-07 11:45:35', '2019-12-28 17:27:26', '1', '2', '39', '49', '4', '83', '82', '0', '77', '7');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2019-12-28 17:24:39', '2019-12-28 17:31:28', '1', '2', '83', '110', '9', '38', '39', '0', '77', '6');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2018-11-07 11:45:35', '2019-08-08 09:35:26', '1', '2', '38', '87', '42', '37', '39', '0', '77', '5');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2018-11-07 11:45:35', '2019-08-08 09:35:26', '1', '2', '37', '79', '34', '36', '38', '0', '77', '4');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2018-11-07 11:45:35', '2019-08-08 09:35:26', '1', '2', '36', '51', '6', '35', '37', '0', '77', '3');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2018-11-07 11:45:35', '2019-08-08 09:35:26', '1', '2', '35', '76', '31', '77', '36', '0', '77', '2');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2018-11-07 11:45:35', '2019-01-15 10:52:32', '1', '2', '77', '77', '32', '0', '35', '0', '', '1');

-- 增加不核料的订单流程
INSERT INTO `haolifa`.`flow` (`id`, `create_time`, `update_time`, `create_user`, `update_user`, `name`, `description`, `role_id`) VALUES ('6', '2019-12-28 17:39:55', '2019-12-28 17:39:55', '1', '1', '生产流程（不核料）', '不需要核料订单走的审批流程', '0');
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('72', '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '50', '61', '16', '0', '51', '0', '', '1');
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('73', '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '51', '79', '34', '50', '52', '0', '', '2');
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('74', '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '52', '48', '3', '51', '55', '0', '', '3');
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('75', '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '55', '51', '6', '52', '56', '0', '', '4');
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('76', '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '56', '53', '8', '55', '57', '0', '', '5');
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('77', '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '57', '72', '27', '56', '0', '0', '', '6');


-- 订单表添加不需要核料字段
alter table order_product add column is_check_material tinyint(4) not null default 1 comment '此订单是否需要核料（0 不需要；1 需要）'
-- inspect_item 添加inspect_no 字段
alter table inspect_item add column `inspect_no` varchar(32) NOT NULL DEFAULT '' COMMENT '送检单编号';
update inspect_item ii,(select b.id,b.inspect_no,a.qualified_number,a.unqualified_number from inspect_history a left join inspect b on a.inspect_no=b.inspect_no where a.type=1) hh set ii.inspect_no=hh.inspect_no,ii.unqualified_number=hh.unqualified_number,ii.qualified_number=hh.qualified_number where ii.inspect_id=hh.id;


DROP TABLE IF EXISTS `sporadic_material`;
CREATE TABLE `sporadic_material` (
 `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `classify_name` varchar(64) NOT NULL default '' COMMENT '物料分类',
 `material_name` varchar(64) NOT NULL DEFAULT '' COMMENT '零件名称',
 `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零星零件图号，自定义',
 `unit` varchar(64) NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
 `model` varchar(64) NOT NULL DEFAULT '' COMMENT '型号',
 `price` DECIMAL (12, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
 `specifications` VARCHAR ( 64 ) NOT NULL DEFAULT '' COMMENT '规格',
 `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '库存数量',
 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建用户',
 `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零星零件表';

-- 零星物料的出入库记录
DROP TABLE IF EXISTS `sporadic_entry_out_record`;
CREATE TABLE `sporadic_entry_out_record` (
 `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `sporadic_id` int(11) NOT NULL COMMENT '零星物料Id',
 `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '零星零件图号，自定义',
 `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1.出库；2.入库',
 `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '出入库数量',
 `receive_department` varchar(32) NOT NULL DEFAULT '' COMMENT '领料部门',
 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `create_user` int(11) NOT NULL DEFAULT 0 COMMENT '创建用户',
 `update_user` int(11) NOT NULL DEFAULT 0 COMMENT '更新用户',
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零星零件出入库记录表';

===================
-- invoice 添加开票日期
alter table invoice add column invoice_date datetime default null comment '开票日期' after status;

INSERT INTO `sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (154, 'm', '零星物资管理', 'lxwzgl', 50, 0, NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 154, NOW(), NOW());
