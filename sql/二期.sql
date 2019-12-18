-- expenses 费用添加年月字段
alter table expenses add COLUMN  `data_year` varchar(32) NOT NULL DEFAULT '' COMMENT '费用产生的年份',
 add COLUMN  `data_month` varchar(32) NOT NULL DEFAULT '' COMMENT '费用产生的月份';
