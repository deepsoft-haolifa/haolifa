package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum.InspectStatus;
import com.deepsoft.haolifa.dao.repository.InspectItemMapper;
import com.deepsoft.haolifa.dao.repository.InspectMapper;
import com.deepsoft.haolifa.dao.repository.extend.InspectExtendMapper;
import com.deepsoft.haolifa.model.domain.Inspect;
import com.deepsoft.haolifa.model.domain.InspectExample;
import com.deepsoft.haolifa.model.domain.InspectItem;
import com.deepsoft.haolifa.model.domain.InspectItemExample;
import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectItemDTO;
import com.deepsoft.haolifa.model.dto.InspectItemUpdateDTO;
import com.deepsoft.haolifa.model.dto.InspectResDTO;
import com.deepsoft.haolifa.model.dto.InspectUpdateDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InspectService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.Arrays;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class InspectServiceImpl extends BaseService implements InspectService {

  @Autowired
  InspectMapper inspectMapper;
  @Autowired
  InspectItemMapper inspectItemMapper;
  @Autowired
  InspectExtendMapper inspectExtendMapper;

  @Override
  public ResultBean save(InspectDTO model) {
    int createUserId = getLoginUserId();
    String inspectNo = "in_" + RandomUtils.orderNoStr();
    Inspect inspect = new Inspect();
    BeanUtils.copyProperties(model, inspect);
    inspect.setCreateUserId(createUserId);
    inspect.setInspectNo(inspectNo);
    if (StringUtils.isNotEmpty(model.getArrivalTime())) {
      inspect.setArrivalTime(
          DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getArrivalTime()));
    }
    inspectMapper.insertSelective(inspect);
    List<InspectItemDTO> items = model.getItems();
    if (items != null && items.size() > 0) {
      for (int i = 0; i < items.size(); i++) {
        InspectItem inspectItem = new InspectItem();
        BeanUtils.copyProperties(items.get(i), inspectItem);
        inspectItem.setInspectId(inspect.getId());
        inspectItemMapper.insertSelective(inspectItem);
      }
    }
    return ResultBean.success(inspect.getId());
  }


  @Override
  public ResultBean getInfo(int inspectId) {
    Inspect inspect = inspectMapper.selectByPrimaryKey(inspectId);
    InspectItemExample example = new InspectItemExample();
    example.or().andInspectIdEqualTo(inspectId);
    List<InspectItem> items = inspectItemMapper.selectByExample(example);
    Map<String, Object> result = new HashMap<>(2);
    result.put("inspect", inspect);
    result.put("items", items);
    return ResultBean.success(result);
  }

  @Override
  public ResultBean delete(Integer inspectId) {
    inspectMapper.deleteByPrimaryKey(inspectId);
    InspectItemExample inspectItemExample = new InspectItemExample();
    inspectItemExample.or().andInspectIdEqualTo(inspectId);
    inspectItemMapper.deleteByExample(inspectItemExample);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean update(int inspectId, InspectUpdateDTO model) {
    Inspect inspect = new Inspect();
    inspect.setId(inspectId);
    inspect.setSupplierName(model.getSupplierName());
    if (StringUtils.isNotEmpty(model.getArrivalTime())) {
      Date arrivalTime = DateFormatterUtils
          .parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getArrivalTime());
      inspect.setArrivalTime(arrivalTime);
    }
    inspectMapper.updateByPrimaryKeySelective(inspect);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean updateItem(int itemId, InspectItemUpdateDTO model) {
    InspectItem inspectItem = new InspectItem();
    BeanUtils.copyProperties(model, inspectItem);
    inspectItem.setId(itemId);
    inspectItemMapper.updateByPrimaryKeySelective(inspectItem);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean getList(int type, int pageNum, int pageSize) {
    InspectExample example = new InspectExample();
    if (type == 0) {
      example.or().andCreateUserIdEqualTo(getLoginUserId());
    }
    if (type == 1) {
      example.or().andStatusNotIn(Arrays.asList(InspectStatus.SAVE.code));
    }
    if (type == 2) {
      example.or().andStatusIn(Arrays.asList(InspectStatus.STOCK_PENDING.code, InspectStatus.STOCKED.code));
    }
    Page pageData = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> inspectMapper.selectByExample(example));
    PageDTO pageDTO = new PageDTO();
    BeanUtils.copyProperties(pageData, pageDTO);
    pageDTO.setList(pageData.getResult());
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean deleteItem(int itemId) {
    inspectItemMapper.deleteByPrimaryKey(itemId);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean updateStatus(int inspectId, Integer status) {
    Inspect inspect = new Inspect();
    inspect.setId(inspectId);
    inspect.setStatus(status.byteValue());
    inspectMapper.updateByPrimaryKeySelective(inspect);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean inspectRes(int itemId, InspectResDTO model) {
    InspectItem inspectItem = new InspectItem();
    inspectItem.setId(itemId);
    inspectItem.setQualifiedNumber(model.getQualifiedNumber());
    inspectItem.setUnqualifiedNumber(model.getUnqualifiedNumber());
    inspectItem.setDealType((byte)model.getDealType());
    inspectItemMapper.updateByPrimaryKeySelective(inspectItem);
    return ResultBean.success(1);
  }
}
