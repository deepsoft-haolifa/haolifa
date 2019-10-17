package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.Expenses;
import com.deepsoft.haolifa.model.domain.ExpensesExample;
import java.util.List;

import com.deepsoft.haolifa.model.domain.ExpensesReport;
import org.apache.ibatis.annotations.Param;

public interface ExpensesMapper {
    int countByExample(ExpensesExample example);

    int deleteByExample(ExpensesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Expenses record);

    int insertSelective(Expenses record);

    List<Expenses> selectByExample(ExpensesExample example);

    Expenses selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Expenses record, @Param("example") ExpensesExample example);

    int updateByExample(@Param("record") Expenses record, @Param("example") ExpensesExample example);

    int updateByPrimaryKeySelective(Expenses record);

    int updateByPrimaryKey(Expenses record);
    List<ExpensesReport> getClassify();
    List<ExpensesReport> classifyByDepartment();
    List<ExpensesReport> classifyBySecondDepartment();
    List<ExpensesReport> getAllClassify();
    List<ExpensesReport> classifyByDepartmentAll();
    List<ExpensesReport> getAllClassifyWithDepartment(String department);
    List<ExpensesReport> getAllClassifyWithFirstClassify(String classify);
}