package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.InspectInfo;
import com.deepsoft.haolifa.model.domain.InspectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InspectInfoMapper {
    long countByExample(InspectInfoExample example);

    int deleteByExample(InspectInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InspectInfo record);

    int insertSelective(InspectInfo record);

    List<InspectInfo> selectByExample(InspectInfoExample example);

    InspectInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectInfo record, @Param("example") InspectInfoExample example);

    int updateByExample(@Param("record") InspectInfo record, @Param("example") InspectInfoExample example);

    int updateByPrimaryKeySelective(InspectInfo record);

    int updateByPrimaryKey(InspectInfo record);
}