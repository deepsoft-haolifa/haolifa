alter table expenses
    add column date_str varchar(32) NOT NULL DEFAULT '' COMMENT '年-月' after data_month;
update expenses
set date_str=CONCAT_WS('-', data_year, data_month);

alter table entrust CHANGE material_graph_name material_classify_name varchar (32) NOT NULL DEFAULT '' COMMENT '零件类别';
alter table entrust
    add column material_graph_name varchar(64) NOT NULL DEFAULT '' COMMENT '图号' after material_graph_no,add column `specifications` varchar(255) NOT NULL DEFAULT '' COMMENT '规格' after material_graph_name,add column `model` varchar(255) NOT NULL DEFAULT '' COMMENT '型号' after specifications;


INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (193, 'm', '自控物资管理', 'zkwzgl', 50, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 193, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (194, 'm', '新增自控委托加工', 'xzzkwtjg', 95, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 194, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (195, 'm', '自控委托加工列表', 'zkwtjglb', 95, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 195, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (196, 'm', '新增阀座委托加工', 'xzfzwtjg', 95, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 196, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (197, 'm', '阀座委托加工列表', 'fzwtjglb', 95, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 197, NOW(), NOW());

INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (198, 'm', '自控加工列表', 'scgc-zkjglb', 76, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 198, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (199, 'm', '阀座加工列表', 'scgc-fzjglb', 76, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 199, NOW(), NOW());

INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (200, 'm', '新增自控质检', 'xzzkzj', 92, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 200, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (201, 'm', '自控质检列表', 'zkzjlb', 92, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 201, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (202, 'm', '新增阀座质检', 'xzfzzj', 92, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 202, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (203, 'm', '阀座质检列表', 'fzzjlb', 92, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 203, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (205, 'm', '阀座待入库', 'fzdrk', 50, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 205, NOW(), NOW());

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
CREATE TABLE `auto_control_entrust`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT,
    `entrust_no`       varchar(64)  NOT NULL DEFAULT '' COMMENT '委托单号',
    `name`             varchar(64)  NOT NULL DEFAULT '' COMMENT '产品名称',
    `graph_no`         varchar(64)  NOT NULL DEFAULT '' COMMENT '图号',
    `specifications`   varchar(255) NOT NULL DEFAULT '' COMMENT '规格',
    `model`            varchar(255) NOT NULL DEFAULT '' COMMENT '型号',
    `work_type`        varchar(64)  NOT NULL DEFAULT '' COMMENT '委托工种类别',
    `qty`              int(11) NOT NULL DEFAULT '0' COMMENT '数量',
    `qualified_number` int(11) NOT NULL DEFAULT '0' COMMENT '合格数',
    `status`           tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工',
    `inspect_status`   tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 待质检 1 质检中 2 质检完成',
    `create_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='自控委托单';

CREATE TABLE `auto_control_inspect_history`
(
    `id`                  int(11) unsigned NOT NULL AUTO_INCREMENT,
    `auto_control_id`     int(11) NOT NULL COMMENT '单据Id',
    `no`                  varchar(64)   NOT NULL DEFAULT '' COMMENT '单号',
    `material_graph_no`   varchar(64)   NOT NULL DEFAULT '' COMMENT '物料图号',
    `material_graph_name` varchar(255)  NOT NULL DEFAULT '' COMMENT '物料名称',
    `test_number`         int(11) unsigned NOT NULL DEFAULT '0' COMMENT '检测数量',
    `qualified_number`    int(11) unsigned NOT NULL DEFAULT '0' COMMENT '合格数量',
    `unqualified_number`  int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数量',
    `handling_suggestion` varchar(255)  NOT NULL DEFAULT '' COMMENT '处理意见',
    `remark`              varchar(255)  NOT NULL DEFAULT '' COMMENT '备注',
    `status`              tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '状态：1 待入库 2 已入库',
    `reasons`             varchar(1024) NOT NULL DEFAULT '' COMMENT '不合格原因列表',
    `accessory`           varchar(2048) NOT NULL DEFAULT '' COMMENT '质检附件',
    `create_time`         timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='自控检验历史';

CREATE TABLE `valve_seat_entrust`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT,
    `entrust_no`       varchar(64)  NOT NULL DEFAULT '' comment '委托单号',
    `name`             varchar(64)  NOT NULL DEFAULT '' COMMENT '产品名称',
    `graph_no`         varchar(64)  NOT NULL DEFAULT '' COMMENT '图号',
    `specifications`   varchar(255) NOT NULL DEFAULT '' COMMENT '规格',
    `model`            varchar(255) NOT NULL DEFAULT '' COMMENT '型号',
    `qty`              int(11) NOT NULL DEFAULT '0' COMMENT '数量',
    `qualified_number` int(11) NOT NULL DEFAULT '0' COMMENT '合格数',
    `status`           tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0 创建 1 加工中 2 质检完成 3 加工完成 4 暂停加工',
    `inspect_status`   tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 待质检 1 质检中 2 质检完成',
    `create_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='阀座委托单';
CREATE TABLE `valve_seat_inspect_history`
(
    `id`                  int(11) unsigned NOT NULL AUTO_INCREMENT,
    `valve_seat_id`       int(11) NOT NULL COMMENT '单据Id',
    `no`                  varchar(64)   NOT NULL DEFAULT '' COMMENT '单号',
    `material_graph_no`   varchar(64)   NOT NULL DEFAULT '' COMMENT '物料图号',
    `material_graph_name` varchar(255)  NOT NULL DEFAULT '' COMMENT '物料名称',
    `test_number`         int(11) unsigned NOT NULL DEFAULT '0' COMMENT '检测数量',
    `qualified_number`    int(11) unsigned NOT NULL DEFAULT '0' COMMENT '合格数量',
    `unqualified_number`  int(11) unsigned NOT NULL DEFAULT '0' COMMENT '不合格数量',
    `handling_suggestion` varchar(255)  NOT NULL DEFAULT '' COMMENT '处理意见',
    `remark`              varchar(255)  NOT NULL DEFAULT '' COMMENT '备注',
    `status`              tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '状态：1 待入库 2 已入库',
    `reasons`             varchar(1024) NOT NULL DEFAULT '' COMMENT '不合格原因列表',
    `accessory`           varchar(2048) NOT NULL DEFAULT '' COMMENT '质检附件',
    `create_time`         timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='自控检验历史';
CREATE TABLE `customer_info`
(
    `id`              INT ( 11 ) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name`            VARCHAR(128) NOT NULL COMMENT '客户名称',
    `address`         VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '地址',
    `contract_person` VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '联系人',
    `phone`           VARCHAR(255) NOT NULL DEFAULT '' COMMENT '电话',
    `fax`             VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '传真',
    `open_bank`       VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '开户行',
    `bank_account`    VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '帐号',
    `payment_method`  VARCHAR(64)  NOT NULL DEFAULT '' COMMENT '付款方式',
    `remark`          VARCHAR(255) NOT NULL DEFAULT '' COMMENT '备注',
    `create_time`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 ROW_FORMAT = DYNAMIC COMMENT = '客户信息';

INSERT INTO `haolifa`.`sys_permission`(`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                       `update_time`)
VALUES (235, 'm', '客户管理', 'khgl', 87, 0, NOW(), NOW());
INSERT INTO `haolifa`.`sys_permission_role`(`role_id`, `permission_id`, `create_time`, `update_time`)
VALUES (1, 235, NOW(), NOW());

alter table `supplier`
    add column `open_bank` varchar(64) NOT NULL DEFAULT '' COMMENT '开户行' after responsible_person,
 add column `bank_account` varchar(64) NOT NULL DEFAULT '' COMMENT '银行帐号' after open_bank,
 add column `payment_method` varchar(64) NOT NULL DEFAULT '' COMMENT '付款方式' after bank_account;

INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '1', '普通开关型电动执行器装配', 0, 0, '', NOW());
INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '2', '调节型电动执行器装配', 0, 0, '', NOW());
INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '3', '公共件准备工作', 0, 0, '', NOW());
INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '4', '气动蝶阀装配', 0, 0, '', NOW());
INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '5', '外调普通精巧型执行器装配', 0, 0, '', NOW());
INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '6', '外调精巧调节型执行器装配', 0, 0, '', NOW());
INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '7', '外调通用调节型执行器装配', 0, 0, '', NOW());
INSERT INTO `haolifa`.`sys_dict`(`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`) VALUES ('WORK_TYPE', '自控委托工种类别', '8', '外调通用开关型执行器装配', 0, 0, '', NOW());


drop table if exists `business_analysis_record`;
CREATE TABLE `business_analysis_record`
(
    `id`                  int(11) unsigned NOT NULL AUTO_INCREMENT,
    `year`       varchar(32) NOT NULL COMMENT '年份',
    `total_accounts_receivable`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '应收账款总额',
    `due_receivable`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '到期应收',
    `total_accounts_payable`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '应付账款总额',
    `total_output_value`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '产值总额',
    `current_month_output_value`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '当月产值',
    `total_order`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '订货总额',
    `current_month_total_order`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '当月订货额',
    `total_profit`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '利润总额',
    `cost`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '成本费用',
    `total_expenses`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '费用合计',
    `various_expenses`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '各项费用支出总额',
    `asset_liability_ratio`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '资产负债率',
    `sales_profit_margin`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '销售利润率',
    `cost_utilization`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '成本费用利用率',
    `cash_flow`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '现金流量',
    `manufacturing_cost`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '制造成本',
    `manage_cost`  decimal(12,4)  NOT NULL DEFAULT '0.0000' COMMENT '管理成本',
    `create_time`         timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='经营分析数据';
