package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptTree;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsRSDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.CostBudgetSubjectsUpDTO;

import java.util.List;

public interface CostBudgetService {


    ResultBean saveDeptBudget(CostBudgetDeptAddDTO model);

    ResultBean deleteDeptBudget(int id);

    ResultBean updateDeptBudget(CostBudgetDeptUpDTO model);

    ResultBean<List<CostBudgetDeptTree>>  getDeptBudgetListTree(CostBudgetDeptRQDTO model);



    ResultBean saveSubjectsBudget(CostBudgetSubjectsAddDTO model);

    ResultBean deleteSubjectsBudget(int id);

    ResultBean updateSubjectsBudget(CostBudgetSubjectsUpDTO model);

    ResultBean<PageDTO<CostBudgetSubjectsRSDTO>> getSubjectsBudgetList(CostBudgetSubjectsRQDTO model);

    ResultBean deleteSubjectsBudgetBatch(List<Integer> ids);
}
