package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.Spray;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: SparyExtendMapper
 * @description: 喷涂sql
 **/
public interface SparyExtendMapper {


    /**
     * 根据图号获取正在喷涂（状态为加工中和质检完成的）
     *
     * @param materialGraphNo
     * @return
     */
    @Select("select spray_no sprayNo,total_number totalNumber,qualified_number qualifiedNumber from  spray where spray_no in( select spray_no FROM `spray_item` where material_graph_no=#{materialGraphNo})  and status in(1,2)")
    List<Spray> obtainNumber(@Param("materialGraphNo") String materialGraphNo);


}



