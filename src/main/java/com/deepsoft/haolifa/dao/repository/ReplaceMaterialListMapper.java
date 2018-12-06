package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ReplaceMaterialList;
import com.deepsoft.haolifa.model.domain.ReplaceMaterialListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplaceMaterialListMapper {
    long countByExample(ReplaceMaterialListExample example);

    int deleteByExample(ReplaceMaterialListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReplaceMaterialList record);

    int insertSelective(ReplaceMaterialList record);

    List<ReplaceMaterialList> selectByExample(ReplaceMaterialListExample example);

    ReplaceMaterialList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReplaceMaterialList record, @Param("example") ReplaceMaterialListExample example);

    int updateByExample(@Param("record") ReplaceMaterialList record, @Param("example") ReplaceMaterialListExample example);

    int updateByPrimaryKeySelective(ReplaceMaterialList record);

    int updateByPrimaryKey(ReplaceMaterialList record);
}