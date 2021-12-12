package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayAppAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payapp.PayAppDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanAddDTO;
import com.deepsoft.haolifa.model.dto.finance.payplan.BizPayPlanDTO;

public interface PayPlanService {

    /**
     * 添加-付款申请
     *
     * @param model
     * @return
     */
    ResultBean savePayApp(PayAppAddDTO model);

    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(BizPayPlanAddDTO model);


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
    ResultBean update(BizPayPlan model);

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
    ResultBean getPayAppDTOList(PayAppDTO model);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean getList(BizPayPlanDTO model);

    /**
     * 付款申请-发起审批
     *
     * @param id
     * @return
     */
    ResultBean approve(Integer id);
}