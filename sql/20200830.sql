alter table supplier add column `supplier_product` varchar(128) NOT NULL DEFAULT '' COMMENT '供应商提供的产品' after legal_person_phone;
