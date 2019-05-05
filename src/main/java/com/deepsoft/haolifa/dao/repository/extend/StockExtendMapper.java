package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @className: StockExtendMapper
 * @description: 库存额外sql
 **/
public interface StockExtendMapper {

    @Update("UPDATE stock SET quantity=quantity+#{quantity} where room_no=#{roomNo} and rack_no=#{rackNo} and material_graph_no=#{materialGraphNo} and material_batch_no=#{materialBatchNo}")
    int addMaterialQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("materialGraphNo") String materialGraphNo, @Param("materialBatchNo") String materialBatchNo, @Param("quantity") int quantity);

    @Update("UPDATE stock SET quantity=quantity+#{quantity} where room_no=#{roomNo} and rack_no=#{rackNo} and material_graph_no=#{materialGraphNo} and material_batch_no=#{materialBatchNo} and quantity>=abs(#{quantity})")
    int reduceMaterialQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("materialGraphNo") String materialGraphNo, @Param("materialBatchNo") String materialBatchNo, @Param("quantity") int quantity);

    @Update("UPDATE stock SET quantity=quantity+#{quantity} where room_no=#{roomNo} and rack_no=#{rackNo} and product_no=#{productNo}")
    int addProductQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("productNo") String productNo, @Param("quantity") int quantity);

    @Update("UPDATE stock SET quantity=quantity+#{quantity} where room_no=#{roomNo} and rack_no=#{rackNo} and product_no=#{productNo} and quantity>=abs(#{quantity})")
    int reduceProductQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("productNo") String productNo, @Param("quantity") int quantity);

}



