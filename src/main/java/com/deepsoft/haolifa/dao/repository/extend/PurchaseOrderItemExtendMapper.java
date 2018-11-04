package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.PurchaseOrderItem;
import com.deepsoft.haolifa.model.domain.PurchaseOrderItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseOrderItemExtendMapper {

    /**
     * 批量插入
     * @param purchaseOrderItemList
     */
    void batchInsertPurchaseOrderItem(List<PurchaseOrderItem> purchaseOrderItemList);
}