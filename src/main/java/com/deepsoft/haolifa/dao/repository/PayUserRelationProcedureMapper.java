package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayUserRelationProcedure;
import com.deepsoft.haolifa.model.domain.PayUserRelationProcedureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayUserRelationProcedureMapper {
    int countByExample(PayUserRelationProcedureExample example);

    int deleteByExample(PayUserRelationProcedureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayUserRelationProcedure record);

    int insertSelective(PayUserRelationProcedure record);

    List<PayUserRelationProcedure> selectByExample(PayUserRelationProcedureExample example);

    PayUserRelationProcedure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayUserRelationProcedure record, @Param("example") PayUserRelationProcedureExample example);

    int updateByExample(@Param("record") PayUserRelationProcedure record, @Param("example") PayUserRelationProcedureExample example);

    int updateByPrimaryKeySelective(PayUserRelationProcedure record);

    int updateByPrimaryKey(PayUserRelationProcedure record);
}