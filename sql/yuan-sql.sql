CREATE TABLE `biz_assets`
(
    `id`                       bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`                     varchar(50)    DEFAULT '' COMMENT '资产名称',
    `bh`                       varchar(50)    DEFAULT '' COMMENT '资产编号',
    `specifications`           varchar(50)    DEFAULT '' COMMENT '规格型号',
    `type`                     varchar(50)    DEFAULT '' COMMENT '资产类别 数据字典ASSETS_TYPE',
    `manufacturer`             varchar(50)    DEFAULT '' COMMENT '生产厂家',
    `add_type`                 varchar(50)    DEFAULT '' COMMENT '增加方式 数据字典ASSETS_ADD_TYPE',
    `dept_id`                  int(11) DEFAULT NULL COMMENT '使用部门',
    `user_name`                varchar(50)    DEFAULT '' COMMENT '领用人',
    `location`                 varchar(50)    DEFAULT '' COMMENT '存放地点',
    `num`                      int(11) DEFAULT NULL COMMENT '数量',
    `unit`                     varchar(50)    DEFAULT NULL COMMENT '单位 个 条 把 台',
    `price`                    decimal(19, 2) DEFAULT '0.00' COMMENT '采购单价',
    `total_price`              decimal(19, 2) DEFAULT '0.00' COMMENT '采购总金额',
    `purchasing_time`          datetime       DEFAULT NULL COMMENT '采购时间',
    `start_time`               datetime       DEFAULT NULL COMMENT '开始使用日期',
    `output_rate`              decimal(19, 2) DEFAULT '0.00' COMMENT '净残值率',
    `salvage_value`            decimal(19, 2) DEFAULT '0.00' COMMENT '净残值（=采购金额*净残值率）',
    `use_year`                 int(11) DEFAULT '0' COMMENT '使用年限/年',
    `depreciation_method`      varchar(50)    DEFAULT '' COMMENT '折旧方法 数据字典DEPRECIATION_METHOD',
    `month_depreciation`       decimal(19, 2) DEFAULT '0.00' COMMENT '月折旧额',
    `accrued_month`            int(11) DEFAULT NULL COMMENT '已计提月份',
    `accumulated_depreciation` decimal(19, 2) DEFAULT '0.00' COMMENT '累计折旧',
    `net_worth`                decimal(19, 2) DEFAULT '0.00' COMMENT '净值',
    `status`                   char(1)        DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `remark`                   varchar(30)    DEFAULT '' COMMENT '备注',
    `del_flag`                 char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`                varchar(64)    DEFAULT '' COMMENT '创建者',
    `create_time`              datetime       DEFAULT NULL COMMENT '创建时间',
    `update_by`                varchar(64)    DEFAULT '' COMMENT '更新者',
    `update_time`              datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='固定资产表';



-- 2、系统管理模块下增加一个【收款单位】菜单，
-- 菜单列表：字段包括：
-- 单位ID（自动生成）、
-- 单位名称、
-- 所属省、
-- 所属市、

-- 单位账号、
-- 开户行
--
-- province
--
-- city
--
-- area
-- 注：设置增、删、改、查功能，关联报销、借款表单。
CREATE TABLE `biz_company`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `code`            varchar(50) DEFAULT '' COMMENT '单位code',
    `name`            varchar(50) DEFAULT '' COMMENT '单位名称',
    `province_name`   varchar(50) DEFAULT '' COMMENT '所属省',
    `city_name`       varchar(50) DEFAULT '' COMMENT '所属市',
    `account_name`    varchar(64) DEFAULT '' COMMENT '户名',
    `card_number`     varchar(64) DEFAULT '' COMMENT '单位账号',
    `bank_of_deposit` varchar(64) DEFAULT '' COMMENT '开户行',
    `status`          char(1)     DEFAULT '0' COMMENT '状态（1正常 2停用）',
    `remark`          varchar(30) DEFAULT '' COMMENT '备注',
    `del_flag`        char(1)     DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`       varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time`     datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64) DEFAULT '' COMMENT '更新者',
    `update_time`     datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公司单位';


-- 项目编号、项目名称、所属部门、预算年度、预算月份、预算经费总额度、剩余额度（总额度核减每次提交报销或借款的数额）、项目说明
CREATE TABLE `biz_project_budget`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `code`          varchar(50)    DEFAULT '' COMMENT '项目编号',
    `name`          varchar(50)    DEFAULT '' COMMENT '项目名称',
    `dept_id`       int(11) DEFAULT NULL COMMENT '所属部门',
    `year`          varchar(50)    DEFAULT '' COMMENT '预算年度',
    `month`         varchar(50)    DEFAULT '' COMMENT '预算月份',
    `total_quota`   decimal(19, 2) DEFAULT '0.00' COMMENT '预算经费总额度',
    `balance_quota` decimal(19, 2) DEFAULT '0.00' COMMENT '剩余额度（总额度核减每次提交报销或借款的数额）',
    `status`        char(1)        DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `remark`        varchar(30)    DEFAULT '' COMMENT '备注',
    `del_flag`      char(1)        DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`     varchar(64)    DEFAULT '' COMMENT '创建者',
    `create_time`   datetime       DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(64)    DEFAULT '' COMMENT '更新者',
    `update_time`   datetime       DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='项目预算';

alter table biz_reimburse_apply
    add project_code varchar(50) DEFAULT NULL COMMENT '项目预算code' after apply_status;

{
	"id":"文件公共信息主键id",
	"data_type":"数据类型DIR:目录;IMAGE:图片;VIDEO:视频;AUDIO:音频;DOC:文档;OTHER:其他",
	"relative_path":"文件相对路径",
	"url":"文件访问链接 需要通过nginx配置路由，才能访问",
	"file_md5":"文件md5值",
	"submitted_file_name":"原始文件名",
	"filename":"唯一文件名",
	"ext":"文件后缀",
	"size":"文件大小",
	"transcoding_path":"文件转码地址",
	"transcoding_size":"转码文件大小字节",
	"transcoding_status":"文件转码状态：0 尚未转码 1 转码中，2 转码成功 3 转码失败",
	"duration":"时长（秒），视频文件才有",
	"thumbnail_path":"缩略图文件地址",
	"thumbnail_size":"缩略图文件大小字节",
	"thumbnail_status":"缩略图转码状态：0 尚未转码 1 转码中，2 转码成功 3 转码失败",
	"can_preview":"是否可以预览",
	"storage_source":"文件上传服务器，0为紫光云，1为阿里云"
}{
	"id":文件唯一主键id,
	"biz_id":"业务主键id",
	"biz_type":"文件业务类型,哪个业务的文件",
	"submitted_file_name":"文件原始名",
	"file_common_id":"对应的文件公共信息id",
	"uuid":"文件唯一标识,可以根据uuid和匿名进行文件查询、避免通过id查询"
}
CREATE TABLE `biz_file`
(
    `id`                  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `biz_id`              int(11) DEFAULT NULL COMMENT '业务主键id',
    `biz_type`            varchar(255) DEFAULT '' COMMENT '文件业务类型,哪个业务的文件',
    `data_type`           varchar(50)  DEFAULT '' COMMENT '数据类型DIR:目录;IMAGE:图片;VIDEO:视频;AUDIO:音频;DOC:文档;OTHER:其他',
    `relative_path`       varchar(255) DEFAULT '' COMMENT '文件相对路径',
    `url`                 varchar(255) DEFAULT '' COMMENT '文件访问链接 需要通过nginx配置路由，才能访问',
    `file_md5`            varchar(200) DEFAULT '' COMMENT '文件md5值',
    `submitted_file_name` varchar(200) DEFAULT '' COMMENT '文件原始名',
    `filename`            varchar(200) DEFAULT '' COMMENT '唯一文件名',
    `ext`                 varchar(50)  DEFAULT '' COMMENT '文件后缀',
    `size`                bigint(20) DEFAULT '0' COMMENT '文件大小',

    `status`              char(1)      DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `remark`              varchar(30)  DEFAULT '' COMMENT '备注',
    `del_flag`            char(1)      DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`           varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`         datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`           varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`         datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='项目预算';




alter table biz_loan_apply  add project_code varchar(50) DEFAULT NULL COMMENT '项目预算code' after payment_status;

alter table biz_loan_apply  add pay_type char(1) DEFAULT '0' COMMENT '类型 1 对公 2 对私' after project_code;

alter table biz_loan_apply  add travel_flag char(1) DEFAULT '0' COMMENT '是否差旅借款 1 是 2 否' after pay_type;

alter table biz_loan_apply  add  travel_arr_address varchar(30) DEFAULT '' COMMENT '到达地' after travel_flag;

alter table biz_loan_apply  add  travel_days int(3) DEFAULT NULL COMMENT '出差天数' after travel_arr_address;

alter table biz_loan_apply  add  travel_peo_num int(3) DEFAULT NULL COMMENT '出差天数' after travel_days;

