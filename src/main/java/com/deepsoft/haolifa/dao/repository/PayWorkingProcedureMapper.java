package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayWorkingProcedure;
import com.deepsoft.haolifa.model.domain.PayWorkingProcedureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayWorkingProcedureMapper {
    int countByExample(PayWorkingProcedureExample example);

    int deleteByExample(PayWorkingProcedureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayWorkingProcedure record);

    int insertSelective(PayWorkingProcedure record);

    List<PayWorkingProcedure> selectByExample(PayWorkingProcedureExample example);

    PayWorkingProcedure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayWorkingProcedure record, @Param("example") PayWorkingProcedureExample example);

    int updateByExample(@Param("record") PayWorkingProcedure record, @Param("example") PayWorkingProcedureExample example);

    int updateByPrimaryKeySelective(PayWorkingProcedure record);

    int updateByPrimaryKey(PayWorkingProcedure record);
}