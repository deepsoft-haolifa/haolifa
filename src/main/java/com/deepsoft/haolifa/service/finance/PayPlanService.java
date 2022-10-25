package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizPayPlan;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.payplan.*;

import java.util.List;

public interface PayPlanService {


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
    ResultBean update(BizPayPlanPayDTO model);

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
    ResultBean<BizPayPlanRSDTO> getList(BizPayPlanRQDTO model);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean<PageDTO<BizPayPlanSummaryRSDTO>> getPayPlanSummaryList(BizPayPlanSummaryRQDTO  model);

    ResultBean<List<BookingTypeRSDTO>> getAllPayWayList();

    /**
     * 付款计划（确认）
     */
    ResultBean updateDateStatus(List<Integer> ids);
}
