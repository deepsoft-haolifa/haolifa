package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.order.OrderMaterialDTO;

import java.util.List;

/**
 * 订单核料记录接口
 *
 * @author murphy.he
 **/
public interface OrderMaterialService {

    /**
     * 更新核料清单数据
     */
    void updateOrderMaterial(List<OrderMaterialDTO> list);
}
