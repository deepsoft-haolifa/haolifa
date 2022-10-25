package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.ExpensesReport;
import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ExpensesService {

  ResultBean save(ExpensesDTO model);

  ResultBean delete(Integer id);

  ResultBean update(ExpensesDTO model);

  ResultBean getList(ExpensesConditionDTO expensesDTO);
  BigDecimal listSummary(ExpensesConditionDTO expensesDTO);

  ResultBean classify(Integer pId);

  ResultBean info(Integer id);
  //获取费用统计表，每个费用类别每个月的开支
  ResultBean getClassify(String expensesClassify);

  ResultBean classifyByDepartment();
  //获取费用统计表
  ResultBean getAllClassify(ExpensesConditionDTO expensesConditionDTO);
//查询部门费用总计
  ResultBean classifyByDepartmentAll(ExpensesConditionDTO expensesConditionDTO);
  ResultBean getAllClassifyWithDepartment(ExpensesConditionDTO expensesConditionDTO);
  //获取一级部门每月的费用支出
  ResultBean getMonthByDepartment(String department);
  ResultBean getAllClassifyWithFirstClassify(String classify);

    //获取费用统计表，每个月统计
    ResultBean expenseTotalByMonth(String year);

    //成本质量费用，按月统计
    List<ExpensesReport> qualityExpenseTotalByMonth(String year);
    //成本财务费用，按月统计
    List<ExpensesReport> financeExpenseTotalByMonth(String year);
    //成本材料，按月统计
    List<ExpensesReport> costMaterialByMonth(String year);
}
