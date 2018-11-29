package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.DeliveryNotice;
import com.deepsoft.haolifa.model.domain.DeliveryRecord;
import com.deepsoft.haolifa.model.dto.*;

import java.util.List;

public interface DeliveryService {

    /**
     * 上传发货通知单
     *
     * @param model
     * @return
     */
    ResultBean saveNotice(DeliveryNotice model);

    /**
     * 获取发货通知单详情
     *
     * @param id
     * @return
     */
    DeliveryNotice noticeInfo(int id);

    /**
     * 获取发货通知单列表
     *
     * @param model
     * @return
     */
    ResultBean pageNotices(DeliveryNoticeConditionDTO model);

    /**
     * 财务审核发货通知单
     *
     * @param model
     * @return
     */
    ResultBean auditNotice(DeliveryNoticeAuditDTO model);

    /**
     * 添加发货单记录
     *
     * @param model
     * @return
     */
    ResultBean save(DeliveryRecord model);

    /**
     * 获取发货单记录信息
     *
     * @param id
     * @return
     */
    DeliveryRecord getInfo(int id);

    /**
     * 删除发货单记录
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新发货单记录
     *
     * @param model
     * @return
     */
    ResultBean update(DeliveryRecord model);

    /**
     * 获取发货单记录列表
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
