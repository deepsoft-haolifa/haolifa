package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.Material;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @className: MaterialExtendMapper
 * @description: 零件额外sql
 * @author: hedong@ibeesaas.com
 * @date: 2018-09-10 15:35
 **/
public interface MaterialExtendMapper {

    @Update("update material set current_quantity=current_quantity+#{quantity} where graph_no=#{graphNo}")
    int updateCurrentQuantity(@Param("graphNo") String graphNo, @Param("quantity") int quantity);

    @Update("update material set lock_quantity=lock_quantity+#{quantity} where graph_no=#{graphNo}")
    int updateLockQuantity(@Param("graphNo") String graphNo, @Param("quantity") int quantity);

    @Select("select id,graph_no as graphNo,name,support_quantity as supportQuantity,current_quantity as currentQuantity from material where material_classify_id = #{classifyId} and find_in_set(#{model},model) and  find_in_set(#{specifications},specifications)")
    List<Material> getListByMultiModelAndSpec(@Param("classifyId") int classifyId, @Param("model") String model, @Param("specifications") String specifications);
}



