package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizOtherBill;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillAddDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillRSDTO;
import com.deepsoft.haolifa.model.dto.finance.otherbill.BizOtherBillUpDTO;

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

    public ResultBean savePreMonthMoney();
    /**
     * 更新
     *
     * @param otherBillUpDTO
     * @return
     */
    ResultBean update(BizOtherBillUpDTO otherBillUpDTO);

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
    ResultBean<PageDTO<BizOtherBillRSDTO>> getList(BizOtherBillDTO model);


}
