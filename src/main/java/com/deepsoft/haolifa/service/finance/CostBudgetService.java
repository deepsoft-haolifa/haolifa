package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizSubjectsBalance;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.CostBudget;
import com.deepsoft.haolifa.model.dto.finance.costbudget.CostBudgetQuery;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptAddUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptRQDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptTree;
import com.deepsoft.haolifa.model.dto.finance.costbudget.dept.CostBudgetDeptUpDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.subjects.*;

import java.math.BigDecimal;
import java.util.List;

public interface CostBudgetService {


    ResultBean saveOrUpDeptBudget(CostBudgetDeptAddUpDTO model);

    ResultBean deleteDeptBudget(int id);

    ResultBean updateDeptBudget(CostBudgetDeptUpDTO model);

    public ResultBean<CostBudget> selectCostBudget(CostBudgetQuery model);

    ResultBean<List<CostBudgetDeptTree>>  getDeptBudgetListTree(CostBudgetDeptRQDTO model);



    ResultBean saveSubjectsBudget(CostBudgetSubjectsAddDTO model);

    ResultBean deleteSubjectsBudget(int id);

    ResultBean updateSubjectsBudget(CostBudgetSubjectsUpDTO model);

    ResultBean<PageDTO<CostBudgetSubjectsRSDTO>> getSubjectsBudgetList(CostBudgetSubjectsRQDTO model);

    ResultBean deleteSubjectsBudgetBatch(List<Integer> ids);



    ResultBean<List<CostBudgetSubjectsTypeRSDTO>> getCurUserSubjectsTypeList();

    ResultBean<List<CostBudgetSubjectsRSDTO>> getCurUserSubjectsBudgetList( String subjectType);


    /***
     * 获取当前科目 当前用户部门 的预算余额
     * @param subjectId
     * @param subjectName
     * @return
     */
    BizSubjectsBalance getCurUserSubjectsBudget(Integer subjectId, String subjectName);

    /***
     * 获取固定用户固定科目的预算余额
     * @param subjectId
     * @param subjectName
     * @return
     */
    BizSubjectsBalance getSubjectsBudgetByUserId(Integer userId,Integer subjectId, String subjectName);

    ResultBean<CostBudgetSubjectsRSDTO> getCurUserClfSubjectsBudget();
}
