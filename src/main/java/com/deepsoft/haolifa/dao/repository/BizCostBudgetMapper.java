package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizCostBudget;
import com.deepsoft.haolifa.model.domain.BizCostBudgetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizCostBudgetMapper {
    int countByExample(BizCostBudgetExample example);

    int deleteByExample(BizCostBudgetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizCostBudget record);

    int insertSelective(BizCostBudget record);

    List<BizCostBudget> selectByExample(BizCostBudgetExample example);

    BizCostBudget selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizCostBudget record, @Param("example") BizCostBudgetExample example);

    int updateByExample(@Param("record") BizCostBudget record, @Param("example") BizCostBudgetExample example);

    int updateByPrimaryKeySelective(BizCostBudget record);

    int updateByPrimaryKey(BizCostBudget record);
}