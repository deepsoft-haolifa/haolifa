package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.DeliveryNotice;
import com.deepsoft.haolifa.model.domain.DeliveryRecord;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.condition.DeliveryNoticeConditionDTO;
import com.deepsoft.haolifa.model.dto.condition.DeliveryRecordConditionDTO;

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
     * 添加发货单记录 {
     *   "collectAddress": "蚌埠市",
     *   "collectName": "李学芸",
     *   "collectPhone": "15955216981",
     *   "collectProvice": "安徽省",
     *   "contractOrderNo": "HS1809039",
     *   "courierNo": "11073759583",
     *   "customerNo": "J119",
     *   "deliveryClassify": 1,
     *   "deliveryNoticeNo": "string",
     *   "deliveryTime": "2018-11-30",
     *   "operationNo": "HS",
     *   "packingMode": "木纸",
     *   "pieceCount": 2,
     *   "pricePiece": 1.5,
     *   "productCount":130,
     *   "remark": "备注",
     *   "settlementWay": "付费送货",
     *   "totalFee":230,
     *   "transportCompany": "百世物流",
     *   "weightPiece": 153
     * }
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
