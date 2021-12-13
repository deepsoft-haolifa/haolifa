package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizOtherBill;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillDTO;

public interface OtherBillService {
    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(BizOtherBillAddDTO model);


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
    ResultBean update(BizOtherBill model);

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
    ResultBean getList(BizOtherBillDTO model);


}
