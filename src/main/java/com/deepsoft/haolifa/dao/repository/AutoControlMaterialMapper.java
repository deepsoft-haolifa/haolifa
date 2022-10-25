package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.AutoControlMaterial;
import com.deepsoft.haolifa.model.domain.AutoControlMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoControlMaterialMapper {
    int countByExample(AutoControlMaterialExample example);

    int deleteByExample(AutoControlMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoControlMaterial record);

    int insertSelective(AutoControlMaterial record);

    List<AutoControlMaterial> selectByExample(AutoControlMaterialExample example);

    AutoControlMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoControlMaterial record, @Param("example") AutoControlMaterialExample example);

    int updateByExample(@Param("record") AutoControlMaterial record, @Param("example") AutoControlMaterialExample example);

    int updateByPrimaryKeySelective(AutoControlMaterial record);

    int updateByPrimaryKey(AutoControlMaterial record);
}