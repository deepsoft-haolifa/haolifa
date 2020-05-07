set @year=2019;
-- 销售运费
select FROM_UNIXTIME(UNIX_TIMESTAMP(create_time),"%Y-%m"),delivery_classify,sum(product_count),sum(total_fee) from delivery_record
where  FROM_UNIXTIME(UNIX_TIMESTAMP(create_time),"%Y")= @year
group by delivery_classify, FROM_UNIXTIME(UNIX_TIMESTAMP(create_time),"%Y-%m")  ORDER BY FROM_UNIXTIME(UNIX_TIMESTAMP(create_time),"%Y-%m");

