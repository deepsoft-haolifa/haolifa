package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizSubjects;
import com.deepsoft.haolifa.model.domain.BizSubjectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizSubjectsMapper {
    int countByExample(BizSubjectsExample example);

    int deleteByExample(BizSubjectsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizSubjects record);

    int insertSelective(BizSubjects record);

    List<BizSubjects> selectByExample(BizSubjectsExample example);

    BizSubjects selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizSubjects record, @Param("example") BizSubjectsExample example);

    int updateByExample(@Param("record") BizSubjects record, @Param("example") BizSubjectsExample example);

    int updateByPrimaryKeySelective(BizSubjects record);

    int updateByPrimaryKey(BizSubjects record);
}