package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.export.PaymentRespDTO;
import com.deepsoft.haolifa.model.dto.export.TotalAmountDTO;
import com.deepsoft.haolifa.model.dto.order.OrderConditionDTO;
import com.deepsoft.haolifa.model.dto.order.OrderListRespDTO;

import java.math.BigDecimal;

/**
 * @author murphy.he
 **/
public interface ReportExtendService {

    /**
     * 用于报表展示订单列表数据
     * @param dto
     * @return
     */
    PageDTO<OrderListRespDTO> reportOrderList(OrderConditionDTO dto);

    /**
     * 用于报表累计订货额显示
     * @param dto
     * @return
     */
    BigDecimal reportOrderSummary(OrderConditionDTO dto);
    /**
     * 用于报表展示回款列表数据
     * @param dto
     * @return
     */
    PageDTO<PaymentRespDTO> reportCollectOrderList(OrderConditionDTO dto);

    /**
     * 用于报表回款订货额显示
     * @param dto
     * @return
     */
    TotalAmountDTO reportCollectOrderSummary(OrderConditionDTO dto);
}
