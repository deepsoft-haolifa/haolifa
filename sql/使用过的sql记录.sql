-- 更新订单表的发货数量字段
UPDATE order_product
INNER JOIN (
select sum(product_count) productSum,contract_order_no orderNo from delivery_record group by contract_order_no
) b ON order_product.order_no = b.orderNo
SET order_product.delivered_number = b.productSum;