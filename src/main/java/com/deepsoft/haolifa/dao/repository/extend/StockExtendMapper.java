package com.deepsoft.haolifa.dao.repository.extend;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @className: StockExtendMapper
 * @description: 库存额外sql
 **/
public interface StockExtendMapper {

    @Update("UPDATE stock SET quantity=quantity+#{quantity} where room_no='' and rack_no='' and material_graph_no='' and material_batch_no=''")
    int addQuantity(@Param("graphNo") String graphNo, @Param("quantity") int quantity);

    @Update("update material set lock_quantity=lock_quantity+#{quantity} where graph_no=#{graphNo}")
    int reduceQuantity(@Param("graphNo") String graphNo, @Param("quantity") int quantity);
}



