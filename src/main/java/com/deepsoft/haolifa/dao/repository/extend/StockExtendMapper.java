package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.EntryOutStorageDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @className: StockExtendMapper
 * @description: 库存额外sql
 **/
public interface StockExtendMapper {

    @Update("UPDATE stock SET quantity=quantity+#{quantity},version=version+1 where room_no=#{roomNo} and rack_no=#{rackNo} and material_graph_no=#{materialGraphNo} and material_batch_no=#{materialBatchNo} and version=#{version}")
    int addMaterialQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("materialGraphNo") String materialGraphNo, @Param("materialBatchNo") String materialBatchNo, @Param("quantity") int quantity,@Param("version") int version);

    @Update("UPDATE stock SET quantity=quantity+#{quantity},version=version+1 where room_no=#{roomNo} and rack_no=#{rackNo} and material_graph_no=#{materialGraphNo} and material_batch_no=#{materialBatchNo} and quantity>=abs(#{quantity}) and version=#{version}")
    int reduceMaterialQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("materialGraphNo") String materialGraphNo, @Param("materialBatchNo") String materialBatchNo, @Param("quantity") int quantity,@Param("version") int version);

    @Update("UPDATE stock SET quantity=quantity+#{quantity},version=version+1 where room_no=#{roomNo} and rack_no=#{rackNo} and product_no=#{productNo} and version=#{version}")
    int addProductQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("productNo") String productNo, @Param("quantity") int quantity,@Param("version") int version);

    @Update("UPDATE stock SET quantity=quantity+#{quantity},version=version+1 where room_no=#{roomNo} and rack_no=#{rackNo} and product_no=#{productNo} and quantity>=abs(#{quantity}) and version=#{version}")
    int reduceProductQuantity(@Param("roomNo") String roomNo, @Param("rackNo") String rackNo, @Param("productNo") String productNo, @Param("quantity") int quantity,@Param("version") int version);

}



