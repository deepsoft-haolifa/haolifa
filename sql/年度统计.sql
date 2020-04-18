set @start1Month="2018-12-26";
set @month1="2019-01-26";
set @month2="2019-02-26";
set @month3="2019-03-26";
set @month4="2019-04-26";
set @month5="2019-05-26";
set @month6='2019-06-26';
set @month7='2019-07-26';
set @month8='2019-08-26';
set @month9='2019-09-26';
set @month10='2019-10-26';
set @month11='2019-11-26';
set @month12='2019-12-26';
set @yearStart='2019-01-01';
set @yearEnd='2020-01-01';

set @datayear=2019

-- 已开票
begin
SELECT '1月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @start1Month and create_time< @month1 and status=2 and type=1 GROUP BY invoice_company;
SELECT '2月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month1 and create_time< @month2 and status=2 and type=1 GROUP BY invoice_company;
SELECT '3月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month2 and create_time< @month3 and status=2 and type=1 GROUP BY invoice_company;
SELECT '4月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month3 and create_time< @month4 and status=2 and type=1 GROUP BY invoice_company;
SELECT '5月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month4 and create_time< @month5 and status=2 and type=1 GROUP BY invoice_company;
SELECT '6月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month5 and create_time< @month6 and status=2 and type=1 GROUP BY invoice_company;
SELECT '7月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month6 and create_time< @month7 and status=2 and type=1 GROUP BY invoice_company;
SELECT '8月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month7 and create_time< @month8 and status=2 and type=1 GROUP BY invoice_company;
SELECT '9月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month8 and create_time< @month9 and status=2 and type=1 GROUP BY invoice_company;
SELECT '10月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month9 and create_time< @month10 and status=2 and type=1 GROUP BY invoice_company;
SELECT '11月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month10 and create_time< @month11 and status=2 and type=1 GROUP BY invoice_company;
SELECT '12月',invoice_company,sum(total_amount) FROM `invoice` where create_time>= @month11 and create_time< @month12 and status=2 and type=1 GROUP BY invoice_company;





-- 原材料
begin

-- 合同金额
select DATE_FORMAT(create_time,"%Y-%m"),sum(total_price) from purchase_order where status in(3,5) and create_time>=@yearStart and create_time<@yearEnd group by DATE_FORMAT(create_time,"%Y-%m");

-- 采购费用
select data_month,sum(total_amount) from expenses where second_classify="运输费" and is_delete=0 and data_year=@datayear group by data_month;

-- 本年材料入库
select DATE_FORMAT(create_time,"%Y-%m"),sum(price) from entry_out_store_record where operation_type=2 and type=2 and create_time>=@yearStart and create_time<@yearEnd  group by DATE_FORMAT(create_time,"%Y-%m");


-- 委托加工
begin
-- 表里面暂时没有委托加工费用
select data_month,sum(total_amount) from expenses where second_classify="委托加工费用" and is_delete=0 and data_year=@datayear group by data_month;

-- 制造费用
begin
-- 水电
select data_month,sum(total_amount) from expenses where second_classify="生产水费" and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where second_classify="生产电费" and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) total from expenses where expenses_classify="能耗费用",is_delete=0 and data_year=@datayear group by data_month;
-- 折旧
select data_month,sum(total_amount) from expenses where second_classify="折旧" and is_delete=0 and data_year=@datayear group by data_month;
-- 设备修理费
select data_month,sum(total_amount) from expenses where second_classify="维修费" and is_delete=0 and data_year=@datayear group by data_month;
-- 其他
select data_month,sum(total_amount) from expenses where second_classify in ("刀具",'夹具','量具','工具') and is_delete=0 and data_year=@datayear group by data_month;

-- 应付工资
begin

select data_month,sum(total_amount) from expenses where second_classify in ("总经理办公室",'财务管理部','采购管理组','经营管理部','生产制造部','质量管理中心') and data_year=@datayear group by data_month;

select data_month,sum(total_amount) from expenses where second_classify in ("技术管理中心") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where second_classify in ("机加车间") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where second_classify in ("装配车间","覆层车间") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where second_classify in ("新能源设备制造车间") and is_delete=0 and data_year=@datayear group by data_month;

-- 管理费用
begin
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("差旅费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("办公用品费","办公费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("邮寄费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("劳保费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where  second_classify in ("职工福利费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify in ("社保") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("招待费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("交通费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("知识产权费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where second_classify in ("油费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("通讯费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("审计费","认证费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="管理费用" and second_classify in ("咨询服务费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where   second_classify in ("保险费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where   second_classify in ("年检费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where   second_classify in ("维修费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where   second_classify in ("过路费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where   second_classify in ("模具费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where   expenses_classify in ("领导费用") and is_delete=0 and data_year=@datayear group by data_month;

-- 质量费用
begin
select data_month,sum(total_amount) from expenses where expenses_classify ="质量费用" and second_classify in ("运费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="质量费用" and second_classify in ("办公费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="质量费用" and second_classify in ("差旅费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="质量费用" and second_classify in ("培训费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="质量费用" and second_classify in ("检测费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="质量费用" and second_classify in ("认证费") and is_delete=0 and data_year=@datayear group by data_month;
-- 生产过程不合格品费用
select DATE_FORMAT(c.create_time,"%Y-%m"),sum(c.totalPrice) from (SELECT a.material_graph_no,a.create_time,a.material_count*b.price totalPrice FROM `replace_material` a left join price_material b on a.material_graph_no=b.graph_no where a.create_time>=@yearStart and a.create_time<@yearEnd)c   group by DATE_FORMAT(c.create_time,"%Y-%m")



-- 财务费用
begin
select data_month,sum(total_amount) from expenses where expenses_classify ="财务费用" and second_classify in ("贷款利息","贷款") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="财务费用" and second_classify in ("业务费") and is_delete=0 and data_year=@datayear group by data_month;

-- 销售费用
select data_month,sum(total_amount) from expenses where expenses_classify ="销售费用" and second_classify in ("运费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="销售费用" and second_classify in ("展会费") and is_delete=0 and data_year=@datayear group by data_month;


-- 税金
begin
-- 增值税
select data_month,sum(total_amount) from expenses where expenses_classify ="税金" and second_classify in ("增值税") and is_delete=0 and data_year=@datayear group by data_month;
-- 销项税 开票合计（含税）-开票合计（不含税）

-- 附加税
select data_month,sum(total_amount) from expenses where expenses_classify ="税金" and second_classify in ("附加税") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="税金" and second_classify in ("印花税") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="税金" and second_classify in ("残疾人就业保障金") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="税金" and second_classify in ("工会经费") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="税金" and second_classify in ("房产税","土地使用税") and is_delete=0 and data_year=@datayear group by data_month;
select data_month,sum(total_amount) from expenses where expenses_classify ="税金" and second_classify in ("企业所得税") and is_delete=0 and data_year=@datayear group by data_month;


select DATE_FORMAT(create_time,"%Y-%m"),sum(price) from entry_out_store_record where operation_type=2 and type=2 and create_time>=@yearStart and create_time<@yearEnd  group by DATE_FORMAT(create_time,"%Y-%m");


