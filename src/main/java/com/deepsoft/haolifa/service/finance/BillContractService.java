package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizBillContract;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
 import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractAddOrUpDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractAuditDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRQDTO;
import com.deepsoft.haolifa.model.dto.finance.billcontract.BillContractRSDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRSDTO;

import java.util.List;

public interface BillContractService {

    ResultBean<PageDTO<ContractBillRSDTO>> getBillContractList(ContractBillRQDTO billDTO);

    ResultBean<PageDTO<ContractListRSDTO>> orderContractList(ContractListRQDTO contractListRQDTO);

    ResultBean<PageDTO<BillContractRSDTO>> selectBizBillContractList(BillContractRQDTO bizBillContract);

    ResultBean addOrUpContract(BillContractAddOrUpDTO billContract);

    ResultBean removeContract(int id);

    ResultBean auditContract(BillContractAuditDTO billContract);
}
