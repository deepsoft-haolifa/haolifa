package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.FileRecord;
import com.deepsoft.haolifa.model.domain.FileRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileRecordMapper {
    int countByExample(FileRecordExample example);

    int deleteByExample(FileRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileRecord record);

    int insertSelective(FileRecord record);

    List<FileRecord> selectByExample(FileRecordExample example);

    FileRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileRecord record, @Param("example") FileRecordExample example);

    int updateByExample(@Param("record") FileRecord record, @Param("example") FileRecordExample example);

    int updateByPrimaryKeySelective(FileRecord record);

    int updateByPrimaryKey(FileRecord record);
}