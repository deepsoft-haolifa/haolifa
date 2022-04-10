package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizSubjectsBalanceFlow;
import com.deepsoft.haolifa.model.domain.BizSubjectsBalanceFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizSubjectsBalanceFlowMapper {
    int countByExample(BizSubjectsBalanceFlowExample example);

    int deleteByExample(BizSubjectsBalanceFlowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizSubjectsBalanceFlow record);

    int insertSelective(BizSubjectsBalanceFlow record);

    List<BizSubjectsBalanceFlow> selectByExample(BizSubjectsBalanceFlowExample example);

    BizSubjectsBalanceFlow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizSubjectsBalanceFlow record, @Param("example") BizSubjectsBalanceFlowExample example);

    int updateByExample(@Param("record") BizSubjectsBalanceFlow record, @Param("example") BizSubjectsBalanceFlowExample example);

    int updateByPrimaryKeySelective(BizSubjectsBalanceFlow record);

    int updateByPrimaryKey(BizSubjectsBalanceFlow record);
}