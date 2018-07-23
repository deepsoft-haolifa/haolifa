package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PurchaseOrderInfo;
import com.deepsoft.haolifa.model.domain.PurchaseOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderInfoMapper {
    long countByExample(PurchaseOrderInfoExample example);

    int deleteByExample(PurchaseOrderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrderInfo record);

    int insertSelective(PurchaseOrderInfo record);

    List<PurchaseOrderInfo> selectByExample(PurchaseOrderInfoExample example);

    PurchaseOrderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrderInfo record, @Param("example") PurchaseOrderInfoExample example);

    int updateByExample(@Param("record") PurchaseOrderInfo record, @Param("example") PurchaseOrderInfoExample example);

    int updateByPrimaryKeySelective(PurchaseOrderInfo record);

    int updateByPrimaryKey(PurchaseOrderInfo record);
}