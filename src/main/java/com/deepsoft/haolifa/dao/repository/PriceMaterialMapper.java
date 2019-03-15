package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PriceMaterial;
import com.deepsoft.haolifa.model.domain.PriceMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceMaterialMapper {
    int countByExample(PriceMaterialExample example);

    int deleteByExample(PriceMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PriceMaterial record);

    int insertSelective(PriceMaterial record);

    List<PriceMaterial> selectByExample(PriceMaterialExample example);

    PriceMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PriceMaterial record, @Param("example") PriceMaterialExample example);

    int updateByExample(@Param("record") PriceMaterial record, @Param("example") PriceMaterialExample example);

    int updateByPrimaryKeySelective(PriceMaterial record);

    int updateByPrimaryKey(PriceMaterial record);
}