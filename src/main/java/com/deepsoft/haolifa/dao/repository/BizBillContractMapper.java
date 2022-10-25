package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizBillContract;
import com.deepsoft.haolifa.model.domain.BizBillContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizBillContractMapper {
    int countByExample(BizBillContractExample example);

    int deleteByExample(BizBillContractExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizBillContract record);

    int insertSelective(BizBillContract record);

    List<BizBillContract> selectByExample(BizBillContractExample example);

    BizBillContract selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizBillContract record, @Param("example") BizBillContractExample example);

    int updateByExample(@Param("record") BizBillContract record, @Param("example") BizBillContractExample example);

    int updateByPrimaryKeySelective(BizBillContract record);

    int updateByPrimaryKey(BizBillContract record);
}