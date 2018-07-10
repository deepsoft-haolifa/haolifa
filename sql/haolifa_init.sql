
CREATE TABLE `sys_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `login_name` varchar(64) NOT NULL COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '经md5加密的密码',
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别（0：未知；1：男；2：女）',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT 'email',
  `phone` varchar(16) NOT NULL DEFAULT '' COMMENT '电话',
  `ctime` timestamp NOT NULL DEFAULT '2000-00-00 00:00:00' COMMENT '创建时间',
  `utime` timestamp NOT NULL DEFAULT '2000-00-00 00:00:00' COMMENT '修改时间',
  `create_user_id` int(10) unsigned NOT NULL COMMENT '创建人id',
  `modify_user_id` int(10) unsigned NOT NULL COMMENT '修改人id（创建时，默认为create_user_id）',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'user是否被删除，0：未删除；1：删除；删除的user不会出现在后台页面',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';
