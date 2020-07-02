alter table inspect add column `freight` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '运费' after unqualified_number;
