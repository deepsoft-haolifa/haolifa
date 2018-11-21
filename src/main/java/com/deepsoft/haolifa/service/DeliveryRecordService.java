package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.DeliveryRecordDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface DeliveryRecordService {
    /**
     * 添加发货单
     *
     * @param model
     * @return
     */
    ResultBean save(DeliveryRecordDTO model);

    /**
     * 获取发货单信息
     *
     * @param deliveryNo 发货单号
     * @param orderNo    订单号
     * @return
     */
    DeliveryRecordDTO getInfo(String deliveryNo, String orderNo);

    /**
     * 删除发货单
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新发货单
     *
     * @param model
     * @return
     */
    ResultBean update(DeliveryRecordDTO model);

    /**
     * 获取发货单列表
     *
     * @param modelList
     * @return
     */
    ResultBean getList(DeliveryRecordDTO modelList);

}
