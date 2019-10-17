package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ExpensesService {

  ResultBean save(ExpensesDTO model);

  ResultBean delete(Integer id);

  ResultBean update(ExpensesDTO model);

  ResultBean getList(Integer pageNum, Integer pageSize, String classifyName, String secondClassifyName,
      String department, String voucherNo);

  ResultBean classify(Integer pId);

  ResultBean info(Integer id);
  //获取费用统计表，每个费用类别每个月的开支
  ResultBean getClassify();
  ResultBean classifyByDepartment();
  //获取费用统计表
  ResultBean getAllClassify();
//查询部门费用总计
  ResultBean classifyByDepartmentAll();
  ResultBean getAllClassifyWithDepartment(String department);
  ResultBean getAllClassifyWithFirstClassify(String classify);
}
