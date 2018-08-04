package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.FinanceInfo;
import com.deepsoft.haolifa.model.domain.FinanceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinanceInfoMapper {
    long countByExample(FinanceInfoExample example);

    int deleteByExample(FinanceInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinanceInfo record);

    int insertSelective(FinanceInfo record);

    List<FinanceInfo> selectByExample(FinanceInfoExample example);

    FinanceInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinanceInfo record, @Param("example") FinanceInfoExample example);

    int updateByExample(@Param("record") FinanceInfo record, @Param("example") FinanceInfoExample example);

    int updateByPrimaryKeySelective(FinanceInfo record);

    int updateByPrimaryKey(FinanceInfo record);
}