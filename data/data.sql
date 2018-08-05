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