package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizCostBudgetSubjects;
import com.deepsoft.haolifa.model.domain.BizCostBudgetSubjectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizCostBudgetSubjectsMapper {
    int countByExample(BizCostBudgetSubjectsExample example);

    int deleteByExample(BizCostBudgetSubjectsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizCostBudgetSubjects record);

    int insertSelective(BizCostBudgetSubjects record);

    List<BizCostBudgetSubjects> selectByExample(BizCostBudgetSubjectsExample example);

    BizCostBudgetSubjects selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizCostBudgetSubjects record, @Param("example") BizCostBudgetSubjectsExample example);

    int updateByExample(@Param("record") BizCostBudgetSubjects record, @Param("example") BizCostBudgetSubjectsExample example);

    int updateByPrimaryKeySelective(BizCostBudgetSubjects record);

    int updateByPrimaryKey(BizCostBudgetSubjects record);
}