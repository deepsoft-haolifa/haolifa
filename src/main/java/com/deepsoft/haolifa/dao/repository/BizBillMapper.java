package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizBill;
import com.deepsoft.haolifa.model.domain.BizBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizBillMapper {
    int countByExample(BizBillExample example);

    int deleteByExample(BizBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizBill record);

    int insertSelective(BizBill record);

    List<BizBill> selectByExample(BizBillExample example);

    BizBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizBill record, @Param("example") BizBillExample example);

    int updateByExample(@Param("record") BizBill record, @Param("example") BizBillExample example);

    int updateByPrimaryKeySelective(BizBill record);

    int updateByPrimaryKey(BizBill record);

    BizBill getLastRecord();
}
