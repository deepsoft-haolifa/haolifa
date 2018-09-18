
alter table store_room_rack add column `rack_name` varchar(32) NOT NULL DEFAULT '' COMMENT '库位名称';

alter table store_room_rack change `store_room_id` `store_room_no` varchar(32) NOT NULL DEFAULT '' COMMENT '库房编号';