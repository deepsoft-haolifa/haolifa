package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizBill;
import com.deepsoft.haolifa.model.domain.BizBillExample;
import com.deepsoft.haolifa.model.domain.SysDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {
    long countByExample(BizBillExample example);

    int deleteByExample(BizBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizBill record);

    int insertSelective(BizBill record);

    List<BizBill> selectByExample(BizBillExample example);

    BizBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDepartment record, @Param("example") BizBillExample example);

    int updateByExample(@Param("record") SysDepartment record, @Param("example") BizBillExample example);

    int updateByPrimaryKeySelective(BizBill record);

    int updateByPrimaryKey(BizBill record);
}
