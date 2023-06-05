package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.*;
import com.deepsoft.haolifa.model.dto.finance.contract.ContractBillRQDTO;

public interface BankBillService {
    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(BizBankBillAddDTO model);

    public ResultBean savePreMonthMoney();
    /**
     * 删除
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    ResultBean update(BizBankBillUpDTO model);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean<PageDTO<BizBankBillRSDTO>> getList(BizBankBillDTO model);



    ResultBean transfer(BizBankBillTransferDTO model);
}
