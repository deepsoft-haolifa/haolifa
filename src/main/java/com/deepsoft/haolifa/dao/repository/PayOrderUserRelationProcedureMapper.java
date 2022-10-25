package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedure;
import com.deepsoft.haolifa.model.domain.PayOrderUserRelationProcedureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOrderUserRelationProcedureMapper {
    int countByExample(PayOrderUserRelationProcedureExample example);

    int deleteByExample(PayOrderUserRelationProcedureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayOrderUserRelationProcedure record);

    int insertSelective(PayOrderUserRelationProcedure record);

    List<PayOrderUserRelationProcedure> selectByExample(PayOrderUserRelationProcedureExample example);

    PayOrderUserRelationProcedure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayOrderUserRelationProcedure record, @Param("example") PayOrderUserRelationProcedureExample example);

    int updateByExample(@Param("record") PayOrderUserRelationProcedure record, @Param("example") PayOrderUserRelationProcedureExample example);

    int updateByPrimaryKeySelective(PayOrderUserRelationProcedure record);

    int updateByPrimaryKey(PayOrderUserRelationProcedure record);
}