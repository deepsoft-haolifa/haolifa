package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.AutoControlInspectHistory;
import com.deepsoft.haolifa.model.domain.AutoControlInspectHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoControlInspectHistoryMapper {
    int countByExample(AutoControlInspectHistoryExample example);

    int deleteByExample(AutoControlInspectHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoControlInspectHistory record);

    int insertSelective(AutoControlInspectHistory record);

    List<AutoControlInspectHistory> selectByExample(AutoControlInspectHistoryExample example);

    AutoControlInspectHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoControlInspectHistory record, @Param("example") AutoControlInspectHistoryExample example);

    int updateByExample(@Param("record") AutoControlInspectHistory record, @Param("example") AutoControlInspectHistoryExample example);

    int updateByPrimaryKeySelective(AutoControlInspectHistory record);

    int updateByPrimaryKey(AutoControlInspectHistory record);
}