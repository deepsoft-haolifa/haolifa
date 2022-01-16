package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.domain.BizBankBillExample;
import java.util.List;

import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillUpRQDTO;
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

    BizBankBill getLastRecord(@Param("companyQuery") String companyQuery, @Param("accountQuery") String accountQuery);

    List<ContractBillRSDTO> getBillContractList(ContractBillRQDTO billDTO);

    ContractBillRSDTO getBillContractById(@Param("id") Integer id, @Param("billType") String billType);


    int updateStatusBy( @Param("contractBillUp") ContractBillUpRQDTO contractBillUp);

}
