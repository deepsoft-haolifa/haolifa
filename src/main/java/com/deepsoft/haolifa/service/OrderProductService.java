package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.dto.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.github.pagehelper.Page;

public interface OrderProductService {
    /**
     * 上传订单excel
     *
     * @param base64Source base64 excel
     * @return
     */
    ResultBean uploadOrderProductExcel(String base64Source);

    /**
     * 添加order信息
     *
     * @param order
     * @return
     */
    ResultBean saveOrderProductInfo(OrderProductDTO order);

    /**
     * 修改订单状态
     *
     * @param orderNo
     * @param status
     * @return
     */
    int updateOrderProductStatus(String orderNo, byte status);

    /**
     * 获取订单详情
     *
     * @param orderNo
     * @return
     */
    OrderProduct getOrderProductInfo(String orderNo);

    /**
     * 获取订单分页列表
     *
     * @return
     */
    ResultBean pageOrderProduct(Integer currentPage, Integer pageSize, String orderNo, int orderStatus);
}
