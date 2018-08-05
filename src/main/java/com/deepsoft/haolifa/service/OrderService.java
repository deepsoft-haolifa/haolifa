package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.Order;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.github.pagehelper.Page;

public interface OrderService {
    /**
     * 上传订单excel
     * @param base64Source base64 excel
     * @return
     */
    ResultBean uploadOrderExcel(String base64Source);

    /**
     * 添加order信息
     * @param order
     * @return
     */
    ResultBean saveOrderInfo(Order order);

    /**
     * 修改订单状态
     * @param orderNo
     * @param status
     * @return
     */
    int updateOrderStatus(String orderNo,byte status);

    /**
     * 获取订单详情
     * @param orderNo
     * @return
     */
    Order getOrderInfo(String orderNo);

    /**
     * 获取订单分页列表
     * @return
     */
    Page<Order> pageOrder(Page page);
}
