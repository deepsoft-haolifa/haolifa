package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ReplaceMaterial;
import com.deepsoft.haolifa.model.domain.ReplaceMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplaceMaterialMapper {
    long countByExample(ReplaceMaterialExample example);

    int deleteByExample(ReplaceMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReplaceMaterial record);

    int insertSelective(ReplaceMaterial record);

    List<ReplaceMaterial> selectByExample(ReplaceMaterialExample example);

    ReplaceMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReplaceMaterial record, @Param("example") ReplaceMaterialExample example);

    int updateByExample(@Param("record") ReplaceMaterial record, @Param("example") ReplaceMaterialExample example);

    int updateByPrimaryKeySelective(ReplaceMaterial record);

    int updateByPrimaryKey(ReplaceMaterial record);
}