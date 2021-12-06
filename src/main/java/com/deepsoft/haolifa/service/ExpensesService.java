package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;

public interface ExpensesService {

  ResultBean save(ExpensesDTO model);

  ResultBean delete(Integer id);

  ResultBean update(ExpensesDTO model);

  ResultBean getList(Integer pageNum, Integer pageSize, ExpensesConditionDTO expensesDTO);
  String listSummary(ExpensesConditionDTO expensesDTO);

  ResultBean classify(Integer pId);

  ResultBean info(Integer id);
  //获取费用统计表，每个费用类别每个月的开支
  ResultBean getClassify(String expensesClassify);

  ResultBean classifyByDepartment();
  //获取费用统计表
  ResultBean getAllClassify(ReportBaseDTO reportBaseDTO);
//查询部门费用总计
  ResultBean classifyByDepartmentAll(ReportBaseDTO reportBaseDTO);
  ResultBean getAllClassifyWithDepartment(ReportBaseDTO reportBaseDTO);
  //获取一级部门每月的费用支出
  ResultBean getMonthByDepartment(String department);
  ResultBean getAllClassifyWithFirstClassify(String classify);

    //获取费用统计表，每个月统计
    ResultBean expenseTotalByMonth(String year);
}
