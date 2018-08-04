package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.MaterialClassify;
import com.deepsoft.haolifa.model.domain.MaterialClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialClassifyMapper {
    long countByExample(MaterialClassifyExample example);

    int deleteByExample(MaterialClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MaterialClassify record);

    int insertSelective(MaterialClassify record);

    List<MaterialClassify> selectByExample(MaterialClassifyExample example);

    MaterialClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MaterialClassify record, @Param("example") MaterialClassifyExample example);

    int updateByExample(@Param("record") MaterialClassify record, @Param("example") MaterialClassifyExample example);

    int updateByPrimaryKeySelective(MaterialClassify record);

    int updateByPrimaryKey(MaterialClassify record);
}