-- 更新订单表的发货数量字段
UPDATE order_product
INNER JOIN (
select sum(product_count) productSum,contract_order_no orderNo from delivery_record group by contract_order_no
) b ON order_product.order_no = b.orderNo
SET order_product.delivered_number = b.productSum;

-- 更新附件的url字段
update order_product set order_contract_extend_url=replace(order_contract_extend_url,'d.miaojiebei.com','upload.haolifa.com');
update order_product set order_contract_url=replace(order_contract_url,'d.miaojiebei.com','upload.haolifa.com');
update file_record set file_url=replace(file_url,'d.miaojiebei.com','upload.haolifa.com');
update purchase_order set file_url=replace(file_url,'d.miaojiebei.com','upload.haolifa.com');
update flow_instance set accessory=replace(accessory,'d.miaojiebei.com','upload.haolifa.com');