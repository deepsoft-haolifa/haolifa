alter table entrust add column `unqualified_number` int(11) NOT NULL DEFAULT '0' COMMENT '检验不合格数量' after qualified_number;
update entrust po,(select purchase_no purchaseNo,sum(unqualified_number) unqualifiedNumber from inspect_history GROUP BY purchase_no ) ih set po.unqualified_number = ih.unqualifiedNumber WHERE ih.purchaseNo = po.purchase_order_no;

INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`) VALUES ('84', now(),  now(), '1', '库管主管审批', '不核料生产流程-库管主管审批');
delete  from flow_step where flow_id=6;
INSERT INTO `haolifa`.`flow_step` ( `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ( '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '50', '61', '16', '0', '51', '0', '', '1');
INSERT INTO `haolifa`.`flow_step` ( `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ( '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '51', '79', '34', '50', '52', '0', '', '2');
INSERT INTO `haolifa`.`flow_step` ( `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ( '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '52', '48', '3', '51', '55', '0', '', '3');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ( '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '84', '74', '29', '52', '84', '0', '', '4');
INSERT INTO `haolifa`.`flow_step` ( `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ( '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '80', '76', '31', '84', '80', '0', '', '5');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '55', '51', '6', '80', '56', '0', '', '6');
INSERT INTO `haolifa`.`flow_step` (`create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ('2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '56', '53', '8', '55', '57', '0', '', '7');
INSERT INTO `haolifa`.`flow_step` ( `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`, `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`, `form_show_step_id`, `step_order`) VALUES ( '2019-12-28 17:46:59', '2019-12-28 17:46:59', '1', '6', '57', '72', '27', '56', '0', '0', '', '8');


-- 添加菜单
INSERT INTO `sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (155, 'm', '进项发票', 'jxfp', 53, 0, NOW(),NOW());
INSERT INTO `sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (156, 'm', '销项发票', 'xxfp', 53, 0, NOW(),NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 155, NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 156,  NOW(), NOW());
