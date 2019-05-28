package com.deepsoft.haolifa.model.dto.delivery;

import com.deepsoft.haolifa.model.domain.DeliveryNotice;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class DeliveryNoticeListDTO extends DeliveryNotice {

  public DeliveryNoticeListDTO(Integer id, Date createTime, Date updateTime,
      Integer createUserId, String deliveryUrl, String contractOrderNo, String deliveryNo, Integer auditUserId,
      String auditInfo, Date auditTime, Byte auditResult, Byte deliverStatus) {
    super(id, createTime, updateTime, createUserId, deliveryUrl, contractOrderNo, deliveryNo, auditUserId, auditInfo,
        auditTime, auditResult);
    this.deliverStatus = deliverStatus;
  }

  private Byte deliverStatus;

}
