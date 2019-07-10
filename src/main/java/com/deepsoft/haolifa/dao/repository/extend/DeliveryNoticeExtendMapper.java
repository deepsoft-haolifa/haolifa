package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.delivery.DeliveryNoticeConditionDTO;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryNoticeListDTO;
import java.util.List;

public interface DeliveryNoticeExtendMapper {

  List<DeliveryNoticeListDTO> selectDeliverNoticeList(DeliveryNoticeConditionDTO deliveryNoticeConditionDTO);

}
