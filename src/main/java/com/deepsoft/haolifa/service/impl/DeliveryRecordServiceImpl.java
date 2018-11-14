package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.DeliveryRecordMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductAssociateMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.DeliveryRecordDTO;
import com.deepsoft.haolifa.model.dto.OrderProductAssociateDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.DeliveryRecordService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DeliveryRecordServiceImpl extends BaseService implements DeliveryRecordService {

    @Autowired
    private DeliveryRecordMapper deliveryRecordMapper;
    @Autowired
    private OrderProductAssociateMapper orderProductAssociateMapper;
    @Autowired
    private OrderProductService orderProductService;

    @Override
    public ResultBean save(DeliveryRecordDTO model) {
        DeliveryRecord deliveryRecord = new DeliveryRecord();
        BeanUtils.copyProperties(model, model);
        deliveryRecord.setCreateUserId(getLoginUserId());
        deliveryRecord.setDeliveryNo("dr_" + RandomUtils.orderNoStr());
        int insert = deliveryRecordMapper.insertSelective(deliveryRecord);
        if (insert > 0) {
            Map<String, Object> result = new HashMap<>(3);
            result.put("formId", deliveryRecord.getId());
            result.put("formNo", deliveryRecord.getOrderNo());
            result.put("formType", CommonEnum.FormType.DELIVER_TYPE.code);
            return ResultBean.success(result);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }

    }

    @Override
    public DeliveryRecordDTO getInfo(String deliveryNo, String orderNo) {
        DeliveryRecordDTO deliveryRecordDTO = new DeliveryRecordDTO();
        if (StringUtils.isAnyBlank(deliveryNo, orderNo)) {
            log.error("get delivery record param error");
            return null;
        }
        //从订单产品关联表读取信息
        List<OrderProductAssociate> orderProductAssociates = orderProductAssociateMapper.selectByExample(new OrderProductAssociateExample() {{
            or().andOrderNoEqualTo(orderNo);
        }});
        List<OrderProductAssociateDTO> list = new ArrayList<>();
        orderProductAssociates.stream().forEach(e -> {
            OrderProductAssociateDTO orderProductAssociateDTO = new OrderProductAssociateDTO();
            BeanUtils.copyProperties(e, orderProductAssociateDTO);
            list.add(orderProductAssociateDTO);
        });

        DeliveryRecordExample example = new DeliveryRecordExample();
        DeliveryRecordExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(deliveryNo)) {
            criteria.andDeliveryNoEqualTo(deliveryNo);
        }
        if (StringUtils.isNotBlank(orderNo)) {
            criteria.andOrderNoEqualTo(orderNo);
        }
        List<DeliveryRecord> deliveryRecords = deliveryRecordMapper.selectByExample(example);
        if (deliveryRecords.size() > 0) {
            DeliveryRecord deliveryRecord = deliveryRecords.get(0);

            deliveryRecordDTO.setProductList(list);
            BeanUtils.copyProperties(deliveryRecord, deliveryRecordDTO);
        } else {
            // 如果发货记录表没有，根据订单no从订单表中查询记录
            if (StringUtils.isNotBlank(orderNo)) {
                OrderProduct orderProductInfo = orderProductService.getOrderProductInfo(orderNo);
                BeanUtils.copyProperties(orderProductInfo, deliveryRecordDTO);
                deliveryRecordDTO.setProductList(list);
                // 需要解析下订单表的发货信息
                deliveryRecordDTO.setCollectAddress("");
                deliveryRecordDTO.setCollectPhone("");
                deliveryRecordDTO.setCollectName("");
            }
        }
        return deliveryRecordDTO;
    }

    @Override
    public ResultBean delete(Integer id) {
        return null;
    }

    @Override
    public ResultBean update(DeliveryRecordDTO model) {
        return null;
    }

    @Override
    public ResultBean getList(DeliveryRecordDTO modelList) {
        return null;
    }

}
