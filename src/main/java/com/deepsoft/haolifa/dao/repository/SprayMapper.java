package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.Spray;
import com.deepsoft.haolifa.model.domain.SprayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SprayMapper {
    int countByExample(SprayExample example);

    int deleteByExample(SprayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Spray record);

    int insertSelective(Spray record);

    List<Spray> selectByExample(SprayExample example);

    Spray selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Spray record, @Param("example") SprayExample example);

    int updateByExample(@Param("record") Spray record, @Param("example") SprayExample example);

    int updateByPrimaryKeySelective(Spray record);

    int updateByPrimaryKey(Spray record);
}