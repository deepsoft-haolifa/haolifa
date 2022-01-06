package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizOtherBill;
import com.deepsoft.haolifa.model.domain.BizOtherBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizOtherBillMapper {
    int countByExample(BizOtherBillExample example);

    int deleteByExample(BizOtherBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BizOtherBill record);

    int insertSelective(BizOtherBill record);

    List<BizOtherBill> selectByExample(BizOtherBillExample example);

    BizOtherBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BizOtherBill record, @Param("example") BizOtherBillExample example);

    int updateByExample(@Param("record") BizOtherBill record, @Param("example") BizOtherBillExample example);

    int updateByPrimaryKeySelective(BizOtherBill record);

    int updateByPrimaryKey(BizOtherBill record);

    BizOtherBill getLastRecord(@Param("companyQuery") String companyQuery, @Param("accountQuery") String accountQuery);

}
