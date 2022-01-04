package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizBill;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillRQDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.bill.BizBillUpDTO;

public interface BillService {
    /**
     * 添加
     * @param model
     * @return
     */
    ResultBean save(BizBillAddDTO model);


    /**
     * 删除
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新
     * @param model
     * @return
     */
    ResultBean update(BizBillUpDTO model);

    /**
     * 获取详情
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     * @param model
     * @return
     */
    ResultBean<BizBillRSDTO> getList(BizBillRQDTO model);


    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    ResultBean getBillContractDetailByBillId(int id);
}
