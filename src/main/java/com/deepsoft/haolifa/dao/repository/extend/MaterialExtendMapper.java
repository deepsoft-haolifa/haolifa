package com.deepsoft.haolifa.dao.repository.extend;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @className: MaterialExtendMapper
 * @description: 零件额外sql
 * @author: hedong@ibeesaas.com
 * @date: 2018-09-10 15:35
 **/
public interface MaterialExtendMapper {

    @Update("update material set current_quantity=current_quantity+#{quantity} where graph_no=#{graphNo}")
    int updateCurrentQuantity(@Param("graphNo") String graphNo, @Param("quantity") int quantity);
}



