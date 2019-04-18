package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.SprayItem;
import com.deepsoft.haolifa.model.domain.SprayItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SprayItemMapper {
    int countByExample(SprayItemExample example);

    int deleteByExample(SprayItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SprayItem record);

    int insertSelective(SprayItem record);

    List<SprayItem> selectByExample(SprayItemExample example);

    SprayItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SprayItem record, @Param("example") SprayItemExample example);

    int updateByExample(@Param("record") SprayItem record, @Param("example") SprayItemExample example);

    int updateByPrimaryKeySelective(SprayItem record);

    int updateByPrimaryKey(SprayItem record);
}