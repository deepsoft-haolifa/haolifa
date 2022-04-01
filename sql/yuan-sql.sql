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
    `apply_status`             char(1)        DEFAULT '0',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='付款计划';



CREATE TABLE `biz_pay_plan_pay_log`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `pay_plan_id`  bigint(20) DEFAULT NULL COMMENT '付款申请Id（biz_process_data 里面的data_id）',
    `contract_id`  varchar(32)    DEFAULT NULL COMMENT '采购合同ID',
    `contract_no`  varchar(128)   DEFAULT '' COMMENT '采购合同号',
    `apply_amount` decimal(19, 5) DEFAULT NULL COMMENT '付款金额',
    `pay_way`      varchar(255)   DEFAULT '' COMMENT '付款方式; 字典：pay_way',
    `pay_date`     datetime       DEFAULT NULL COMMENT '付款日期',
    `booking_type` char(1)        DEFAULT '' COMMENT '付款状态：1.现金日记账；2.银行日记账； 字典：booking_type',
    `apply_status` char(1)        DEFAULT '0' COMMENT '状态',
    `remark`       varchar(30)    DEFAULT '' COMMENT '备注',
    `del_flag`     char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_user`  int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`  datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`  int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`  datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='付款计划支付日志';


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
    `serial_no`             varchar(50)    DEFAULT '' COMMENT '编号',
    `dept_id`               int(11) DEFAULT NULL COMMENT '借款部门',
    `loan_date`             datetime       DEFAULT NULL COMMENT '借款日期',
    `expect_repayment_date` datetime       DEFAULT NULL COMMENT '预计还款日期',
    `amount`                decimal(15, 4) DEFAULT '0.0000' COMMENT '借款金额',
    `purpose`               varchar(30)    DEFAULT '' COMMENT '用途',
    `loan_user`             int(11) DEFAULT NULL COMMENT '借款人',
    `amount_type`           char(1)        DEFAULT '0' COMMENT '资金性质（1現金 2支票）',
    `bill_nature`           char(1)        DEFAULT '0' COMMENT '记账方式（1現金 2銀行 3 其他貨幣）',
    `account_name`          varchar(64)    DEFAULT '' COMMENT '户名',
    `card_number`           varchar(64)    DEFAULT '' COMMENT '卡号',
    `bank_of_deposit`       varchar(64)    DEFAULT '' COMMENT '开户行',
    `apply_status`          char(1)        DEFAULT '0' COMMENT '审批节点',
    `pay_company`           varchar(64)    DEFAULT '' COMMENT '付款单位',
    `pay_company_id`        varchar(64)    DEFAULT '' COMMENT '付款单位Id',
    `pay_account`           varchar(64)    DEFAULT '' COMMENT '付款账户',
    `pay_time`              datetime       DEFAULT NULL COMMENT '付款日期',
    `pay_status`            char(1)        DEFAULT '0' COMMENT '付款状态（1未付款 2付款中 3付款完成）',
    `payment_amount`        decimal(11, 0) DEFAULT NULL COMMENT '还款金额',
    `payment_status`        char(1)        DEFAULT NULL COMMENT '还款状态',
    `remark`                varchar(30)    DEFAULT '' COMMENT '备注摘要',
    `del_flag`              char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_user`           int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`           datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`           int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`           datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='借款申请（出纳付款）';

CREATE TABLE `biz_payment_history`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `loan_id`        int(11) NOT NULL COMMENT '借款ID',
    `loan_serial_no` varchar(50)    DEFAULT '' COMMENT '借款编号',
    `loan_date`      datetime       DEFAULT NULL COMMENT '借款日期',
    `repayment_date` datetime       DEFAULT NULL COMMENT '还款日期',
    `amount`         decimal(15, 4) DEFAULT '0.0000' COMMENT '还款金额',
    `loan_user`      int(11) DEFAULT NULL COMMENT '借款人',
    `repayment_user` int(11) DEFAULT NULL COMMENT '还款人',
    `amount_type`    char(1)        DEFAULT '0' COMMENT '资金性质（1現金 2支票）',
    `bill_nature`    char(1)        DEFAULT '0' COMMENT '记账方式（1現金 2銀行 3 其他貨幣,4 报销冲抵）',
    `remark`         varchar(30)    DEFAULT '' COMMENT '备注摘要',
    `del_flag`       char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_user`    int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`    datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`    int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`    datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='还款记录';

CREATE TABLE `biz_reimburse_apply`
(
    `id`              int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `serial_no`       varchar(50)    DEFAULT '' COMMENT '编号',
    `type`            char(1)        DEFAULT '0' COMMENT '类型 1 费用报销 2 费用报销',
    `reimburse_type`  char(1)        DEFAULT '0' COMMENT '报销方式	1普通报销 2借款冲抵',
    `reimburse_date`  datetime       DEFAULT NULL COMMENT '报销日期',
    `account_name`    varchar(64)    DEFAULT '' COMMENT '收款账户',
    `card_number`     varchar(64)    DEFAULT '' COMMENT '收款账号',
    `bank_of_deposit` varchar(64)    DEFAULT '' COMMENT '开户行',
    `dept_id`         int(11) DEFAULT NULL COMMENT '报销部门',
    `amount`          decimal(15, 4) DEFAULT '0.0000' COMMENT '报销金额',
    `pay_company`     varchar(64)    DEFAULT '' COMMENT '付款单位',
    `pay_company_id`  varchar(64)    DEFAULT '' COMMENT '付款单位Id',
    `pay_account`     varchar(64)    DEFAULT '' COMMENT '付款账户',
    `pay_time`        datetime       DEFAULT NULL COMMENT '付款日期',
    `pay_status`      char(1)        DEFAULT '0' COMMENT '付款状态（1未付款 2付款中 3付款完成）',
    `reimburse_user`  int(11) DEFAULT NULL COMMENT '报销人',
    `offsetAmount`    decimal(15, 0) DEFAULT NULL COMMENT '冲抵金额',
    `loan_id`         int(11) DEFAULT NULL COMMENT '借款申请ID',
    `apply_status`    char(1)        DEFAULT '0' COMMENT '审批节点',
    `remark`          varchar(30)    DEFAULT '' COMMENT '备注摘要',
    `del_flag`        char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_user`     int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`     datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`     int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`     datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='报销申请';

CREATE TABLE `biz_reimburse_travel_detail`
(
    `id`                    int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `reimburse_id`          int(11) NOT NULL COMMENT '报销申请ID',
    `serial_no`             varchar(50)    DEFAULT '' COMMENT '编号',
    `dep_time`              datetime       DEFAULT NULL COMMENT '出发日期',
    `dep_address`           varchar(30)    DEFAULT '' COMMENT '出发地',
    `arr_time`              datetime       DEFAULT NULL COMMENT '到达日期',
    `arr_address`           varchar(30)    DEFAULT '' COMMENT '到达地',
    `vehicle`               int(3) DEFAULT NULL COMMENT '交通工具',
    `vehicle_doc_num`       int(3) DEFAULT NULL COMMENT '交通单据张数',
    `vehicle_amount`        decimal(15, 4) DEFAULT '0.0000' COMMENT '交通金额',
    `travel_days`           int(3) DEFAULT NULL COMMENT '出差天数',
    `travel_subsidy_amount` decimal(15, 4) DEFAULT '0.0000' COMMENT '出差补贴金额',
    `project_type`          int(3) DEFAULT NULL COMMENT '项目',
    `project_doc_num`       int(3) DEFAULT NULL COMMENT '单据张数',
    `project_amount`        decimal(15, 4) DEFAULT '0.0000' COMMENT '金额',
    `type`                  char(1)        DEFAULT '0' COMMENT '类型 1 费用报销 2 费用报销',
    `pay_status`            char(1)        DEFAULT '0' COMMENT '付款状态（1未付款 2付款中 3付款完成）',
    `remark`                varchar(30)    DEFAULT '' COMMENT '备注摘要',
    `del_flag`              char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_user`           int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`           datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`           int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`           datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报销申请-差旅类别详情';

CREATE TABLE `biz_reimburse_cost_detail`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `reimburse_id` int(11) NOT NULL COMMENT '报销申请ID',
    `serial_no`    varchar(50)    DEFAULT '' COMMENT '编号',
    `time`         datetime       DEFAULT NULL COMMENT '日期',
    `doc_num`      int(3) DEFAULT NULL COMMENT '单据张数',
    `amount`       decimal(15, 4) DEFAULT '0.0000' COMMENT '金额',
    `type`         char(1)        DEFAULT '0' COMMENT '类型 1 费用报销 2 费用报销',
    `subject`      int(11) DEFAULT NULL COMMENT '报销类别',
    `pay_status`   char(1)        DEFAULT '0' COMMENT '付款状态（1未付款 2付款中 3付款完成）',
    `remark`       varchar(30)    DEFAULT '' COMMENT '备注摘要',
    `del_flag`     char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
    `create_user`  int(11) DEFAULT NULL COMMENT '创建者',
    `create_time`  datetime       DEFAULT NULL COMMENT '创建时间',
    `update_user`  int(11) DEFAULT NULL COMMENT '更新者',
    `update_time`  datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='报销申请-费用类别详情';

CREATE TABLE `biz_cost_budget_dept`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(50) DEFAULT NULL COMMENT '名称',
    `dept_id`     int(20) DEFAULT NULL COMMENT '组织机构id',
    `dept_pid`    int(20) DEFAULT NULL COMMENT '父组织机构id',
    `cost_ratio`  int(20) DEFAULT NULL COMMENT '费用比例',
    `status`      char(1)     DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `remark`      varchar(30) DEFAULT '' COMMENT '备注',
    `del_flag`    char(1)     DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_user` int(11) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_user` int(11) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门费用预算表';

CREATE TABLE `biz_cost_budget_subjects`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(50) DEFAULT NULL COMMENT '名称',
    `dept_id`     int(20) DEFAULT NULL COMMENT '组织机构id',
    `subjects_id` int(20) DEFAULT NULL COMMENT '科目id',
    `cost_ratio`  int(20) DEFAULT NULL COMMENT '费用比例',
    `status`      char(1)     DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `remark`      varchar(30) DEFAULT '' COMMENT '备注',
    `del_flag`    char(1)     DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_user` int(11) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_user` int(11) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科目费用预算表';


----


INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00008', '销售费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00003', '采购费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00009', '车辆费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00005', '质量费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00002', '财务费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00007', '能耗费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00001', '税金', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00010', '租金', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00011', '社保', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00006', '研发费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00004', '生产费用', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00014', '材料费', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00015', '工资', 0, 0, '', '2021-12-29 22:02:30');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('SUBJECTS_TYPE', '科目类型', '00012', '固定资产', 0, 0, '', '2021-12-29 22:02:30');


INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('PAYMENT_TYPE', '付款类型', '', '费用', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('PAYMENT_TYPE', '付款类型', '', '货款', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('PAYMENT_TYPE', '付款类型', '', '借款', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('PAYMENT_TYPE', '付款类型', '', '其他', 0, 0, '', '2019-05-09 15:13:01');


INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('COLLECTION_TYPE', '收款类型', '', '费用', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('COLLECTION_TYPE', '收款类型', '', '货款', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('COLLECTION_TYPE', '收款类型', '', '借款', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('COLLECTION_TYPE', '收款类型', '', '其他', 0, 0, '', '2019-05-09 15:13:01');


INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('PAY_ACCOUNT', '付款/收款账号', '1', '中国建行银行股份有限公司侯马开发区支行', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('PAY_ACCOUNT', '付款/收款账号', '2', '中国银行侯马支行', 0, 0, '', '2019-05-09 15:13:01');
INSERT INTO `sys_dict` (`type_code`, `type_name`, `code`, `name`, `sort_no`, `status`, `dict_desc`, `create_time`)
VALUES ('PAY_ACCOUNT', '付款/收款账号', '3', '中国邮政储蓄银行股份有限公司侯马市呈王路支行', 0, 0, '', '2019-05-09 15:13:01');


-- 菜单
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (206, 'm', '好利财务', 'parent-hlcw', 0, 0, '2021-12-16 22:12:34', '2021-12-16 22:54:59');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (207, 'm', '应收款项', 'yskx', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:51');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (208, 'm', '付款计划', 'fkjh', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:51');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (209, 'm', '财务挂帐', 'cwgg', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:50');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (210, 'm', '应付汇总', 'yfhz', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:50');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (211, 'm', '科目管理', 'kmgl', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:50');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (212, 'm', '费用预算', 'fyys', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:49');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (213, 'm', '报销申请', 'bxsq', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:49');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (214, 'm', '报销支付', 'bxzf', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:49');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (215, 'm', '借款申请', 'jksq', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:49');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (216, 'm', '借款付款', 'jkfk', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:48');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (217, 'm', '现金日记账', 'xjrjz', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:48');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (218, 'm', '银行日记账', 'yhrjz', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:48');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (219, 'm', '其他货币资金日记账', 'qtrjz', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:48');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (220, 'm', '分解审核', 'fjsh', 206, 0, '2021-11-14 13:37:21', '2022-02-11 09:43:48');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (221, 'm', '新增付款申请', 'xzfksq', 73, 0, '2019-04-16 21:51:02', '2019-04-16 21:51:02');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (222, 'm', '考核指标列表', 'khzb', 159, 0, '2022-02-11 10:39:28', '2022-02-11 10:39:28');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (223, 'm', '生产能力列表', 'scnl', 159, 0, '2022-02-11 10:42:47', '2022-02-11 10:42:47');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (224, 'm', '工资查询列表', 'gzcxlb', 159, 0, '2022-02-11 10:43:10', '2022-02-11 10:43:10');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (225, 'm', '班组列表', 'bzlb', 159, 0, '2022-02-11 10:43:37', '2022-02-11 10:43:37');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (226, 'm', '考核打分列表', 'khdf', 159, 0, '2022-02-11 10:44:11', '2022-02-11 10:44:11');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (227, 'm', '任务分配-零件加工', 'rwljjggl', 159, 0, '2022-02-11 10:44:29', '2022-02-11 10:44:29');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (228, 'm', '任务分配-生产订单', 'rwscddlb', 159, 0, '2022-02-11 10:44:47', '2022-02-11 10:44:47');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (229, 'm', '任务分配-喷涂加工', 'rwptjglb', 159, 0, '2022-02-11 10:45:05', '2022-02-11 10:45:05');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (230, 'm', '岗位管理', 'bmlb', 159, 0, '2022-02-11 17:37:06', '2022-02-11 17:44:46');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (231, 'm', '部门预算', 'bmfyys', 206, 0, '2021-11-14 13:37:21', '2022-02-12 14:13:59');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (232, 'm', '科目预算', 'kmfyys', 206, 0, '2021-11-14 13:37:21', '2022-02-12 14:14:08');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (233, 'm', '回款分解', 'ddhkfj', 87, 0, '2021-11-14 13:37:21', '2022-02-12 18:14:54');
INSERT INTO `haolifa`.`sys_permission` (`id`, `perm_name`, `description`, `url`, `pid`, `is_delete`, `create_time`,
                                        `update_time`)
VALUES (234, 'm', '付款申请列表', 'fksqlb', 73, 0, '2021-11-14 13:37:21', '2022-02-12 18:19:09');

-- 流程节点

INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (85, '2022-02-11 11:35:20', '2022-02-11 11:35:20', 1, '往来会计审批', '借款流程-往来会计审批');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (86, '2022-02-11 11:35:30', '2022-02-11 11:35:40', 1, '总经理审批', '借款流程-总经理审批');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (87, '2022-02-11 12:00:35', '2022-02-11 13:44:55', 1, '采购员申请', '付款流程-采购员申请');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (88, '2022-02-11 12:00:35', '2022-02-11 12:00:35', 1, '采购主管（经理）审批', '付款流程-采购主管（经理）审批');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (89, '2022-02-11 12:00:35', '2022-02-11 12:00:35', 1, '主管领导审批', '付款流程-主管领导审批');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (90, '2022-02-11 12:00:35', '2022-02-11 12:00:35', 1, '往来会计审批', '付款流程-往来会计审批');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (91, '2022-02-11 12:00:35', '2022-02-11 12:00:35', 1, '总经理审批', '付款流程-总经理审批');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (92, '2022-02-11 11:35:20', '2022-02-11 15:37:42', 1, '往来会计审批', '报销流程-往来会计审批');
INSERT INTO `haolifa`.`step` (`id`, `create_time`, `update_time`, `create_user_id`, `name`, `description`)
VALUES (93, '2022-02-11 11:35:30', '2022-02-11 11:35:40', 1, '总经理审批', '报销流程-总经理审批');


-- 流程配置

INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (111, '2019-12-28 17:46:59', '2022-02-11 11:39:01', 1, 12, 86, '47', 2, 85, 0, 0, '', 2);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (110, '2019-12-28 17:46:59', '2022-02-11 15:12:01', 1, 12, 85, '87', 42, 0, 86, 0, '', 1);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (103, '2019-12-28 17:46:59', '2022-02-11 15:40:42', 1, 11, 93, '64', 2, 0, 0, 0, '', 2);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (102, '2019-12-28 17:46:59', '2022-02-11 15:40:31', 1, 11, 92, '', 42, 0, 92, 0, '', 1);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (98, '2019-12-28 17:46:59', '2022-02-11 14:37:55', 1, 10, 91, '47', 2, 90, 0, 0, '87', 5);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (97, '2019-12-28 17:46:59', '2022-02-11 14:37:55', 1, 10, 90, '87', 42, 89, 91, 0, '87', 4);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (96, '2019-12-28 17:46:59', '2022-02-11 14:37:55', 1, 10, 89, '48', 3, 88, 90, 0, '87', 3);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (95, '2019-12-28 17:46:59', '2022-02-11 14:37:55', 1, 10, 88, '113', 9, 87, 89, 0, '87', 2);
INSERT INTO `haolifa`.`flow_step` (`id`, `create_time`, `update_time`, `create_user_id`, `flow_id`, `step_id`,
                                   `user_id`, `role_id`, `prev_step_id`, `condition_true`, `condition_false`,
                                   `form_show_step_id`, `step_order`)
VALUES (94, '2019-12-28 17:46:59', '2022-02-11 14:37:55', 1, 10, 87, '77', 32, 0, 88, 0, '87', 1);


-- 初始化科目数据

INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (17, '差旅费', '00001', 0, 0, '0000101', '职工出差发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (18, '招待费', '00001', 0, 0, '0000102', '对外招待客户发生的餐费及职工内部聚餐发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (19, '通讯费', '00001', 0, 0, '0000103', '办公室有线电话使用费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (20, '交通费', '00001', 0, 0, '0000104', '管理部门市内办公发生的交通费，培训期间发生的市内交通费等', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (21, '知识产权费', '00001', 0, 0, '0000105', '申请的知识产权费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (22, '劳保费', '00001', 0, 0, '0000106', '公司为职工购买劳保用品所发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (23, '办公费', '00001', 0, 0, '0000107', '书报费，印刷费，日常办公用品费，消耗用品费，年检，审计费，其他。', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (24, '修理费', '00001', 0, 0, '0000108', '包含电脑，空调，打印机，复印机等的修理安装费，硬件升级费，办公楼装修费，其他管理部办公用品移动和安装费等。', '0', '0', 0, NULL,
        NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (25, '职工福利费', '00001', 0, 0, '0000109', '包括医疗用品，公司组织职工体检费，工伤医疗费，工作人员租房费，餐厅用厨具，夜班补助，职工慰问金。', '0', '0', 0, NULL,
        NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (26, '折旧费', '00001', 0, 0, '0000110', '管理部使用的固定资产每月所计提的折旧。', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (27, '咨询服务费', '00001', 0, 0, '0000111', '包含公司聘请律师顾问费、会计税务咨询费及其他信息咨询费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (28, '物料消耗', '00001', 0, 0, '0000112', '购买硬盘、光盘、软盘等电脑用品，以及插座等维修零件', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (29, '礼品费', '00001', 0, 0, '0000113', '节日福利', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (30, '售后运费', '00001', 0, 0, '0000114', '通过运输公司发生的售后运费，售后问题不归属于生产部分的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (31, '售后费用', '00001', 0, 0, '0000115', '为履行合同约定的明确的售后条款内容应发生的一切费用，售后问题不归属于生产部分的费用', '0', '0', 0, NULL, NULL,
        NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (32, '会议费', '00001', 0, 0, '0000116', '公司召开董事会发生的会议费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (33, '审计费', '00001', 0, 0, '0000117', '审计所出具审计报告费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (34, '培训费', '00001', 0, 0, '0000118', '讲师费/资料费/餐费/其他', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (35, '无形资产摊销', '00001', 0, 0, '0000119', '指月底对公司所拥有的无形资产分期摊销，结转费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (36, '其它', '00001', 0, 0, '0000120', '与管理有关未列明的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (37, '办公费', '00002', 0, 0, '0000201', '书报费，印刷费，日常办公用品费，消耗用品费，年检，审计费，其他。', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (38, '差旅费', '00002', 0, 0, '0000202', '职工出差发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (39, '软件费', '00002', 0, 0, '0000203', '购买软件的服务费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (40, '交通费', '00002', 0, 0, '0000204', '管理部门市内办公发生的交通费，培训期间发生的市内交通费等', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (41, '贷款', '00002', 0, 0, '0000205', '银行贷款及其他筹资方式贷款', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (42, '手续费', '00002', 0, 0, '0000206', '在银行结算过程中支付的手续费，办理电汇所支付的手续费、邮电费，购买空白支票、电汇单、汇票等所支付的工本费、银行转账手续费、电子回单柜年费等。',
        '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (43, '贷款利息', '00002', 0, 0, '0000207', '银行贷款利息支出及其他筹资方式下支付利息支出', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (44, '差旅费', '00003', 0, 0, '0000301', '职工出差发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (45, '招待费', '00003', 0, 0, '0000302', '对外招待供应商发生的餐费及职工内部聚餐发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (46, '办公费', '00003', 0, 0, '0000303', '书报费，印刷费，日常办公用品费，消耗用品费，其他。', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (47, '运输费', '00003', 0, 0, '0000304', '采购材料通过运输公司发生的运费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (48, '交通费', '00003', 0, 0, '0000305', '管理部门市内办公发生的交通费，培训期间发生的市内交通费等', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (49, '其它', '00003', 0, 0, '0000306', '与采购有关未列明的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (50, '折旧费', '00004', 0, 0, '0000401', '生产车间使用的固定资产每月所计提的折旧。', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (51, '刀具', '00004', 0, 0, '0000402', '生产车间购买的低值易耗品', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (52, '夹具', '00004', 0, 0, '0000403', '生产车间购买的低值易耗品', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (53, '量具', '00004', 0, 0, '0000404', '生产车间购买的低值易耗品', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (54, '工具', '00004', 0, 0, '0000405', '生产车间购买的低值易耗品', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (55, '售后费用', '00004', 0, 0, '0000406', '为履行合同约定的明确的售后条款内容应发生的一切费用，售后问题不归属于生产部分的费用', '0', '0', 0, NULL, NULL,
        NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (56, '维修费', '00004', 0, 0, '0000409', '生产线的日常修理费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (57, '招待费', '00004', 0, 0, '0000407', '对外招待客户发生的餐费及职工内部聚餐发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (58, '劳保费', '00004', 0, 0, '0000408', '公司为职工购买劳保用品所发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (59, '委托加工费', '00004', 0, 0, '0000410', '委托外单位加工的各种物资的实际成本', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (60, '差旅费', '00005', 0, 0, '0000501', '职工出差发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (61, '认证费', '00005', 0, 0, '0000502', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (62, '培训费', '00005', 0, 0, '0000503', '讲师费/资料费/餐费/其他', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (63, '检测费', '00005', 0, 0, '0000504', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (64, '运费', '00005', 0, 0, '0000505', '通过运输公司发生的运费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (65, '差旅费', '00006', 0, 0, '0000601', '研究开发活动直接相关的其他费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (66, '培训费', '00006', 0, 0, '0000602', '研究开发活动直接相关的其他费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (67, '检测费', '00006', 0, 0, '0000603', '用于研究开发活动的仪器、设备的运行维护、调整、检验、检测、维修等费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (68, '材料费', '00006', 0, 0, '0000604', '直接消耗的材料、燃料和动力费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (69, '委托加工费', '00006', 0, 0, '0000605', '企业委托境内其他机构或个人进行研究开发活动所发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (70, '设备费', '00006', 0, 0, '0000606', '用于研究开发活动投入的设备', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (71, '工装费', '00006', 0, 0, '0000607', '用于中间试验和产品试制的模具、工艺装备开发及制造费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (72, '试验费', '00006', 0, 0, '0000608', '用于研究开发活动的仪器、设备的运行维护、调整、检验、检测、维修等费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (73, '模具', '00006', 0, 0, '0000609', '用于中间试验和产品试制的模具', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (74, '生产电费', '00007', 0, 0, '0000701', '生产车间消耗电的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (75, '生产水费', '00007', 0, 0, '0000702', '生产车间消耗水的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (76, '办公电费', '00007', 0, 0, '0000703', '管理部门消耗电的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (77, '办公水费', '00007', 0, 0, '0000704', '管理部门消耗水的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (78, '差旅费', '00008', 0, 0, '0000801', '职工因工作外出期间发生的住宿费，交通费等，包括：交通车费、交通机票、住宿费、伙食补贴、其他相关的费用', '0', '0', 0, NULL,
        NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (79, '招待费', '00008', 0, 0, '0000802', '销售部门发生的与销售活动有关的业务招待费支出，具体包括：餐饮费、礼品费、其他相关的费用', '0', '0', 0, NULL, NULL,
        NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (80, '运费', '00008', 0, 0, '0000803', '为销售货物而发生的产品运输费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (81, '包装费', '00008', 0, 0, '0000804', '为销售产品而直接发生的包装货物的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (82, '展会费', '00008', 0, 0, '0000805', '为开展促销或宣传产品等举办展览、展销会所支出的各项具有公共性质的费用，包括：资料费、礼品费、及其他相关的开支。', '0', '0', 0,
        NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (83, '油费', '00009', 0, 0, '0000901', '车辆使用汽油、机油的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (84, '年检费', '00009', 0, 0, '0000902', '车辆发生的年检费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (85, '保险费', '00009', 0, 0, '0000903', '包含公司投的车辆保险费等', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (86, '维修费', '00009', 0, 0, '0000904', '车辆的修理维护费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (87, '过路费', '00009', 0, 0, '0000905', '使用的车辆按国家规定所交的公路过路费', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (88, '租赁费', '00009', 0, 0, '0000906', '租用车辆发生的费用', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (89, '租金', '00010', 0, 0, '', '包括厂房租赁费，会议室租赁费，职工宿舍房租，其他的管理部门使用场地时发生的场地费用。', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (90, '养老保险', '00011', 0, 0, '0001101', '公司和个人按一定工资比例交纳的保险', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (91, '工伤保险', '00011', 0, 0, '0001102', '公司按一定工资比例交纳的保险', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (92, '医疗保险', '00011', 0, 0, '0001103', '公司和个人按一定工资比例交纳的保险', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (93, '失业保险', '00011', 0, 0, '0001104', '公司按一定工资比例交纳的保险', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (94, '房屋', '00012', 0, 0, '0001201', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (95, '建筑物', '00012', 0, 0, '0001202', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (96, '机器', '00012', 0, 0, '0001203', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (97, '设备', '00012', 0, 0, '0001204', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (98, '模具', '00012', 0, 0, '0001205', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (99, '运输工具', '00012', 0, 0, '0001206', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (100, '器具', '00012', 0, 0, '0001207', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (101, '工具', '00012', 0, 0, '0001208', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (102, '家具', '00012', 0, 0, '0001209', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (103, '电子设备', '00012', 0, 0, '0001210', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (104, '增值税', '00013', 0, 0, '0001301', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (105, '城市维护建设税', '00013', 0, 0, '0001302', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (106, '教育费附加', '00013', 0, 0, '0001303', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (107, '地方教育费附加', '00013', 0, 0, '0001304', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (108, '印花税', '00013', 0, 0, '0001305', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (109, '土地使用税', '00013', 0, 0, '0001306', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (110, '企业所得税', '00013', 0, 0, '0001307', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (111, '残疾人就业保障金', '00013', 0, 0, '0001308', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (112, '房产税', '00013', 0, 0, '0001309', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (113, '工会经费', '00013', 0, 0, '0001310', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (114, '原材料', '00014', 0, 0, '0001401', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (115, '辅助材料', '00014', 0, 0, '0001402', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (116, '整机采购', '00014', 0, 0, '0001403', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (117, '行政管理中心', '00015', 0, 0, '0001501', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (118, '经营管理中心', '00015', 0, 0, '0001502', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (119, '技术质量管理中心', '00015', 0, 0, '0001503', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (120, '财务管理中心', '00015', 0, 0, '0001504', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (121, '产品研发中心', '00015', 0, 0, '0001505', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (122, '采购部', '00015', 0, 0, '0001506', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (123, '库房', '00015', 0, 0, '0001507', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (124, '机加事业部', '00015', 0, 0, '0001508', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (125, '控制阀事业部', '00015', 0, 0, '0001509', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (126, '覆层事业部', '00015', 0, 0, '0001510', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (127, '装配事业部', '00015', 0, 0, '0001511', '', '0', '0', 0, NULL, NULL, NULL, NULL);
INSERT INTO `haolifa`.`biz_subjects` (`id`, `name`, `type`, `parent_id`, `level`, `code`, `remark`, `status`,
                                      `del_flag`, `percent`, `create_user`, `create_time`, `update_user`, `update_time`)
VALUES (128, '橡胶事业部', '00015', 0, 0, '0001512', '', '0', '0', 0, NULL, NULL, NULL, NULL);



alter table purchase_order
    add pay_status tinyint(4)  DEFAULT NULL COMMENT '支付状态 ' after status


