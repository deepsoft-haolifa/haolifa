package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.domain.BizBankBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizBankBillMapper {
    int countByExample(BizBankBillExample example);

    int deleteByExample(BizBankBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizBankBill record);

    int insertSelective(BizBankBill record);

    List<BizBankBill> selectByExample(BizBankBillExample example);

    BizBankBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizBankBill record, @Param("example") BizBankBillExample example);

    int updateByExample(@Param("record") BizBankBill record, @Param("example") BizBankBillExample example);

    int updateByPrimaryKeySelective(BizBankBill record);

    int updateByPrimaryKey(BizBankBill record);
}