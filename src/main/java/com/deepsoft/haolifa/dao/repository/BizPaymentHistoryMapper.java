package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizPaymentHistory;
import com.deepsoft.haolifa.model.domain.BizPaymentHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizPaymentHistoryMapper {
    int countByExample(BizPaymentHistoryExample example);

    int deleteByExample(BizPaymentHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizPaymentHistory record);

    int insertSelective(BizPaymentHistory record);

    List<BizPaymentHistory> selectByExample(BizPaymentHistoryExample example);

    BizPaymentHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizPaymentHistory record, @Param("example") BizPaymentHistoryExample example);

    int updateByExample(@Param("record") BizPaymentHistory record, @Param("example") BizPaymentHistoryExample example);

    int updateByPrimaryKeySelective(BizPaymentHistory record);

    int updateByPrimaryKey(BizPaymentHistory record);
}