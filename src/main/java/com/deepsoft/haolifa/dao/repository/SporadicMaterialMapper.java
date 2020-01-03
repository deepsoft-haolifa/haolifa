package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SporadicMaterial;
import com.deepsoft.haolifa.model.domain.SporadicMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SporadicMaterialMapper {
    int countByExample(SporadicMaterialExample example);

    int deleteByExample(SporadicMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SporadicMaterial record);

    int insertSelective(SporadicMaterial record);

    List<SporadicMaterial> selectByExample(SporadicMaterialExample example);

    SporadicMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SporadicMaterial record, @Param("example") SporadicMaterialExample example);

    int updateByExample(@Param("record") SporadicMaterial record, @Param("example") SporadicMaterialExample example);

    int updateByPrimaryKeySelective(SporadicMaterial record);

    int updateByPrimaryKey(SporadicMaterial record);
}