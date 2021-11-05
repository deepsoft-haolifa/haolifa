package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjectsExample;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectsMapper {
    long countByExample(BizSubjectsExample example);

    int deleteByExample(BizSubjectsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizSubjects record);

    int insertSelective(BizSubjects record);

    List<BizSubjects> selectByExample(BizSubjectsExample example);

    BizSubjects selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDepartment record, @Param("example") BizSubjectsExample example);

    int updateByExample(@Param("record") SysDepartment record, @Param("example") BizSubjectsExample example);

    int updateByPrimaryKeySelective(BizSubjects record);

    int updateByPrimaryKey(BizSubjects record);
}
