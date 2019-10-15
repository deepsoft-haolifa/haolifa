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

-- 操作日志表
drop table sys_log;
CREATE TABLE `sys_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户ID',
  `real_name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户真实名称',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '1.登录',
  `remark` varchar(256) NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  INDEX idx_real_name (`real_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志表';

