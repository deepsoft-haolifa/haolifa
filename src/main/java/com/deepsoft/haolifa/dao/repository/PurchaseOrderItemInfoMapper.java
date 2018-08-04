package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PurchaseOrderItemInfo;
import com.deepsoft.haolifa.model.domain.PurchaseOrderItemInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderItemInfoMapper {
    long countByExample(PurchaseOrderItemInfoExample example);

    int deleteByExample(PurchaseOrderItemInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrderItemInfo record);

    int insertSelective(PurchaseOrderItemInfo record);

    List<PurchaseOrderItemInfo> selectByExample(PurchaseOrderItemInfoExample example);

    PurchaseOrderItemInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrderItemInfo record, @Param("example") PurchaseOrderItemInfoExample example);

    int updateByExample(@Param("record") PurchaseOrderItemInfo record, @Param("example") PurchaseOrderItemInfoExample example);

    int updateByPrimaryKeySelective(PurchaseOrderItemInfo record);

    int updateByPrimaryKey(PurchaseOrderItemInfo record);
}