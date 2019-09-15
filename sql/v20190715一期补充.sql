alter table order_product
add column `qualified_number` int(11) not null default 0 comment '成品检验合格数量',
add column `pressure_qualified_number` int(11) not null default 0 comment '压力检测合格数量',
add column `delivered_number` int(11) not null default 0 comment '已发货数量',
add column `received_account` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '已收货款';
-- 更新质检合格数
update order_product op,(select order_no orderNo, sum(qualified_number) qualifiedNumber from pro_inspect_record GROUP BY order_no) pir set op.qualified_number = pir.qualifiedNumber where op.order_no = pir.orderNo;
-- 更新压力质检合格数
update order_product op,(select order_no orderNo, sum(qualified_number) qualifiedNumber from pressure_inspect_record GROUP BY order_no) pir set op.pressure_qualified_number = pir.qualifiedNumber where op.order_no = pir.orderNo;
-- 更新已发货数量
update order_product op,(select contract_order_no orderNo, sum(product_count) deliveryCount from delivery_record GROUP BY contract_order_no) dr set op.delivered_number = dr.deliveryCount where op.order_no = dr.orderNo;
-- 更新已收货款
update order_product op, (select order_no orderNo,sum(amount) receivedAccount from payment_management GROUP BY order_no) pm set op.received_account = pm.receivedAccount where pm.orderNo = op.order_no;

alter table expenses
add column voucher_no VARCHAR(64) not null default '' comment '凭证号',
modify column remark VARCHAR(512) not null DEFAULT '' COMMENT '备注内容';

alter table flow_instance
add column form_type TINYINT(4) default null comment '表单类型：0 默认 1 订单合同,2委托加工 3 采购合同 4 替换料 5 供应商';
-- 流程表单类型修改
update flow_instance set form_type = 1 where flow_id = 1;
update flow_instance set form_type = 2 where flow_id = 5;
update flow_instance set form_type = 3 where flow_id = 2;
update flow_instance set form_type = 4 where flow_id = 4;
update flow_instance set form_type = 5 where flow_id = 3;
update flow_instance fi, flow_history fh set fh.form_type = fi.form_type where fi.id = fh.instance_id;

alter table flow_step
add column `step_order` int(11) NOT NULL DEFAULT '1' COMMENT '流程节点顺序';
update `flow_step` set `step_order`= 1 where id = 7;
update `flow_step` set `step_order`= 2 where id = 8;
update `flow_step` set `step_order`= 3 where id = 9;
update `flow_step` set `step_order`= 4 where id = 10;
update `flow_step` set `step_order`= 5 where id = 11;
update `flow_step` set `step_order`= 6 where id = 12;
update `flow_step` set `step_order`= 7 where id = 13;
update `flow_step` set `step_order`= 8 where id = 14;
update `flow_step` set `step_order`= 1 where id = 30;
update `flow_step` set `step_order`= 2 where id = 31;
update `flow_step` set `step_order`= 3 where id = 32;
update `flow_step` set `step_order`= 4 where id = 33;
update `flow_step` set `step_order`= 5 where id = 34;
update `flow_step` set `step_order`= 6 where id = 35;
update `flow_step` set `step_order`= 1 where id = 36;
update `flow_step` set `step_order`= 2 where id = 37;
update `flow_step` set `step_order`= 3 where id = 43;
update `flow_step` set `step_order`= 1 where id = 44;
update `flow_step` set `step_order`= 2 where id = 45;
update `flow_step` set `step_order`= 3 where id = 46;
update `flow_step` set `step_order`= 4 where id = 47;
update `flow_step` set `step_order`= 5 where id = 48;
update `flow_step` set `step_order`= 6 where id = 49;
update `flow_step` set `step_order`= 1 where id = 50;
update `flow_step` set `step_order`= 2 where id = 51;
update `flow_step` set `step_order`= 3 where id = 52;
update `flow_step` set `step_order`= 4 where id = 53;
update `flow_step` set `step_order`= 5 where id = 54;
update `flow_step` set `step_order`= 6 where id = 55;

alter table purchase_order
add column `total_count` int(11) NOT NULL DEFAULT '0' COMMENT '合同采购总数量',
add column `total_price` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '合同总金额',
add column `paid_account` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '已付货款',
add column `accept_count` int(11) NOT NULL DEFAULT '0' COMMENT '让步接收数量',
add column `back_count` int(11) NOT NULL DEFAULT '0' COMMENT '退货数量',
add column `process_count` int(11) NOT NULL DEFAULT '0' COMMENT '加工数量',
add column `process_charges` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '加工费用',
add column `qualified_number` int(11) not null default 0 comment '检验合格数量';
-- 采购总数量
update purchase_order po, (select purchase_order_no orderNo, sum(`number`) countNum from purchase_order_item GROUP BY purchase_order_no) poi set po.total_count = poi.countNum where po.purchase_order_no = poi.orderNo;
-- 采购总价格
update purchase_order po, (select purchase_order_no orderNo, sum(`number` * unit_price) sumPrice from purchase_order_item GROUP BY purchase_order_no) poi set po.total_price = poi.sumPrice where po.purchase_order_no = poi.orderNo;
-- 检验合格总数量
update purchase_order po,(select purchase_no purchaseNo,sum(qualified_number) qualifiedNumber from inspect_history GROUP BY purchase_no ) ih set po.qualified_number = ih.qualifiedNumber WHERE ih.purchaseNo = po.purchase_order_no;
-- 已付货款
update purchase_order po, (select order_no orderNo,sum(amount) paidAccount from payment_management GROUP BY order_no) pm set po.paid_account = pm.paidAccount where pm.orderNo = po.purchase_order_no;

create table spray_color_relation(
 id int(11) UNSIGNED not null AUTO_INCREMENT comment '主键',
 color VARCHAR(64) not null default '' comment '喷涂颜色',
 relation_no varchar(64) not null default '' comment '颜色编号',
 create_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
 update_time TIMESTAMP not null default CURRENT_TIMESTAMP COMMENT '更新时间',
 PRIMARY key (id) USING BTREE
) engine innodb DEFAULT CHARSET=utf8 COMMENT='喷涂加工颜色编号对照表';

INSERT INTO `spray_color_relation` VALUES (2, '高冷色', '001', '2019-08-20 20:30:38', '2019-08-20 20:30:38');
INSERT INTO `spray_color_relation` VALUES (3, 'RAL9005砂纹', '001', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (4, 'RAL9005高光', '002', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (5, 'RAL9017砂纹', '003', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (6, 'RAL7016砂纹', '004', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (7, 'RAL6016砂纹', '005', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (8, 'RAL5024高光', '006', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (9, 'RAL5015高光', '007', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (10, 'RAL5011高光', '008', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (11, 'RAL5010砂纹', '009', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (12, 'RAL5010高光', '010', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (13, 'RAL5002砂纹', '011', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (14, 'RAL3020高光', '012', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (15, 'RAL1021高光', '013', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (16, 'RAL7011砂纹', '014', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (17, 'RAL7035高光', '015', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (18, 'RAL7016亚光', '016', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (19, 'RAL7024砂纹', '017', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (20, 'RAL5017高光', '018', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (21, 'RAL8003高光', '019', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (22, 'RAL6016亚光', '020', '2019-08-20 20:43:35', '2019-08-20 20:43:35');
INSERT INTO `spray_color_relation` VALUES (23, 'RAL7011高光', '021', '2019-08-20 20:43:35', '2019-08-20 20:43:35');

create table entrust_graph_no_relation(
 id int(11) UNSIGNED not null auto_increment comment '主键',
 material_name VARCHAR(32) not null default '' comment '图号名称',
 original_graph_no VARCHAR(64) not null default '' comment '毛坯图号',
 processed_graph_no VARCHAR(64) not null default '' comment '加工后图号',
 create_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
 update_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
 PRIMARY key (id) using BTREE
) engine innodb default CHARSET=utf8 COMMENT='机加工图号对照表';

INSERT INTO `entrust_graph_no_relation` VALUES (1, '自定义', 'GN200-QN-123', 'GN200-QN-123-001', '2019-08-20 20:31:23', '2019-08-20 20:31:23');
INSERT INTO `entrust_graph_no_relation` VALUES (2, '毛坯', 'D270-0100-01-00Qa-aF07-01-00M', 'D270-0100-01-00Qa-aF07-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (3, '毛坯', 'D270-0100-01-00Qa-aF07-01-01M', 'D270-0100-01-00Qa-aF05-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (4, '毛坯', 'D270-0100-01-00Qa-aF07-05-00M', 'D270-0100-01-00Qa-aF07-05-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (5, '毛坯', 'D270-0100-01-00Qa-aF07-05-01M', 'D270-0100-01-00Qa-aF05-05-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (6, '毛坯', 'D270-0200-01-00Qa-aF10-01-00M', 'D270-0200-01-00Qa-aF10-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (7, '毛坯', 'D270-0200-01-00Qa-aF10-01-01M', 'D270-0200-01-00Qa-aF07-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (8, '毛坯', 'D270-0200-01-00Qa-aF10-05-00M', 'D270-0200-01-00Qa-aF10-05-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (9, '毛坯', 'D270-0200-01-00Qa-aF10-05-01M', 'D270-0200-01-00Qa-aF07-05-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (10, '毛坯', 'D270-0300-01-00Qa-aF12-01-00M', 'D270-0300-01-00Qa-aF10-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (11, '毛坯', 'D270-0300-01-00Qa-aF12-01-01M', 'D270-0300-01-00Qa-aF12-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (12, '毛坯', 'D270-0300-01-00Qa-aF12-05-00M', 'D270-0300-01-00Qa-aF10-05-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (13, '毛坯', 'D270-0300-01-00Qa-aF12-05-01M', 'D270-0300-01-00Qa-aF12-05-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (14, '毛坯', 'D270-0350-01-00Qa-aF12-06-00M', 'D270-0350-01-00Qa-dF10-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (15, '毛坯', 'D270-0350-01-00Qa-aF12-06-01M', 'D270-0350-01-00Qa-dF12-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (16, '毛坯', 'D270-0350-01-00Qa-aF12-06-02M', 'D270-0350-01-00Qa-eF10-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (17, '毛坯', 'D270-0350-01-00Qa-aF12-06-03M', 'D270-0350-01-00Qa-eF12-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (18, '毛坯', 'D270-0400-01-00Qa-aF14-06-00M', 'D270-0400-01-00Qa-eF14-04-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (19, '毛坯', 'D270-0400-01-00Qa-aF14-06-01M', 'D270-0400-01-00Qa-eF14-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (20, '毛坯', 'D270-0400-01-00Qa-aF14-06-02M', 'D270-0400-01-00Qa-eF12-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (21, '毛坯', 'D270-0400-01-00Qa-aF14-06-03M', 'D270-0400-01-00Qa-dF14-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (22, '毛坯', 'D270-0400-01-00Qa-aF14-06-04M', 'D270-0400-01-00Qa-dF12-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (23, '毛坯', 'D270-0450-01-00Qa-aF14-06-00M', 'D270-0450-01-00Qa-eF14-04-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (24, '毛坯', 'D270-0450-01-00Qa-aF14-06-01M', 'D270-0450-01-00Qa-eF14-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (25, '毛坯', 'D270-0450-01-00Qa-aF14-06-02M', 'D270-0450-01-00Qa-dF14-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (26, '毛坯', 'D270-0500-01-00Qa-aF16-06-00M', 'D270-0500-01-00Qa-eF16-04-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (27, '毛坯', 'D270-0500-01-00Qa-aF16-06-01M', 'D270-0500-01-00Qa-eF14-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (28, '毛坯', 'D270-0500-01-00Qa-aF16-06-02M', 'D270-0500-01-00Qa-eF16-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (29, '毛坯', 'D270-0500-01-00Qa-aF16-06-03M', 'D270-0500-01-00Qa-dF14-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (30, '毛坯', 'D270-0500-01-00Qa-aF16-06-04M', 'D270-0500-01-00Qa-dF16-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (31, '毛坯', 'D270-0600-01-00Qa-aF16-06-00M', 'D270-0600-01-00Qa-eF16-04-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (32, '毛坯', 'D270-0600-01-00Qa-aF16-06-01M', 'D270-0600-01-00Qa-eF16-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (33, '毛坯', 'D270-0600-01-00Qa-aF16-06-02M', 'D270-0600-01-00Qa-dF16-06-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (34, '毛坯', 'D220-0400-01-00Qa-aF14-08-00M', 'D220-0400-01-00Qa-eF14-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (35, '毛坯', 'D220-0400-01-00Qa-aF14-08-01M', 'D220-0400-01-00Qa-eF12-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (36, '毛坯', 'D220-0400-01-00Qa-aF14-08-02M', 'D220-0400-01-00Qa-dF14-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (37, '毛坯', 'D220-0400-01-00Qa-aF14-08-03M', 'D220-0400-01-00Qa-dF12-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (38, '毛坯', 'D220-0450-01-00Qa-aF14-08-00M', 'D220-0450-01-00Qa-dF14-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (39, '毛坯', 'D220-0450-01-00Qa-aF14-08-00M', 'D220-0450-01-00Qa-eF14-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (40, '毛坯', 'D220-0500-01-00Qa-aF16-08-00M', 'D220-0500-01-00Qa-eF16-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (41, '毛坯', 'D220-0500-01-00Qa-aF16-08-00M', 'D220-0500-01-00Qa-dF16-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (42, '毛坯', 'D220-0600-01-00Qa-aF16-08-00M', 'D220-0600-01-00Qa-eF16-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (43, '毛坯', 'D220-0600-01-00Qa-aF16-08-00M', 'D220-0600-01-00Qa-dF16-08-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (44, '毛坯', 'D370-0200-01-00Za-aF10-11-00M', 'D370-0200-01-00Za-eF10-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (45, '毛坯', 'D370-0200-01-00Za-aF10-11-00M', 'D370-0200-01-00Za-dF10-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (46, '毛坯', 'D370-0200-01-00Qa-aF10-11-00M', 'D370-0200-01-00Qa-eF10-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (47, '毛坯', 'D370-0200-01-00Qa-aF10-11-00M', 'D370-0200-01-00Qa-dF10-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (48, '毛坯', 'D370-0250-01-00Qa-aF10-11-00M', 'D370-0250-01-00Qa-eF10-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (49, '毛坯', 'D370-0250-01-00Qa-aF10-11-00M', 'D370-0250-01-00Qa-dF10-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (50, '毛坯', 'D370-0300-01-00Qa-aF12-11-00M', 'D370-0300-01-00Qa-eF12-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (51, '毛坯', 'D370-0300-01-00Qa-aF12-11-00M', 'D370-0300-01-00Qa-dF12-11-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (52, '毛坯', 'D271-0250-01-00Qa-pF10-07-00M', 'D271-0250-01-00Qa-eF10-07-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (53, '毛坯', 'D271-0250-01-00Qa-pF10-07-00M', 'D271-0250-01-00Qa-dF10-07-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (54, '毛坯', 'D271-0250-01-00Qa-pF10-01-00M', 'D271-0250-01-00Qa-eF10-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (55, '毛坯', 'D271-0250-01-00Qa-pF10-01-00M', 'D271-0250-01-00Qa-dF10-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (56, '毛坯', 'D271-0300-01-00Qa-pF12-07-00M', 'D271-0300-01-00Qa-eF12-07-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (57, '毛坯', 'D271-0300-01-00Qa-pF12-07-00M', 'D271-0300-01-00Qa-dF12-07-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (58, '毛坯', 'D271-0300-01-00Qa-pF12-01-00M', 'D271-0300-01-00Qa-eF12-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');
INSERT INTO `entrust_graph_no_relation` VALUES (59, '毛坯', 'D271-0300-01-00Qa-pF12-01-00M', 'D271-0300-01-00Qa-dF12-01-00J', '2019-08-20 20:49:29', '2019-08-20 20:49:29');

CREATE table customer_model_relation(
	id int(11) UNSIGNED not null auto_increment comment '主键',
	customer_no VARCHAR(32) not null default '' comment '客户编号',
	customer_model_no varchar(64) not null default '客户产品型号',
	haoli_model_no VARCHAR(64) not null default '好利产品型号',
	create_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '创建时间',
	update_time TIMESTAMP not null default CURRENT_TIMESTAMP comment '更新时间',
	PRIMARY KEY (id) using BTREE
) ENGINE = innodb default charset=utf8 comment='大客户-好利产品型号对照表';
-- 质检不合格原因
alter table inspect_history add column reasons varchar(1024) not null default '' comment '不合格原因列表';
alter table spray_inspect_history add column reasons varchar(1024) not null default '' comment '不合格原因列表';

DROP TABLE IF EXISTS `price_material` ;
CREATE TABLE `price_material` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`material_classify_id` int(11) NOT NULL DEFAULT '0' COMMENT '零件分类Id',
  `material_classify_name` char(36) NOT NULL DEFAULT '' COMMENT '零件分类名称',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '零件名称',
  `graph_no` varchar(64) NOT NULL DEFAULT '' COMMENT '图号',
  `model` varchar(64) NOT NULL DEFAULT '' COMMENT '型号',
  `specifications` varchar(64) NOT NULL DEFAULT '' COMMENT '规格',
  `material` varchar(64) NOT NULL DEFAULT '' COMMENT '材料',
  `unit` varchar(64) NOT NULL DEFAULT '' COMMENT '单位(如：根，个)',
  `actual_weight` varchar(32) NOT NULL DEFAULT '' COMMENT '实际重量',
	`tax_rate` varchar(32) NOT NULL DEFAULT '' COMMENT '税率',
  `ton_price` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '吨价(元)',
  `blank_cost` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '毛坯费不含税（元）',
  `blank_cost_tax` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '毛坯费含税（元）',
  `process_cost` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '加工费（元）',
  `spray_cost` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '喷涂费（元）',
  `price` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '成品价不含税（元）',
  `price_tax` decimal(12,4) NOT NULL DEFAULT 0 COMMENT '成品价含税（元）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` int(11) NOT NULL COMMENT '创建用户',
  `update_user` int(11) NOT NULL DEFAULT '0' COMMENT '更新用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件价格管理表';



