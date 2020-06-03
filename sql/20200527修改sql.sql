alter table entrust add column `unqualified_number` int(11) NOT NULL DEFAULT '0' COMMENT '检验不合格数量' after qualified_number;

