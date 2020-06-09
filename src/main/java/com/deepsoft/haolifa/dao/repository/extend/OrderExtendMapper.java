package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.CheckMaterialLog;
import com.deepsoft.haolifa.model.dto.order.OrderCheckMaterialDTO;
import com.deepsoft.haolifa.model.dto.order.OrderMaterialDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
//    void insertBatchOrderProductAssociate(@Param("list") List<OrderProductAssociate> list);


    /**
     * 获取订单零件列表(核料清单)
     *
     * @param orderNo
     */
    List<OrderMaterialDTO> listOrderMaterial(@Param("orderNo") String orderNo);


    /**
     * 批量插入核料日志表(核料清单)
     *
     */
    void insertBatchCheckLog(@Param("list") List<CheckMaterialLog> list);



    /**
     * 根据订单状态获取订单号列表
     *
     */
    @Select("SELECT order_no FROM `order_product` WHERE order_status in (#{orderStatus})")
    List<String> listOrderNo(@Param("orderStatus") String orderStatus);



    /**
     * 获取订单产品数量（订单页面头部展示）
     *
     */
    int countProduct(Map<String, Object> paramMap);
}
