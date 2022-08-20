package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.OrderTechnicalDetailedRel;
import com.deepsoft.haolifa.model.domain.OrderTechnicalDetailedRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTechnicalDetailedRelMapper {
    int countByExample(OrderTechnicalDetailedRelExample example);

    int deleteByExample(OrderTechnicalDetailedRelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderTechnicalDetailedRel record);

    int insertSelective(OrderTechnicalDetailedRel record);

    List<OrderTechnicalDetailedRel> selectByExample(OrderTechnicalDetailedRelExample example);

    OrderTechnicalDetailedRel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderTechnicalDetailedRel record, @Param("example") OrderTechnicalDetailedRelExample example);

    int updateByExample(@Param("record") OrderTechnicalDetailedRel record, @Param("example") OrderTechnicalDetailedRelExample example);

    int updateByPrimaryKeySelective(OrderTechnicalDetailedRel record);

    int updateByPrimaryKey(OrderTechnicalDetailedRel record);
}