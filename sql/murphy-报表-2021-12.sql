alter table expenses add column date_str varchar(32) NOT NULL DEFAULT '' COMMENT '年-月' after data_month;
update expenses set date_str=CONCAT_WS('-',data_year,data_month);
