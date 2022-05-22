package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.ExpensesReport;
import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.expenses.ExpensesConditionDTO;
import com.deepsoft.haolifa.model.dto.report.ReportBaseDTO;

import java.math.BigDecimal;
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
    List<ExpensesReport> getAllClassify(ExpensesConditionDTO expensesConditionDTO);
    List<ExpensesReport> classifyByDepartmentAll(ExpensesConditionDTO expensesConditionDTO);
    List<ExpensesReport> getAllClassifyWithDepartment(ExpensesConditionDTO expensesConditionDTO);
    List<ExpensesReport> getAllClassifyWithFirstClassify(String classify);
    List<ExpensesReport> getMonthByDepartment(String department);
    List<ExpensesReport> expenseTotalByMonth(ExpensesConditionDTO expensesConditionDTO);
    String listSummary(ExpensesConditionDTO expensesDTO);
}
