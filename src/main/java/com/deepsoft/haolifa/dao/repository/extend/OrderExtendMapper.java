package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import com.deepsoft.haolifa.model.dto.OrderCheckMaterialDTO;
import com.deepsoft.haolifa.model.dto.OrderMaterialDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderExtendMapper {

    /**
     * 批量插入订单原料表
     *
     * @param list
     */
    void insertBatchOrderMaterial(@Param("list") List<OrderCheckMaterialDTO> list);

    /**
     * 批量插入订单产品表
     *
     * @param list
     */
    void insertBatchOrderProduct(@Param("list") List<OrderProductAssociate> list);


    /**
     * 获取订单零件列表(核料清单)
     *
     * @param orderNo
     */
    List<OrderMaterialDTO> listOrderMaterial(@Param("orderNo") String orderNo);

}
