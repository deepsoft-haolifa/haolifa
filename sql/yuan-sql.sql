-- 现金日记账表
CREATE TABLE `biz_bill`
(
    `id`                 int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `xh`                 varchar(50)    DEFAULT '' COMMENT '序号',
    `d`                  datetime       DEFAULT NULL COMMENT '日期',
    `certificate_number` varchar(30)    DEFAULT '' COMMENT '凭证号',
    `settlement_type`    varchar(50)    DEFAULT '' COMMENT '结算类别',
    `clearing_banks`     varchar(30)    DEFAULT '' COMMENT '结算票号',
    `pre_month_money`    decimal(15, 2) DEFAULT '0.00' COMMENT '上月结转',
    `collection_money`   decimal(15, 2) DEFAULT '0.00' COMMENT '收款',
    `collection_type`    varchar(30)    DEFAULT '' COMMENT '收款类别',
    `payment`            decimal(15, 2) DEFAULT '0.00' COMMENT '付款',
    `payment_type`       varchar(30)    DEFAULT '' COMMENT '付款类别',
    `balance`            decimal(15, 2) DEFAULT '0.00' COMMENT '余额',
    `type`               varchar(3)     DEFAULT '' COMMENT '类型 1=现金日记账 2=银行日记账',
    `dept_id`            varchar(30)    DEFAULT '' COMMENT '部门ID',
    `string1`            varchar(30)    DEFAULT '' COMMENT '备用1',
    `string2`            varchar(30)    DEFAULT '' COMMENT '备用2',
    `string3`            varchar(30)    DEFAULT '' COMMENT '备用3',
    `string4`            varchar(30)    DEFAULT '' COMMENT '备用4',
    `string5`            varchar(30)    DEFAULT '' COMMENT '备用5',
    `string6`            varchar(30)    DEFAULT '' COMMENT '备用6',
    `string7`            varchar(30)    DEFAULT '' COMMENT '备用7',
    `string8`            varchar(30)    DEFAULT '' COMMENT '备用8',
    `string9`            varchar(30)    DEFAULT '' COMMENT '备用9',
    `string10`           varchar(30)    DEFAULT '' COMMENT '备用10',
    `remark`             varchar(30)    DEFAULT '' COMMENT '备注',
    `status`             char(1)        DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `del_flag`           char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `contract_user`      int(11) DEFAULT NULL COMMENT '创建者',
    `create_user`        int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`        datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`        int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`        datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='现金日记账表';


-- 银行日记账表
CREATE TABLE `biz_bank_bill`
(
    `id`                 int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `company`            varchar(255)   DEFAULT '' COMMENT '公司（收款是收款公司，付款是付款公司）',
    `account`            varchar(255)   DEFAULT '' COMMENT '账户（公司下面的某个银行)用来计算余额',
    `serial_no`          varchar(50)    DEFAULT '' COMMENT '序号',
    `operate_date`       datetime       DEFAULT NULL COMMENT '日期',
    `certificate_number` varchar(30)    DEFAULT '' COMMENT '凭证号',
    `pay_way`            varchar(64)    DEFAULT '' COMMENT '收付款方式',
    `pay_account`        varchar(64)    DEFAULT '' COMMENT '收付款账户',
    `pay_company`        varchar(64)    DEFAULT '' COMMENT '付款单位',
    `pay_company_id`     varchar(64)    DEFAULT '' COMMENT '付款单位Id',
    `collect_company`    varchar(64)    DEFAULT '' COMMENT '收款单位',
    `pre_month_money`    decimal(15, 2) DEFAULT '0.00' COMMENT '上月结转',
    `collection_money`   decimal(15, 2) DEFAULT '0.00' COMMENT '收款',
    `collection_type`    varchar(30)    DEFAULT '' COMMENT '收款类别',
    `payment`            decimal(15, 2) DEFAULT '0.00' COMMENT '付款',
    `payment_type`       varchar(30)    DEFAULT '' COMMENT '付款类别',
    `balance`            decimal(15, 2) DEFAULT '0.00' COMMENT '余额（某个公司，某个账户下面）',
    `type`               varchar(3)     DEFAULT '' COMMENT '类型 1.收款；2.付款',
    `dept_id`            int(11) DEFAULT NULL COMMENT '部门ID',
    `remark`             varchar(30)    DEFAULT '' COMMENT '备注摘要',
    `del_flag`           char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `contract_status`    varchar(1)     DEFAULT '0' COMMENT '收款合同分解状态；0未完成；1.完成',
    `contract_user`      int(11) DEFAULT NULL COMMENT '创建者',
    `create_user`        int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`        datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`        int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`        datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='银行日记账表';


-- 其他货币日记账表
CREATE TABLE `biz_other_bill`
(
    `id`                 int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `company`            varchar(255)   DEFAULT '' COMMENT '公司（收款是收款公司，付款是付款公司）',
    `account`            varchar(255)   DEFAULT '' COMMENT '账户（公司下面的某个银行)用来计算余额',
    `serial_no`          varchar(50)    DEFAULT '' COMMENT '序号',
    `operate_date`       datetime       DEFAULT NULL COMMENT '日期',
    `certificate_number` varchar(30)    DEFAULT '' COMMENT '凭证号',
    `pay_way`            varchar(64)    DEFAULT '' COMMENT '收付款方式',
    `pay_account`        varchar(64)    DEFAULT '' COMMENT '收付款账户',
    `pay_company`        varchar(64)    DEFAULT '' COMMENT '付款单位',
    `pay_company_id`     varchar(64)    DEFAULT '' COMMENT '付款单位Id',
    `collect_company`    varchar(64)    DEFAULT '' COMMENT '收款单位',
    `pre_month_money`    decimal(15, 2) DEFAULT '0.00' COMMENT '上月结转',
    `collection_money`   decimal(15, 2) DEFAULT '0.00' COMMENT '收款',
    `collection_type`    varchar(30)    DEFAULT '' COMMENT '收款类别',
    `payment`            decimal(15, 2) DEFAULT '0.00' COMMENT '付款',
    `payment_type`       varchar(30)    DEFAULT '' COMMENT '付款类别',
    `balance`            decimal(15, 2) DEFAULT '0.00' COMMENT '余额（某个公司，某个账户下面）',
    `type`               varchar(3)     DEFAULT '' COMMENT '类型 1.收款；2.付款',
    `dept_id`            int(11) DEFAULT NULL COMMENT '部门ID',
    `remark`             varchar(30)    DEFAULT '' COMMENT '备注摘要',
    `del_flag`           char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `contract_status`    varchar(1)     DEFAULT '0' COMMENT '收款合同分解状态；0未完成；1.完成',
    `contract_user`      int(11) DEFAULT NULL COMMENT '创建者',
    `create_user`        int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`        datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`        int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`        datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='其他货币资金日记账';

-- 付款计划
CREATE TABLE `biz_pay_plan`
(
    `id`                       int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `pay_data_id`              bigint(20) DEFAULT NULL COMMENT '付款申请Id（biz_process_data 里面的data_id）',
    `apply_no`                 varchar(64)    DEFAULT '' COMMENT '申请编号',
    `apply_date`               datetime       DEFAULT NULL COMMENT '申请日期',
    `contract_id`              varchar(32)    DEFAULT NULL COMMENT '采购合同ID',
    `contract_no`              varchar(128)   DEFAULT '' COMMENT '采购合同号',
    `contract_pay_way`         varchar(128)   DEFAULT '' COMMENT '采购合同付款方式',
    `apply_pay_company`        varchar(64)    DEFAULT '' COMMENT '申请付款单位',
    `apply_collection_company` varchar(64)    DEFAULT '' COMMENT '收款单位',
    `apply_amount`             decimal(19, 5) DEFAULT NULL COMMENT '付款金额',
    `pay_company`              varchar(255)   DEFAULT NULL COMMENT '付款单位',
    `pay_account`              varchar(255)   DEFAULT NULL COMMENT '付款账号',
    `pay_way`                  varchar(255)   DEFAULT '' COMMENT '付款方式; 字典：pay_way',
    `payment_type`             char(1)        DEFAULT '' COMMENT '付款类型: 默认是货款',
    `status`                   char(1)        DEFAULT '0' COMMENT '付款状态：0.未付；1.已付； 字典：pay_status',
    `pay_date`                 datetime       DEFAULT NULL COMMENT '付款日期',
    `booking_type`             char(1)        DEFAULT '' COMMENT '付款状态：1.现金日记账；2.银行日记账； 字典：booking_type',
    `data_status`              char(1)        DEFAULT '0' COMMENT '数据状态：1. 老总选择； 2. 财务主管选择；3.出纳付款',
    `remark`                   varchar(30)    DEFAULT '' COMMENT '备注',
    `del_flag`                 char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_user`              int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`              datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`              int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`              datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='付款计划';

-- 费用科目表
CREATE TABLE `biz_subjects`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(50)          DEFAULT NULL COMMENT '名称',
    `type`        varchar(50)          DEFAULT '' COMMENT '科目类别，固定，变动，可节约 数据字典',
    `parent_id`   int(11) NOT NULL DEFAULT '0' COMMENT '父科目',
    `level`       int(11) NOT NULL DEFAULT '0' COMMENT '级别',
    `code`        varchar(32) NOT NULL DEFAULT '' COMMENT '代码',
    `remark`      varchar(30)          DEFAULT '' COMMENT '备注',
    `status`      char(1)              DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `del_flag`    char(1)              DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `percent`     float                DEFAULT '0' COMMENT '分配比例',
    `create_user` int(11) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user` int(11) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='费用科目表';


-- 付款申请（主表）
CREATE TABLE `biz_pay_apply`
(
    `id`                int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `status`            char(1)        DEFAULT '0' COMMENT '申请状态',
    `total_price`       decimal(15, 2) DEFAULT '0.00' COMMENT '申请总金额',
    `apply_pay_company` varchar(64)    DEFAULT '' COMMENT '申请付款单位',
    `apply_time`        datetime       DEFAULT NULL COMMENT '申请时间',
    `remark`            varchar(30)    DEFAULT '' COMMENT '备注',
    `del_flag`          char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_user`       int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`       datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`       int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`       datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='付款申请（主表）,附表biz_pay_apply_detail';


-- 付款申请（附表）
CREATE TABLE `biz_pay_apply_detail`
(
    `id`                       int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `pay_apply_id`             bigint(20) DEFAULT '0' COMMENT '付款申请ID',
    `price`                    decimal(15, 2)        DEFAULT '0.00' COMMENT '合同金额',
    `purchase_order_id`        int(11) DEFAULT NULL COMMENT '订单ID',
    `purchase_order_no`        varchar(32)  NOT NULL DEFAULT '' COMMENT '订单编号',
    `pay_type`                 varchar(255) NOT NULL DEFAULT '' COMMENT '付款方式',
    `apply_pay_company`        varchar(64)           DEFAULT '' COMMENT '申请付款单位',
    `apply_collection_company` varchar(64)           DEFAULT '' COMMENT '收款单位',
    `remark`                   varchar(30)           DEFAULT '' COMMENT '备注',
    `del_flag`                 char(1)               DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_user`              int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`              datetime              DEFAULT NULL COMMENT '创建时间',
    `update_user`              int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`              datetime              DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='付款申请（附表），主表biz_pay_apply';

-- 合同收款表(合同分解)
CREATE TABLE `biz_bill_contract`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `bill_id`      bigint(20) DEFAULT NULL COMMENT '收款id',
    `bill_type`    tinyint(4) DEFAULT NULL COMMENT '记账类型 1 银行日记账 2 其他货币日记账',
    `order_id`     bigint(20) DEFAULT NULL COMMENT '订单ID',
    `order_no`     bigint(20) DEFAULT NULL COMMENT '订单号',
    `amount`       decimal(15, 4) DEFAULT '0.0000' COMMENT '收款金额',
    `book_keeper`  varchar(64)    DEFAULT '' COMMENT '记账员',
    `audit_status` tinyint(4) DEFAULT '0' COMMENT '审批状态（0未审批；1.通过；2.不通过）',
    `remark`       varchar(30)    DEFAULT '' COMMENT '备注',
    `create_user`  int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`  datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`  int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`  datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同收款表(合同分解)';


-- 借款审批
CREATE TABLE `biz_loan_apply`
(
    `id`                    int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `serial_no`             varchar(255)   DEFAULT '' COMMENT '编号',
    `dept_id`               int(11) DEFAULT NULL COMMENT '借款部门id',
    `loan_date`             datetime       DEFAULT NULL COMMENT '借款日期',
    `expect_repayment_date` datetime       DEFAULT NULL COMMENT '预计还款日期',
    `amount`                decimal(15, 4) DEFAULT '0.0000' COMMENT '借款金额',
    `purpose`               varchar(255)   DEFAULT '' COMMENT '用途',
    `loan_user`             int(11) DEFAULT NULL COMMENT '借款人id',
    `amount_type`           varchar(30)    DEFAULT '' COMMENT '资金性质（1現金 2支票）',
    `bill_nature`           varchar(30)    DEFAULT '' COMMENT '记账方式（1現金 2銀行 3 其他貨幣）',
    `account_name`          varchar(255)   DEFAULT '' COMMENT '户名',
    `card_number`           varchar(255)   DEFAULT '' COMMENT '卡号',
    `bank_of_deposit`       varchar(255)   DEFAULT '' COMMENT '开户行',
    `apply_status`          varchar(30)    DEFAULT '' COMMENT '审批节点',
    `pay_company`           varchar(255)   DEFAULT '' COMMENT '付款单位',
    `pay_company_id`        varchar(255)   DEFAULT '' COMMENT '付款单位Id',
    `pay_account`           varchar(255)   DEFAULT '' COMMENT '付款账户',
    `pay_time`              datetime       DEFAULT NULL COMMENT '付款日期',
    `pay_status`            varchar(30)    DEFAULT '' COMMENT '付款状态（1未付款 2付款中 3付款完成）',
    `remark`                varchar(30)    DEFAULT '' COMMENT '备注',
    `del_flag`                 char(1)               DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_user`           int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`           datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`           int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`           datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借款审批';












----











INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00008', '销售费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00003', '采购费用', 0, 0, '', '2021-12-29 22:02:30');


INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00009', '车辆费用', 0, 0, '', '2021-12-29 22:02:30');


INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00005', '质量费用', 0, 0, '', '2021-12-29 22:02:30');


INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00002', '财务费用', 0, 0, '', '2021-12-29 22:02:30');


INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00007', '能耗费用', 0, 0, '', '2021-12-29 22:02:30');


INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00001', '税金', 0, 0, '', '2021-12-29 22:02:30');


INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00010', '租金', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00011', '社保', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00006', '研发费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00004', '生产费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00014', '材料费', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00015', '工资', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` ( `type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ( 'SUBJECTS_TYPE', '科目类型', '00012', '固定资产', 0, 0, '', '2021-12-29 22:02:30');







INSERT INTO `sys_permission`
( `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
('m', '好利财务', 'parent-hlcw', 0, 0, '2021-12-16 22:12:34', '2021-12-16 22:54:59');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '应收款项', 'yskx', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '付款计划', 'fkjh', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '财务挂帐', 'cwgg', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '应付汇总', 'yfhz', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '科目管理', 'kmgl', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '费用预算', 'fyys', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '报销申请', 'bxsq', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '报销支付', 'bxzf', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '借款申请', 'jksq', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '借款付款', 'jkfk', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '现金日记账', 'xjrjz', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '银行日记账', 'yhrjz', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '其他货币资金日记账', 'qtrjz', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission`
(`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES
( 'm', '分解审核', 'fjsh', 172, 0, '2021-11-14 13:37:21', '2021-11-14 13:37:21');
INSERT INTO `sys_permission` (`perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`, `update_time`)
VALUES ( 'm', '新增付款申请', 'xzfksq', 73, 0, '2019-04-16 21:51:02', '2019-04-16 21:51:02');
