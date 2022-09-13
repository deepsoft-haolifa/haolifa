package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizProjectBudget;
import com.deepsoft.haolifa.model.domain.BizProjectBudgetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizProjectBudgetMapper {
    int countByExample(BizProjectBudgetExample example);

    int deleteByExample(BizProjectBudgetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizProjectBudget record);

    int insertSelective(BizProjectBudget record);

    List<BizProjectBudget> selectByExample(BizProjectBudgetExample example);

    BizProjectBudget selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizProjectBudget record, @Param("example") BizProjectBudgetExample example);

    int updateByExample(@Param("record") BizProjectBudget record, @Param("example") BizProjectBudgetExample example);

    int updateByPrimaryKeySelective(BizProjectBudget record);

    int updateByPrimaryKey(BizProjectBudget record);
}