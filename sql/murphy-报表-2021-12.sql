alter table expenses add column date_str varchar(32) NOT NULL DEFAULT '' COMMENT '年-月' after data_month;
update expenses set date_str=CONCAT_WS('-',data_year,data_month);

alter table entrust CHANGE material_graph_name  material_classify_name varchar(32) NOT NULL DEFAULT '' COMMENT '零件类别';
alter table entrust add column material_graph_name varchar(64) NOT NULL DEFAULT '' COMMENT '图号' after material_graph_no,add column `specifications` varchar(255) NOT NULL DEFAULT '' COMMENT '规格' after material_graph_name,add column `model` varchar(255) NOT NULL DEFAULT '' COMMENT '型号' after specifications;
