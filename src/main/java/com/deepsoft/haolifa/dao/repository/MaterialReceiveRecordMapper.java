package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.MaterialReceiveRecord;
import com.deepsoft.haolifa.model.domain.MaterialReceiveRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialReceiveRecordMapper {
    long countByExample(MaterialReceiveRecordExample example);

    int deleteByExample(MaterialReceiveRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialReceiveRecord record);

    int insertSelective(MaterialReceiveRecord record);

    List<MaterialReceiveRecord> selectByExample(MaterialReceiveRecordExample example);

    MaterialReceiveRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialReceiveRecord record, @Param("example") MaterialReceiveRecordExample example);

    int updateByExample(@Param("record") MaterialReceiveRecord record, @Param("example") MaterialReceiveRecordExample example);

    int updateByPrimaryKeySelective(MaterialReceiveRecord record);

    int updateByPrimaryKey(MaterialReceiveRecord record);
}