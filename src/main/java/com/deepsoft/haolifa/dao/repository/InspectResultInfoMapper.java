package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.InspectResultInfo;
import com.deepsoft.haolifa.model.domain.InspectResultInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InspectResultInfoMapper {
    long countByExample(InspectResultInfoExample example);

    int deleteByExample(InspectResultInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InspectResultInfo record);

    int insertSelective(InspectResultInfo record);

    List<InspectResultInfo> selectByExample(InspectResultInfoExample example);

    InspectResultInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectResultInfo record, @Param("example") InspectResultInfoExample example);

    int updateByExample(@Param("record") InspectResultInfo record, @Param("example") InspectResultInfoExample example);

    int updateByPrimaryKeySelective(InspectResultInfo record);

    int updateByPrimaryKey(InspectResultInfo record);
}