package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ExpensesService {

  ResultBean save(ExpensesDTO model);

  ResultBean delete(Integer id);

  ResultBean update(ExpensesDTO model);

  ResultBean getList(Integer pageNum, Integer pageSize, String classifyName, String secondClassifyName,
      String department, String voucherNo,String year,String month);

  ResultBean classify(Integer pId);

  ResultBean info(Integer id);
  //获取费用统计表，每个费用类别每个月的开支
  ResultBean getClassify(String expensesClassify);

  ResultBean classifyByDepartment();
  //获取费用统计表
  ResultBean getAllClassify(String year,String month);
//查询部门费用总计
  ResultBean classifyByDepartmentAll(String year,String month,String endYear,String endMonth);
  ResultBean getAllClassifyWithDepartment(String department,String year, String month);
  //获取一级部门每月的费用支出
  ResultBean getMonthByDepartment(String department);
  ResultBean getAllClassifyWithFirstClassify(String classify);

    //获取费用统计表，每个月统计
    ResultBean expenseTotalByMonth(String year);
}
