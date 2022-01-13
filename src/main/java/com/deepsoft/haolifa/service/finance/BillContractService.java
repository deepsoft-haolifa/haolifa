package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizBillContract;
import com.deepsoft.haolifa.model.dto.ResultBean;
 import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractAddOrUpDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRQDTO;

import java.util.List;

public interface BillContractService {

    ResultBean getBillContractList(ContractBillRQDTO billDTO);

    ResultBean orderContractList(ContractListRQDTO contractListRQDTO);

    ResultBean selectBizBillContractList(BillContractRQDTO bizBillContract);

    ResultBean addOrUpContract(BillContractAddOrUpDTO billContract);
}
