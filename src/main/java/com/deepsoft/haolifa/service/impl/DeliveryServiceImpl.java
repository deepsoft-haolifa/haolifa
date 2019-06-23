package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.DELIVERY_NO_KEY;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.DELIVERY_NO_PREFIX_FHTZD;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.CommonEnum.DeliverStatus;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.DeliveryNoticeMapper;
import com.deepsoft.haolifa.dao.repository.DeliveryRecordMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductAssociateMapper;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.extend.DeliveryNoticeExtendMapper;
import com.deepsoft.haolifa.model.domain.DeliveryNotice;
import com.deepsoft.haolifa.model.domain.DeliveryNoticeExample;
import com.deepsoft.haolifa.model.domain.DeliveryRecord;
import com.deepsoft.haolifa.model.domain.DeliveryRecordExample;
import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import com.deepsoft.haolifa.model.domain.OrderProductAssociateExample;
import com.deepsoft.haolifa.model.domain.OrderProductExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryNoticeConditionDTO;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryNoticeListDTO;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryRecordConditionDTO;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryClassifyDTO;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryNoticeAuditDTO;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.service.DeliveryService;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class DeliveryServiceImpl extends BaseService implements DeliveryService {

  @Autowired
  private DeliveryRecordMapper deliveryRecordMapper;
  @Autowired
  private DeliveryNoticeMapper deliveryNoticeMapper;
  @Autowired
  private OrderProductAssociateMapper orderProductAssociateMapper;
  @Autowired
  private OrderProductService orderProductService;
  @Autowired
  private DeliveryNoticeExtendMapper deliveryNoticeExtendMapper;

  @Override
  public ResultBean saveNotice(DeliveryNotice model) {
    int insertUpdate = 0;
    OrderProductDTO orderProductDTO = orderProductService.getOrderProductInfo(model.getContractOrderNo());
    if (orderProductDTO == null) {
      return ResultBean.error(ResponseEnum.DELIVERY_ORDERNO_NOT_EXIST);
    }
    if (model.getId() != null && model.getId() > 0) {
      insertUpdate = deliveryNoticeMapper.updateByPrimaryKeySelective(model);
    } else {
      model.setCreateUserId(getLoginUserId());
      String deliveryNo = createSerialNumber(DELIVERY_NO_PREFIX_FHTZD, DELIVERY_NO_KEY);
      model.setDeliveryNo(deliveryNo);
      insertUpdate = deliveryNoticeMapper.insertSelective(model);
    }
    if (insertUpdate > 0) {
      return ResultBean.success(insertUpdate);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }

  @Override
  public DeliveryNotice noticeInfo(int id) {
    return deliveryNoticeMapper.selectByPrimaryKey(id);
  }

  @Override
  public ResultBean pageNotices(DeliveryNoticeConditionDTO conditionDTO) {
    Page<DeliveryNoticeListDTO> deliveryRecordPage = PageHelper
        .startPage(conditionDTO.getPageNum(), conditionDTO.getPageSize())
        .doSelectPage(() -> deliveryNoticeExtendMapper.selectDeliverNoticeList(conditionDTO));

    PageDTO<DeliveryNoticeListDTO> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(deliveryRecordPage, pageDTO);
    pageDTO.setList(deliveryRecordPage.getResult());

    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean auditNotice(DeliveryNoticeAuditDTO model) {
    if (StringUtils.isBlank(model.getDeliveryNo())) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    int update = deliveryNoticeMapper.updateByExampleSelective(new DeliveryNotice() {{
      setAuditInfo(model.getAuditInfo());
      setAuditResult(model.getAuditResult());
      setAuditTime(new Date());
      setAuditUserId(getLoginUserId());
    }}, new DeliveryNoticeExample() {{
      or().andDeliveryNoEqualTo(model.getDeliveryNo());
    }});
    if (update > 0) {
      return ResultBean.success(update);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }
  }

  @Override
  public ResultBean save(DeliveryRecord model) {
    model.setCreateUserId(getLoginUserId());
    int insert = deliveryRecordMapper.insertSelective(model);
    if (insert > 0) {
      // 更新 订单发货状态
      DeliveryRecordExample recordExample = new DeliveryRecordExample();
      recordExample.createCriteria().andContractOrderNoEqualTo(model.getContractOrderNo());
      List<DeliveryRecord> records = deliveryRecordMapper.selectByExample(recordExample);
      int count = records.stream().map(DeliveryRecord::getProductCount).reduce(0, (a, b) -> a + b);
      OrderProductAssociateExample associateExample = new OrderProductAssociateExample();
      associateExample.createCriteria().andOrderNoEqualTo(model.getContractOrderNo());
      List<OrderProductAssociate> orderProducts = orderProductAssociateMapper.selectByExample(associateExample);
      int productCount = orderProducts.stream().map(OrderProductAssociate::getProductNumber).reduce(0, (a, b) -> a + b);
      if (!CollectionUtils.isEmpty(orderProducts)) {
        if (count > 0 && count < productCount) {
          // 部分发货
          orderProductService
              .updateOrderDeliverStatus(model.getContractOrderNo(), DeliverStatus.DELIVER_PART_1.getCode());
        } else if (count >= productCount) {
          // 全部发货
          orderProductService
              .updateOrderDeliverStatus(model.getContractOrderNo(), DeliverStatus.DELIVER_COMPLETE_2.getCode());
        }
      }
      return ResultBean.success(insert);
    } else {
      return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
    }

  }

  @Override
  public DeliveryRecord getInfo(int id) {
    if (id <= 0) {
      log.error("get delivery record param error");
      return null;
    }
    return deliveryRecordMapper.selectByPrimaryKey(id);
  }

  @Override
  public ResultBean delete(Integer id) {
    if (id <= 0) {
      log.error("delete delivery record param error");
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    return ResultBean.success(deliveryRecordMapper.deleteByPrimaryKey(id));
  }

  @Override
  public ResultBean update(DeliveryRecord model) {
    return ResultBean.success(deliveryRecordMapper.updateByPrimaryKeySelective(model));
  }

  @Override
  public ResultBean pageInfo(DeliveryRecordConditionDTO conditionDTO) {
    DeliveryRecordExample example = new DeliveryRecordExample();
    DeliveryRecordExample.Criteria criteria = example.createCriteria();
    if (StringUtils.isNotBlank(conditionDTO.getContractOrderNo())) {
      criteria.andContractOrderNoLike("%" + conditionDTO.getContractOrderNo() + "%");
    }
    if (StringUtils.isNotBlank(conditionDTO.getCourierNo())) {
      criteria.andCourierNoLike("%" + conditionDTO.getCourierNo() + "%");
    }
    if (StringUtils.isNotBlank(conditionDTO.getCustomerNo())) {
      criteria.andCustomerNoLike("%" + conditionDTO.getCustomerNo() + "%");
    }
    if (StringUtils.isNotBlank(conditionDTO.getTransportCompany())) {
      criteria.andTransportCompanyLike("%" + conditionDTO.getTransportCompany() + "%");
    }
    if (conditionDTO.getDeliveryClassify() > 0) {
      criteria.andDeliveryClassifyEqualTo(conditionDTO.getDeliveryClassify());
    }
    Date startDeliveryTime = conditionDTO.getStartDeliveryTime();
    Date endDeliveryTime = conditionDTO.getEndDeliveryTime();
    if (startDeliveryTime != null && endDeliveryTime != null) {
      criteria.andDeliveryTimeBetween(startDeliveryTime, endDeliveryTime);
    }
    if (startDeliveryTime != null && endDeliveryTime == null) {
      criteria.andDeliveryTimeGreaterThanOrEqualTo(startDeliveryTime);
    }
    if (startDeliveryTime == null && endDeliveryTime != null) {
      criteria.andDeliveryTimeLessThanOrEqualTo(endDeliveryTime);
    }
    example.setOrderByClause("id desc");
    Page<DeliveryRecord> deliveryRecordPage = PageHelper
        .startPage(conditionDTO.getPageNum(), conditionDTO.getPageSize())
        .doSelectPage(() -> deliveryRecordMapper.selectByExample(example));

    PageDTO<DeliveryRecord> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(deliveryRecordPage, pageDTO);
    pageDTO.setList(deliveryRecordPage);
    return ResultBean.success(pageDTO);
  }


  @Override
  public List<DeliveryClassifyDTO> getClassifyList() {
    List<DeliveryClassifyDTO> list = new ArrayList<>();
    CommonEnum.DeliveryClassify[] values = CommonEnum.DeliveryClassify.values();
    Arrays.asList(values).forEach(e -> {
      DeliveryClassifyDTO deliveryClassifyDTO = new DeliveryClassifyDTO() {{
        setCode(e.code);
        setName(e.msg);
      }};
      list.add(deliveryClassifyDTO);
    });
    return list;
  }

}
