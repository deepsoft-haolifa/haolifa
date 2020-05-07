package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.ExpensesReport;

import java.util.List;
import java.util.Map;

/**
 * 通用Mapper
 *
 * @author murphy.he
 **/
public interface ExpensesExtendMapper {

    List<ExpensesReport> getClassify(String expensesClassify);
    List<ExpensesReport> classifyByDepartment();
    List<ExpensesReport> classifyBySecondDepartment();
    List<ExpensesReport> getAllClassify(Map<String, String> paramMap);
    List<ExpensesReport> classifyByDepartmentAll(Map<String, String> paramMap);
    List<ExpensesReport> getAllClassifyWithDepartment(Map<String, String> paramMap);
    List<ExpensesReport> getAllClassifyWithFirstClassify(String classify);
    List<ExpensesReport> getMonthByDepartment(String department);
    List<ExpensesReport> expenseTotalByMonth(Map<String, String> paramMap);
}
