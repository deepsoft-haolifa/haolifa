package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.ProInspectRecordMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.BaseException;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectListDTO;
import com.deepsoft.haolifa.model.dto.InspectReason;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectRecordDTO;
import com.deepsoft.haolifa.service.ProInspectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class ProInspectServiceImpl extends BaseService implements ProInspectService {

  @Autowired
  private ProInspectRecordMapper proInspectRecordMapper;
  @Autowired
  private OrderProductMapper orderProductMapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean save(ProInspectRecordDTO model) {
    if (model.getTestingNumber() == 0) {
      return ResultBean.error(ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
    }
    if (model.getUnqualifiedNumber() > 0) {
      if (CollectionUtils.isEmpty(model.getUnqualifiedList())) {
        return ResultBean.error(ResponseEnum.UNQUALIFIED_REASON_IS_EMPTY);
      } else {
        Integer needCount = model.getUnqualifiedList().stream().map(InspectReason::getNumber).reduce(0, (a, b) -> a + b);
        if (needCount != model.getUnqualifiedNumber()) {
          return ResultBean.error(ResponseEnum.UNQUALIFIED_REASON_NUMBER_NO_CONSISTENCY);
        }
      }
    }
    ProInspectRecord proInspectRecord = new ProInspectRecord();
    BeanUtils.copyProperties(model, proInspectRecord);
    proInspectRecord.setCreateUserId(getLoginUserId());
    proInspectRecord.setStorageStatus((byte) 1);
    if(!CollectionUtils.isEmpty(model.getAccessoryList())){
      proInspectRecord.setAccessory(JSON.toJSONString(model.getAccessoryList()));
    }
    proInspectRecord.setReason(JSON.toJSONString(model.getUnqualifiedList()));
    int insert = proInspectRecordMapper.insertSelective(proInspectRecord);
    // 更新成品质检 合格数量
    OrderProductExample orderProductExample = new OrderProductExample() ;
    orderProductExample.createCriteria().andOrderNoEqualTo(proInspectRecord.getOrderNo());
    List<OrderProduct> orderProducts = orderProductMapper.selectByExample(orderProductExample);
    if(!CollectionUtils.isEmpty(orderProducts)) {
      int originalNumber = orderProducts.get(0).getQualifiedNumber();
      int totalCount = orderProducts.get(0).getTotalCount();
      OrderProduct orderProduct = new OrderProduct();
      orderProduct.setQualifiedNumber(originalNumber + proInspectRecord.getQualifiedNumber());
      if(totalCount < orderProduct.getQualifiedNumber()) {
        throw new BaseException(ResponseEnum.ORDER_PRO_INSPECT_NUM_ERROR);
      }
      orderProductMapper.updateByExampleSelective(orderProduct, orderProductExample);
    }
    return ResultBean.success(insert);
  }

  @Override
  public ResultBean update(ProInspectRecordDTO model) {
    if (model.getTestingNumber() == 0) {
      return ResultBean.error(ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
    }
    ProInspectRecord proInspectRecord = new ProInspectRecord();
    BeanUtils.copyProperties(model, proInspectRecord);
    if (model.getUnqualifiedNumber() > 0) {
      if (CollectionUtils.isEmpty(model.getUnqualifiedList())) {
        return ResultBean.error(ResponseEnum.UNQUALIFIED_REASON_IS_EMPTY);
      } else {
        int needCOunt = model.getUnqualifiedList().stream().map(InspectReason::getNumber).reduce(0, (a, b) -> a + b);
        if (needCOunt != model.getUnqualifiedNumber()) {
          ResultBean.error(ResponseEnum.UNQUALIFIED_REASON_NUMBER_NO_CONSISTENCY);
        }
      }
      if(!CollectionUtils.isEmpty(model.getAccessoryList())){
        proInspectRecord.setAccessory(JSON.toJSONString(model.getAccessoryList()));
      }
      proInspectRecord.setReason(JSON.toJSONString(model.getUnqualifiedList()));
    }
    int update = proInspectRecordMapper.updateByPrimaryKeySelective(proInspectRecord);
    return ResultBean.success(update);
  }

  @Override
  public ResultBean delete(Integer id) {
    return ResultBean.success(proInspectRecordMapper.deleteByPrimaryKey(id));
  }

  @Override
  public ResultBean pageInfo(ProInspectConditionDTO model) {
    ProInspectRecordExample example = new ProInspectRecordExample();
    ProInspectRecordExample.Criteria criteria = example.createCriteria();
    if (model.getStorageStatus() != null && model.getStorageStatus() > 0) {
      criteria.andStorageStatusEqualTo(model.getStorageStatus());
    }
    if (StringUtils.isNotBlank(model.getOrderNo())) {
      criteria.andOrderNoEqualTo(model.getOrderNo());
    }
    example.setOrderByClause("id desc");
    Page<ProInspectRecord> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
      proInspectRecordMapper.selectByExample(example);
    });
    PageDTO<ProInspectListDTO> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(pageData, pageDTO);
    List<ProInspectRecord> result = pageData.getResult();
    List<ProInspectListDTO> pageList = new ArrayList<>();
    for (int i = 0; i < result.size(); i++) {
      ProInspectListDTO proInspectListDTO = new ProInspectListDTO();
      BeanUtils.copyProperties(result.get(i), proInspectListDTO);
      if(StringUtils.isNotEmpty(result.get(i).getAccessory())) {
        proInspectListDTO.setAccessoryList(JSON.parseArray(result.get(i).getAccessory(), Accessory.class));
      }
      if (result.get(i).getReason().startsWith("[")) {
        proInspectListDTO.setReasonList(JSON.parseArray(result.get(i).getReason(), InspectReason.class));
      }
      if (CollectionUtils.isEmpty(proInspectListDTO.getReasonList()) && result.get(i).getUnqualifiedNumber() > 0) {
        InspectReason proInspectReason = new InspectReason();
        proInspectReason.setReason(result.get(i).getReason());
        proInspectReason.setNumber(result.get(i).getUnqualifiedNumber());
        proInspectListDTO.setReasonList(Arrays.asList(proInspectReason));
        ProInspectRecord updateReason = new ProInspectRecord();
        updateReason.setReason(JSON.toJSONString(Arrays.asList(proInspectReason)));
        updateReason.setId(result.get(i).getId());
        proInspectRecordMapper.updateByPrimaryKeySelective(updateReason);
      }
      if(CollectionUtils.isEmpty(proInspectListDTO.getReasonList())) {
        proInspectListDTO.setReasonList(new ArrayList<>());
      }
      pageList.add(proInspectListDTO);
    }
    pageDTO.setList(pageList);
    return ResultBean.success(pageDTO);
  }

  @Override
  public int updateStorageStatus(int id, Byte storageStatus) {
    return proInspectRecordMapper.updateByPrimaryKeySelective(new ProInspectRecord() {{
      setStorageStatus(storageStatus);
      setId(id);
    }});
  }
}
