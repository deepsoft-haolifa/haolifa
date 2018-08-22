package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PurchaseOrderItem;
import com.deepsoft.haolifa.model.domain.PurchaseOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderItemMapper {
    long countByExample(PurchaseOrderItemExample example);

    int deleteByExample(PurchaseOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrderItem record);

    int insertSelective(PurchaseOrderItem record);

    List<PurchaseOrderItem> selectByExample(PurchaseOrderItemExample example);

    PurchaseOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrderItem record, @Param("example") PurchaseOrderItemExample example);

    int updateByExample(@Param("record") PurchaseOrderItem record, @Param("example") PurchaseOrderItemExample example);

    int updateByPrimaryKeySelective(PurchaseOrderItem record);

    int updateByPrimaryKey(PurchaseOrderItem record);

    /**
     * 批量插入
     * @param purchaseOrderItemList
     */
    void batchInsertPurchaseOrderItem(List<PurchaseOrderItem> purchaseOrderItemList);
}