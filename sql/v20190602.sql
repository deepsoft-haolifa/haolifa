ALTER TABLE file_record ADD COLUMN file_no varchar(64) NOT NULL DEFAULT '' COMMENT '文件编号';

ALTER TABLE order_product ADD COLUMN accessory VARCHAR(2048) NOT NULL DEFAULT '' COMMENT '订单附件';

ALTER TABLE spray_inspect_history ADD COLUMN create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间';

ALTER TABLE spray_inspect_history ADD COLUMN `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间';

ALTER TABLE spray ADD COLUMN inspect_status TINYINT(4) NOT NULL DEFAULT 0 COMMENT '0 待质检 1 质检中 2 质检完成';

UPDATE spray SET inspect_status = 1 WHERE `status` = 1;
UPDATE spray SET inspect_status = 0 WHERE `status` = 0;


ALTER TABLE entrust
ADD COLUMN  `inspect_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '质检状态：0 待质检 1 质检中 2 质检完成',
ADD COLUMN  `qualified_number` int(11) NOT NULL DEFAULT '0' COMMENT '检验合格数量';

update entrust set qualified_number = number WHERE `status` = 4;


UPDATE entrust set inspect_status = 1 WHERE `status` = 3;
UPDATE entrust set inspect_status = 2 WHERE `status` = 6;
UPDATE entrust set inspect_status = 0 WHERE `status` not in (3,4,5,6);

ALTER TABLE inspect_history
ADD COLUMN `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
ADD COLUMN `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间';

ALTER TABLE inspect
ADD COLUMN  `qualified_number` int(11) NOT NULL DEFAULT '0' COMMENT '检验合格数量';
-- 更新订单表产品总数
update order_product op,(select sum(product_number) as count, order_no from order_product_associate GROUP BY order_no) opa set op.total_count = opa.count where op.order_no = opa.order_no;