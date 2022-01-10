alter table expenses
    add column date_str varchar(32) NOT NULL DEFAULT '' COMMENT '年-月' after data_month;
update expenses
set date_str=CONCAT_WS('-', data_year, data_month);

alter table entrust CHANGE material_graph_name material_classify_name varchar (32) NOT NULL DEFAULT '' COMMENT '零件类别';
alter table entrust
    add column material_graph_name varchar(64) NOT NULL DEFAULT '' COMMENT '图号' after material_graph_no,add column `specifications` varchar(255) NOT NULL DEFAULT '' COMMENT '规格' after material_graph_name,add column `model` varchar(255) NOT NULL DEFAULT '' COMMENT '型号' after specifications;



CREATE TABLE `auto_control_material`
(
    `id`             int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `classify_name`  varchar(64)    NOT NULL DEFAULT '' COMMENT '物料分类',
    `material_name`  varchar(64)    NOT NULL DEFAULT '' COMMENT '零件名称',
    `graph_no`       varchar(64)    NOT NULL DEFAULT '' COMMENT '零件图号，自定义',
    `unit`           varchar(64)    NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
    `model`          varchar(64)    NOT NULL DEFAULT '' COMMENT '型号',
    `price`          decimal(12, 4) NOT NULL DEFAULT '0.0000' COMMENT '单价',
    `specifications` varchar(64)    NOT NULL DEFAULT '' COMMENT '规格',
    `quantity`       float          NOT NULL DEFAULT '0' COMMENT '所需数量',
    `create_time`    timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user`    int(11) NOT NULL DEFAULT '0' COMMENT '创建用户',
    `update_user`    int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
    `update_time`    timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='自控物资表';

CREATE TABLE `auto_control_entry_out_record`
(
    `id`                 int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `auto_control_id`    int(11) NOT NULL COMMENT '物料Id',
    `graph_no`           varchar(64) NOT NULL DEFAULT '' COMMENT '零星零件图号，自定义',
    `type`               tinyint(4) NOT NULL DEFAULT '0' COMMENT '1.出库；2.入库',
    `quantity`           float       NOT NULL DEFAULT '0' COMMENT '出入库数量',
    `receive_department` varchar(32) NOT NULL DEFAULT '' COMMENT '领料部门',
    `create_time`        timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_user`        int(11) NOT NULL DEFAULT '0' COMMENT '创建用户',
    `update_user`        int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
    `update_time`        timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7244 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='自控物资出入库记录表';
