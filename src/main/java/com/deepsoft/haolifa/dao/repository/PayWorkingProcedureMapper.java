package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayWorkingProcedure;
import com.deepsoft.haolifa.model.domain.PayWorkingProcedureExample;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayWorkingProcedureMapper {
    int countByExample(PayWorkingProcedureExample example);

    int deleteByExample(PayWorkingProcedureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayWorkingProcedure record);

    int insertSelective(PayWorkingProcedure record);

    List<PayWorkingProcedure> selectByExample(PayWorkingProcedureExample example);

    List<PayWorkingProcedure> selectList(PayWorkingProcedureDTO example);

    PayWorkingProcedure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayWorkingProcedure record, @Param("example") PayWorkingProcedureExample example);

    int updateByExample(@Param("record") PayWorkingProcedure record, @Param("example") PayWorkingProcedureExample example);

    int updateByPrimaryKeySelective(PayWorkingProcedure record);

    int updateByPrimaryKey(PayWorkingProcedure record);
}
