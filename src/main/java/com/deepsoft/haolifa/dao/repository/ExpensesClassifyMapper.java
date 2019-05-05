package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.ExpensesClassify;
import com.deepsoft.haolifa.model.domain.ExpensesClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpensesClassifyMapper {
    int countByExample(ExpensesClassifyExample example);

    int deleteByExample(ExpensesClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpensesClassify record);

    int insertSelective(ExpensesClassify record);

    List<ExpensesClassify> selectByExample(ExpensesClassifyExample example);

    ExpensesClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpensesClassify record, @Param("example") ExpensesClassifyExample example);

    int updateByExample(@Param("record") ExpensesClassify record, @Param("example") ExpensesClassifyExample example);

    int updateByPrimaryKeySelective(ExpensesClassify record);

    int updateByPrimaryKey(ExpensesClassify record);
}