package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.OrderMaterial;
import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderExtendMapper {

    /**
     * 批量插入订单原料表
     * @param list
     */
    void insertBatchOrderMaterial(@Param("list") List<OrderMaterial> list);

    /**
     * 批量插入订单产品表
     * @param list
     */
    void insertBatchOrderProduct(@Param("list") List<OrderProductAssociate> list);

}
