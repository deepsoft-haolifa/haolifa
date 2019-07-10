INSERT INTO `sys_user`( `id`,`user_id`, `username`,`password`,`real_name`,`user_no`) VALUES ('1',UUID(), 'admin', '$10$/rw2uHvNK/xda6habqz2g.5eDuZoxVXR/cDV.fBUD2jd5UsN1btSi', '小李', '001');

INSERT INTO `sys_role`(`id`,`dept_id`,`role_name`,`description`) VALUES ('1', '1', 'ROLE_ADMIN', '管理员');
INSERT INTO `sys_role`(`id`,`dept_id`,`role_name`,`description`) VALUES ('2',  '2','ROLE_USER', '仓库管理员');

INSERT INTO `sys_permission`(`id`,`perm_name`,`description`,`url`,`pid`) VALUES ('1', 'home', '主页', '/', 0);
INSERT INTO `sys_permission`(`id`,`perm_name`,`description`,`url`,`pid`) VALUES ('2', 'manager', '管理', '/admin', 0);

INSERT INTO `sys_permission_role` VALUES ('1', '1', '1' ,now(), now());
INSERT INTO `sys_permission_role` VALUES ('2', '1', '2' ,now(), now());
INSERT INTO `sys_permission_role` VALUES ('3', '2', '1' ,now(), now());

INSERT INTO `sys_role_user` VALUES ('1', '1', '1' ,now(), now());
INSERT INTO `sys_role_user` VALUES ('2', '2', '2' ,now(), now());


INSERT INTO `flow` VALUES (1, '2018-09-23 12:44:48', '2018-09-23 12:45:09', 1, 1, '生产流程', '生产流程由销售发起');
INSERT INTO `flow` VALUES (2, '2018-09-23 12:45:15', '2018-11-01 18:20:06', 1, 1, '采购流程', '采购员');
INSERT INTO `flow` VALUES (3, '2018-09-23 12:45:39', '2018-11-01 18:21:06', 1, 1, '零件质检流程', '采购员发起');
INSERT INTO `flow` VALUES (4, '2018-09-23 12:46:02', '2018-09-23 12:46:16', 1, 1, '发货流程', '发货流程由销售发起');
INSERT INTO `flow` VALUES (5, '2018-09-23 12:46:25', '2018-10-31 11:55:13', 1, 1, '发票流程', '发票流程--销售发起');
INSERT INTO `flow` VALUES (6, '2018-09-23 12:46:48', '2018-11-01 18:22:37', 1, 1, '机加工流程', '机加工流程-采购发起');
INSERT INTO `flow` VALUES (7, '2018-11-01 18:20:00', '2018-11-01 18:20:00', 1, 1, '请购流程', '综合计划');
INSERT INTO `flow` VALUES (8, '2018-11-01 18:21:00', '2018-11-01 18:21:00', 1, 1, '成品质检流程', '车间主任');


