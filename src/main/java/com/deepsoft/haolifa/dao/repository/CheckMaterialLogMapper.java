package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.CheckMaterialLog;
import com.deepsoft.haolifa.model.domain.CheckMaterialLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckMaterialLogMapper {
    long countByExample(CheckMaterialLogExample example);

    int deleteByExample(CheckMaterialLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckMaterialLog record);

    int insertSelective(CheckMaterialLog record);

    List<CheckMaterialLog> selectByExample(CheckMaterialLogExample example);

    CheckMaterialLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckMaterialLog record, @Param("example") CheckMaterialLogExample example);

    int updateByExample(@Param("record") CheckMaterialLog record, @Param("example") CheckMaterialLogExample example);

    int updateByPrimaryKeySelective(CheckMaterialLog record);

    int updateByPrimaryKey(CheckMaterialLog record);
}