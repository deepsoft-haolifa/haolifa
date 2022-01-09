package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractListRQDTO;

public interface BillContractService {

    ResultBean getBillContractList(ContractBillRQDTO billDTO);

    ResultBean contractList(ContractListRQDTO contractListRQDTO);
}
