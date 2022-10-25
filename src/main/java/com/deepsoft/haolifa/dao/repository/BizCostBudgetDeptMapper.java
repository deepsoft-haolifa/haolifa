package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizCostBudgetDept;
import com.deepsoft.haolifa.model.domain.BizCostBudgetDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizCostBudgetDeptMapper {
    int countByExample(BizCostBudgetDeptExample example);

    int deleteByExample(BizCostBudgetDeptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizCostBudgetDept record);

    int insertSelective(BizCostBudgetDept record);

    List<BizCostBudgetDept> selectByExample(BizCostBudgetDeptExample example);

    BizCostBudgetDept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizCostBudgetDept record, @Param("example") BizCostBudgetDeptExample example);

    int updateByExample(@Param("record") BizCostBudgetDept record, @Param("example") BizCostBudgetDeptExample example);

    int updateByPrimaryKeySelective(BizCostBudgetDept record);

    int updateByPrimaryKey(BizCostBudgetDept record);
}