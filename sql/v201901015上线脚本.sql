-- 添加菜单
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (144, 'm', '报表管理', 'parent-bjgl', 0, 0, '2019-09-16 11:06:46', '2019-09-16 11:06:46');
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (145, 'm', '财务报表', 'bjcwbj', 144, 0, '2019-09-16 11:07:37', '2019-09-16 11:07:37');
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`) VALUES (146, 'm', '已发站内信', 'yfznx', 140, 0, '2019-10-14 22:02:06', '2019-10-14 22:02:06');

INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 144, NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 145,  NOW(), NOW());
INSERT INTO `sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`) VALUES (1, 146,  NOW(), NOW());


-- 站内信添加字段
alter table hl_mail
add column `send_user` varchar(255) DEFAULT '' COMMENT '发送人',
add column `rev_user` varchar(255) DEFAULT '' COMMENT '收件人姓名';
