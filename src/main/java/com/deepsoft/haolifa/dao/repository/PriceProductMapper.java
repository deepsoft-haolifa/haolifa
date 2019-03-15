package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PriceProduct;
import com.deepsoft.haolifa.model.domain.PriceProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PriceProductMapper {
    int countByExample(PriceProductExample example);

    int deleteByExample(PriceProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PriceProduct record);

    int insertSelective(PriceProduct record);

    List<PriceProduct> selectByExample(PriceProductExample example);

    PriceProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PriceProduct record, @Param("example") PriceProductExample example);

    int updateByExample(@Param("record") PriceProduct record, @Param("example") PriceProductExample example);

    int updateByPrimaryKeySelective(PriceProduct record);

    int updateByPrimaryKey(PriceProduct record);
}