package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.OrderProductMapper;
import com.deepsoft.haolifa.dao.repository.PressureInspectRecordMapper;
import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.domain.OrderProductExample;
import com.deepsoft.haolifa.model.domain.PressureInspectRecord;
import com.deepsoft.haolifa.model.domain.PressureInspectRecordExample;
import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectRecordDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectRecordListDto;
import com.deepsoft.haolifa.service.PressureInspectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class PressureInspectServiceImpl extends BaseService implements PressureInspectService {

  @Autowired
  private PressureInspectRecordMapper pressureInspectRecordMapper;
  @Autowired
  private OrderProductMapper orderProductMapper;


  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean save(PressureInspectRecordDTO model) {
    if (model.getTestingNumber() == 0) {
      return ResultBean.error(ResponseEnum.INSPECT_TESTNUMBER_IS_ZERO);
    }
    PressureInspectRecord pressureInspectRecord = new PressureInspectRecord();
    BeanUtils.copyProperties(model, pressureInspectRecord);
    pressureInspectRecord.setCreateUserId(getLoginUserId());
    if(!CollectionUtils.isEmpty(model.getAccessoryList())) {
      pressureInspectRecord.setAccessory(JSON.toJSONString(model.getAccessoryList()));
    }
    int insert = pressureInspectRecordMapper.insertSelective(pressureInspectRecord);
    // 更新压力测试质检合格数量
    OrderProductExample orderProductExample = new OrderProductExample() ;
    orderProductExample.createCriteria().andOrderNoEqualTo(model.getOrderNo());
    List<OrderProduct> orderProducts = orderProductMapper.selectByExample(orderProductExample);
    if(!CollectionUtils.isEmpty(orderProducts)) {
      int originalNumber = orderProducts.get(0).getPressureQualifiedNumber();
      OrderProduct orderProduct = new OrderProduct();
      orderProduct.setPressureQualifiedNumber(originalNumber + model.getQualifiedNumber());
      orderProductMapper.updateByExampleSelective(orderProduct, orderProductExample);
    }
    return ResultBean.success(insert);
  }

  @Override
  public ResultBean update(PressureInspectRecordDTO model) {
    PressureInspectRecord pressureInspectRecord = new PressureInspectRecord();
    BeanUtils.copyProperties(model, pressureInspectRecord);
    if(!CollectionUtils.isEmpty(model.getAccessoryList())) {
      pressureInspectRecord.setAccessory(JSON.toJSONString(model.getAccessoryList()));
    }
    int update = pressureInspectRecordMapper.updateByPrimaryKeySelective(pressureInspectRecord);
    return ResultBean.success(update);
  }

  @Override
  public ResultBean delete(Integer id) {
    return ResultBean.success(pressureInspectRecordMapper.deleteByPrimaryKey(id));
  }

  @Override
  public ResultBean pageInfo(PressureInspectConditionDTO model) {
    PressureInspectRecordExample example = new PressureInspectRecordExample();
    PressureInspectRecordExample.Criteria criteria = example.createCriteria();
    if (StringUtils.isNotBlank(model.getOrderNo())) {
      criteria.andOrderNoLike("%" + model.getOrderNo() + "%");
    }
    example.setOrderByClause("id desc");
    Page<PressureInspectRecord> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize())
        .doSelectPage(() -> {
          pressureInspectRecordMapper.selectByExample(example);
        });
    PageDTO<PressureInspectRecordListDto> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(pageData, pageDTO);
    List<PressureInspectRecordListDto> dtos = new ArrayList<>();
    for (int i = 0; i < pageData.getResult().size(); i++) {
      PressureInspectRecordListDto dto = new PressureInspectRecordListDto();
      BeanUtils.copyProperties(pageData.getResult().get(i), dto);
      if(StringUtils.isNotEmpty(dto.getAccessory())) {
        dto.setAccessoryList(JSON.parseArray(dto.getAccessory(), Accessory.class));
      }
      dtos.add(dto);
    }
    pageDTO.setList(dtos);
    return ResultBean.success(pageDTO);
  }
}
