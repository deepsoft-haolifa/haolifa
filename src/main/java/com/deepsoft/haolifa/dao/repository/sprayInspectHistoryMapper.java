package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.sprayInspectHistory;
import com.deepsoft.haolifa.model.domain.sprayInspectHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sprayInspectHistoryMapper {
    int countByExample(sprayInspectHistoryExample example);

    int deleteByExample(sprayInspectHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(sprayInspectHistory record);

    int insertSelective(sprayInspectHistory record);

    List<sprayInspectHistory> selectByExample(sprayInspectHistoryExample example);

    sprayInspectHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") sprayInspectHistory record, @Param("example") sprayInspectHistoryExample example);

    int updateByExample(@Param("record") sprayInspectHistory record, @Param("example") sprayInspectHistoryExample example);

    int updateByPrimaryKeySelective(sprayInspectHistory record);

    int updateByPrimaryKey(sprayInspectHistory record);
}