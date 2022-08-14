package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.TechnicalDetailed;
import com.deepsoft.haolifa.model.domain.TechnicalDetailedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TechnicalDetailedMapper {
    int countByExample(TechnicalDetailedExample example);

    int deleteByExample(TechnicalDetailedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TechnicalDetailed record);

    int insertSelective(TechnicalDetailed record);

    List<TechnicalDetailed> selectByExample(TechnicalDetailedExample example);

    TechnicalDetailed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TechnicalDetailed record, @Param("example") TechnicalDetailedExample example);

    int updateByExample(@Param("record") TechnicalDetailed record, @Param("example") TechnicalDetailedExample example);

    int updateByPrimaryKeySelective(TechnicalDetailed record);

    int updateByPrimaryKey(TechnicalDetailed record);
}