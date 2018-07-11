INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin' ,now(), now());
INSERT INTO `sys_user` VALUES ('2', 'abel', 'abel' ,now(), now());

INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN' ,now(), now());
INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER' ,now(), now());

INSERT INTO `sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', 0 ,now(), now());
INSERT INTO `sys_permission` VALUES ('2', 'ROLE_ADMIN', 'ABel', '/admin', 0 ,now(), now());

INSERT INTO `sys_permission_role` VALUES ('1', '1', '1' ,now(), now());
INSERT INTO `sys_permission_role` VALUES ('2', '1', '2' ,now(), now());
INSERT INTO `sys_permission_role` VALUES ('3', '2', '1' ,now(), now());

INSERT INTO `sys_role_user` VALUES ('1', '1', '1' ,now(), now());
INSERT INTO `sys_role_user` VALUES ('2', '2', '2' ,now(), now());