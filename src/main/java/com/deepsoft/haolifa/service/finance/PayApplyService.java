package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizPayApply;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayApplyRSDTO;

public interface PayApplyService {

    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(PayApplyAddDTO model);


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
    ResultBean update(BizPayApply model);

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
    ResultBean<PayApplyRSDTO> getList(PayApplyRQDTO model);

    /**
     * 付款申请-发起审批
     *
     * @param id
     * @return
     */
    ResultBean approve(Integer id);
}
