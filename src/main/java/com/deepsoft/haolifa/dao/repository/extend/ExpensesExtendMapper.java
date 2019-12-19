package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.ExpensesReport;

import java.util.List;

/**
 * 通用Mapper
 *
 * @author murphy.he
 **/
public interface ExpensesExtendMapper {

    List<ExpensesReport> getClassify();
    List<ExpensesReport> classifyByDepartment();
    List<ExpensesReport> classifyBySecondDepartment();
    List<ExpensesReport> getAllClassify();
    List<ExpensesReport> classifyByDepartmentAll();
    List<ExpensesReport> getAllClassifyWithDepartment(String department);
    List<ExpensesReport> getAllClassifyWithFirstClassify(String classify);
}
