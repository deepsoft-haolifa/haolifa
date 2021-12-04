package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizBankBill;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bankbill.BizBankBillDTO;

public interface BankBillService {
    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(BizBankBillAddDTO model);


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
    ResultBean update(BizBankBill model);

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
    ResultBean getList(BizBankBillDTO model);

}
