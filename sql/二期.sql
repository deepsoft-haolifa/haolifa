-- 添加菜单
INSERT INTO `sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (153, 'm', '订单缺料表', 'ddqlb', 87, 0, NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 153, NOW(), NOW());

-- expenses 费用添加年月字段
alter table expenses add COLUMN  `data_year` varchar(32) NOT NULL DEFAULT '' COMMENT '费用产生的年份',
 add COLUMN  `data_month` varchar(32) NOT NULL DEFAULT '' COMMENT '费用产生的月份';

-- 采购合同添加合同盖章审批流程
INSERT INTO `step`(`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`) VALUES (82, NOW(), NOW(), 1, '总经理秘书合同盖章审批', '采购合同审批');
INSERT INTO `flow_step`(`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES (56, NOW(), NOW(), 1, 2, 82, '85', 40, 39, 0, 0, '77', 1);


-- inspect_item 添加inspect_no 字段
alter table inspect_ietm add column `inspect_no` varchar(32) NOT NULL DEFAULT '' COMMENT '送检单编号';
