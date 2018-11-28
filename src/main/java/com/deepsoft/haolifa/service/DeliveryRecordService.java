package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.DeliveryRecord;
import com.deepsoft.haolifa.model.dto.DeliveryClassifyDTO;
import com.deepsoft.haolifa.model.dto.DeliveryRecordConditionDTO;
import com.deepsoft.haolifa.model.dto.DeliveryRecordDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

public interface DeliveryRecordService {
    /**
     * 添加发货单
     *
     * @param model
     * @return
     */
    ResultBean save(DeliveryRecord model);

    /**
     * 获取发货单信息
     *
     * @param id
     * @return
     */
    DeliveryRecord getInfo(int id);

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
    ResultBean update(DeliveryRecord model);

    /**
     * 获取发货单列表
     *
     * @return
     */
    ResultBean pageInfo(DeliveryRecordConditionDTO conditionDTO);


    /**
     * 获取发货类型列表
     *
     * @return
     */
    List<DeliveryClassifyDTO> getClassifyList();

}
