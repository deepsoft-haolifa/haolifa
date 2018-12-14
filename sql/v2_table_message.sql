DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` TEXT NOT NULL COMMENT '内容',
  `type` TINYINT(4) NOT NULL COMMENT '类型：1-新闻，2-消息',
  `show_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '展示时间',
  `create_user` INT(11) NOT NULL COMMENT '创建者',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='消息/新闻表';