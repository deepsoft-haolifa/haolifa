package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PaymentManagement;
import com.deepsoft.haolifa.model.domain.PaymentManagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentManagementMapper {
    long countByExample(PaymentManagementExample example);

    int deleteByExample(PaymentManagementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaymentManagement record);

    int insertSelective(PaymentManagement record);

    List<PaymentManagement> selectByExample(PaymentManagementExample example);

    PaymentManagement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaymentManagement record, @Param("example") PaymentManagementExample example);

    int updateByExample(@Param("record") PaymentManagement record, @Param("example") PaymentManagementExample example);

    int updateByPrimaryKeySelective(PaymentManagement record);

    int updateByPrimaryKey(PaymentManagement record);
}