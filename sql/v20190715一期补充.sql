alter table order_product
add column qualified_number int(11) not null default 0 comment '成品检验合格数量',
add column pressure_qualified_number int(11) not null default 0 comment '压力检测合格数量',
add column delivered_number int(11) not null default 0 comment '已发货数量';

alter table expenses
add column voucher_no VARCHAR(64) not null default '' comment '凭证号',
modify column remark VARCHAR(512) not null DEFAULT '' COMMENT '备注内容';

alter table flow_instance
add column form_type TINYINT(4) default null comment '表单类型：0 默认 1 订单合同,2委托加工 3 采购合同 4 替换料 5 供应商';

alter table purchase_order
add column `total_count` int(11) NOT NULL DEFAULT '0' COMMENT '合同采购总数量',
add column `accept_count` int(11) NOT NULL DEFAULT '0' COMMENT '让步接收数量',
add column `back_count` int(11) NOT NULL DEFAULT '0' COMMENT '退货数量',
add column `process_count` int(11) NOT NULL DEFAULT '0' COMMENT '加工数量',
add column `process_charges` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '加工费用',
add column `qualified_number` int(11) not null default 0 comment '检验合格数量';


create table spray_color_relation(
 id int(11) UNSIGNED not null AUTO_INCREMENT comment '主键',
 color VARCHAR(64) not null default '' comment '喷涂颜色',
 relation_no varchar(64) not null default '' comment '颜色编号',
 create_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
 update_time TIMESTAMP not null default CURRENT_TIMESTAMP COMMENT '更新时间',
 PRIMARY key (id) USING BTREE
) engine innodb DEFAULT CHARSET=utf8 COMMENT='喷涂加工颜色编号对照表';

create table entrust_graph_no_relation(
 id int(11) UNSIGNED not null auto_increment comment '主键',
 material_name VARCHAR(32) not null default '' comment '图号名称',
 original_graph_no VARCHAR(64) not null default '' comment '毛坯图号',
 processed_graph_no VARCHAR(64) not null default '' comment '加工后图号',
 create_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
 update_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
 PRIMARY key (id) using BTREE
) engine innodb default CHARSET=utf8 COMMENT='机加工图号对照表';

CREATE table customer_model_relation(
	id int(11) UNSIGNED not null auto_increment comment '主键',
	customer_no VARCHAR(32) not null default '' comment '客户编号',
	customer_model_no varchar(64) not null default '客户产品型号',
	haoli_model_no VARCHAR(64) not null default '好利产品型号',
	create_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
	update_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '更新时间',
	PRIMARY KEY (id) using BTREE
) ENGINE = innodb default charset=utf8 comment='大客户-好利产品型号对照表';