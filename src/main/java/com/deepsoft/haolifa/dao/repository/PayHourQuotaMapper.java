package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.PayHourQuota;
import com.deepsoft.haolifa.model.domain.PayHourQuotaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayHourQuotaMapper {
    int countByExample(PayHourQuotaExample example);

    int deleteByExample(PayHourQuotaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayHourQuota record);

    int insertSelective(PayHourQuota record);

    List<PayHourQuota> selectByExample(PayHourQuotaExample example);

    PayHourQuota selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayHourQuota record, @Param("example") PayHourQuotaExample example);

    int updateByExample(@Param("record") PayHourQuota record, @Param("example") PayHourQuotaExample example);

    int updateByPrimaryKeySelective(PayHourQuota record);

    int updateByPrimaryKey(PayHourQuota record);
}