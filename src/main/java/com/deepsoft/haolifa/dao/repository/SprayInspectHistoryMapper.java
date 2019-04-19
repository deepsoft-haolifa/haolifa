package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SprayInspectHistory;
import com.deepsoft.haolifa.model.domain.SprayInspectHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SprayInspectHistoryMapper {
    int countByExample(SprayInspectHistoryExample example);

    int deleteByExample(SprayInspectHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SprayInspectHistory record);

    int insertSelective(SprayInspectHistory record);

    List<SprayInspectHistory> selectByExample(SprayInspectHistoryExample example);

    SprayInspectHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SprayInspectHistory record, @Param("example") SprayInspectHistoryExample example);

    int updateByExample(@Param("record") SprayInspectHistory record, @Param("example") SprayInspectHistoryExample example);

    int updateByPrimaryKeySelective(SprayInspectHistory record);

    int updateByPrimaryKey(SprayInspectHistory record);
}