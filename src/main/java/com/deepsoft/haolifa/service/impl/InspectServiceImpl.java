package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CacheKey.BATCH_NUM_KEY;
import static com.deepsoft.haolifa.constant.CacheKey.INSPECT_NO_KEY;
import static com.deepsoft.haolifa.constant.CommonEnum.InspectMaterialType.ENTRUST_MATERIAL_TYPE_2;
import static com.deepsoft.haolifa.constant.CommonEnum.InspectMaterialType.PURCHASE_MATERIAL_TYPE_1;
import static com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum.MATERIAL_REPORT_IS_NULL;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.BATCH_NUMBER_PREFIX_PC;
import static com.deepsoft.haolifa.constant.Constant.SerialNumberPrefix.INSPECT_NO_PREFIX_BJ;

import com.alibaba.fastjson.JSON;
import com.deepsoft.haolifa.constant.CommonEnum.InspectHistoryStatus;
import com.deepsoft.haolifa.constant.CommonEnum.InspectStatus;
import com.deepsoft.haolifa.dao.repository.EntrustMapper;
import com.deepsoft.haolifa.dao.repository.InspectHistoryMapper;
import com.deepsoft.haolifa.dao.repository.InspectItemMapper;
import com.deepsoft.haolifa.dao.repository.InspectMapper;
import com.deepsoft.haolifa.model.domain.Entrust;
import com.deepsoft.haolifa.model.domain.EntrustExample;
import com.deepsoft.haolifa.model.domain.Inspect;
import com.deepsoft.haolifa.model.domain.InspectExample;
import com.deepsoft.haolifa.model.domain.InspectHistory;
import com.deepsoft.haolifa.model.domain.InspectHistoryExample;
import com.deepsoft.haolifa.model.domain.InspectItem;
import com.deepsoft.haolifa.model.domain.InspectItemExample;
import com.deepsoft.haolifa.model.dto.InspectDTO;
import com.deepsoft.haolifa.model.dto.InspectItemDTO;
import com.deepsoft.haolifa.model.dto.InspectItemUpdateDTO;
import com.deepsoft.haolifa.model.dto.InspectResDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.InspectService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class InspectServiceImpl extends BaseService implements InspectService {

  @Autowired
  InspectMapper inspectMapper;
  @Autowired
  InspectItemMapper inspectItemMapper;
  @Autowired
  InspectHistoryMapper historyMapper;
  @Autowired
  EntrustMapper entrustMapper;

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean save(InspectDTO model) {
    int createUserId = getLoginUserId();
    String inspectNo = createSerialNumber(INSPECT_NO_PREFIX_BJ, INSPECT_NO_KEY);
    String batchNumer = createSerialNumber(BATCH_NUMBER_PREFIX_PC, BATCH_NUM_KEY);
    Inspect inspect = new Inspect();
    BeanUtils.copyProperties(model, inspect);
    inspect.setBlueprints(model.getAccessorys() == null || model.getAccessorys().size() == 0 ? ""
        : JSON.toJSONString(model.getAccessorys()));
    inspect.setCreateUserId(createUserId);
    inspect.setInspectNo(inspectNo);
    inspect.setBatchNumber(batchNumer);
    inspect.setStatus(model.getStatus().byteValue());
    if (model.getStatus() == 2 && (model.getAccessorys() == null || model.getAccessorys().size() == 0)) {
      return new ResultBean(MATERIAL_REPORT_IS_NULL);
    }
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
        inspectItem.setPurchasePrice(new BigDecimal(items.get(i).getPurchasePrice()));
        inspectItem.setPurchaseNo(model.getPurchaseNo());
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

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean delete(Integer inspectId) {
    inspectMapper.deleteByPrimaryKey(inspectId);
    InspectItemExample inspectItemExample = new InspectItemExample();
    inspectItemExample.or().andInspectIdEqualTo(inspectId);
    inspectItemMapper.deleteByExample(inspectItemExample);
    return ResultBean.success(1);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean update(int inspectId, InspectDTO model) {
    if (model.getStatus() == 2 && (model.getAccessorys() == null || model.getAccessorys().size() == 0)) {
      return new ResultBean(MATERIAL_REPORT_IS_NULL);
    }
    Inspect inspect = new Inspect();
    inspect.setId(inspectId);
    inspect.setSupplierName(model.getSupplierName());
    if (StringUtils.isNotEmpty(model.getArrivalTime())) {
      Date arrivalTime = DateFormatterUtils
          .parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, model.getArrivalTime());
      inspect.setArrivalTime(arrivalTime);
    }
    inspect.setBatchNumber(model.getBatchNumber());
    inspect.setBlueprints(model.getAccessorys() == null || model.getAccessorys().size() == 0 ? ""
        : JSON.toJSONString(model.getAccessorys()));
    inspectMapper.updateByPrimaryKeySelective(inspect);
    InspectItemExample itemExample = new InspectItemExample();
    itemExample.or().andInspectIdEqualTo(inspect.getId());
    inspectItemMapper.deleteByExample(itemExample);
    List<InspectItemDTO> items = model.getItems();
    if (items != null && items.size() > 0) {
      for (int i = 0; i < items.size(); i++) {
        InspectItem inspectItem = new InspectItem();
        BeanUtils.copyProperties(items.get(i), inspectItem);
        inspectItem.setPurchasePrice(new BigDecimal(items.get(i).getPurchasePrice()));
        inspectItem.setInspectId(inspect.getId());
        inspectItemMapper.insertSelective(inspectItem);
      }
    }
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
  public ResultBean getList(int type, int pageNum, int pageSize, String inspectNo, String purchaseOrderNo) {
    InspectExample example = new InspectExample();
    InspectExample.Criteria criteria = example.createCriteria();
//    if (type == 0) {
//      criteria.andCreateUserIdEqualTo(getLoginUserId());
//    }
    if (type == 1) {
      criteria.andStatusNotIn(Arrays.asList(InspectStatus.SAVE.code));
    }
    if (type == 2) {
      criteria.andStatusIn(Arrays.asList(InspectStatus.STOCK_PENDING.code, InspectStatus.STOCKED.code));
    }
    if (StringUtils.isNotEmpty(purchaseOrderNo)) {
      criteria.andPurchaseNoLike("%" + purchaseOrderNo + "%");
    }
    if (StringUtils.isNotEmpty(inspectNo)) {
      criteria.andInspectNoLike("%" + inspectNo + "%");
    }

    Page pageData = PageHelper.startPage(pageNum, pageSize, "create_time desc")
        .doSelectPage(() -> inspectMapper.selectByExample(example));
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

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean updateStatus(Integer inspectId, Integer status) {
    Inspect inspect = new Inspect();
    inspect.setId(inspectId);
    inspect.setStatus(status.byteValue());
    Inspect inspect1 = inspectMapper.selectByPrimaryKey(inspectId);
    if (status == 2 && inspect1.getBlueprints().length() == 0) {
      return new ResultBean(MATERIAL_REPORT_IS_NULL);
    }
    inspectMapper.updateByPrimaryKeySelective(inspect);
    if (status == 2 || status == 3) {
      // 更新单项合格与不合格数量
      InspectHistoryExample historyExample = new InspectHistoryExample();
      historyExample.or().andInspectNoEqualTo(inspect1.getInspectNo());
      List<InspectHistory> histories = historyMapper.selectByExample(historyExample);
      Map<String, InspectItem> updateItem = new HashMap<>();
      for (int i = 0; i < histories.size(); i++) {
        InspectHistory history = histories.get(i);
        if (updateItem.containsKey(history.getMaterialGraphNo())) {
          InspectItem item = updateItem.get(history.getMaterialGraphNo());
          item.setUnqualifiedNumber(item.getUnqualifiedNumber() + history.getUnqualifiedNumber());
          updateItem.put(history.getMaterialGraphNo(), item);
        } else {
          InspectItem item = new InspectItem();
          item.setUnqualifiedNumber(history.getUnqualifiedNumber());
          updateItem.put(history.getMaterialGraphNo(), item);
        }
      }
      for (Entry en : updateItem.entrySet()) {
        InspectItemExample itemExample = new InspectItemExample();
        itemExample.or().andInspectIdEqualTo(inspectId).andMaterialGraphNoEqualTo(en.getKey().toString());
        inspectItemMapper.updateByExampleSelective((InspectItem) en.getValue(), itemExample);
      }
    }
    return ResultBean.success(1);
  }

  @Override
  public ResultBean inspectRes(int itemId, InspectResDTO model) {
    InspectItem inspectItem = new InspectItem();
    inspectItem.setId(itemId);
    inspectItem.setQualifiedNumber(model.getQualifiedNumber());
    inspectItem.setUnqualifiedNumber(model.getUnqualifiedNumber());
    inspectItemMapper.updateByPrimaryKeySelective(inspectItem);
    return ResultBean.success(1);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean historySave(InspectHistory model) {
    historyMapper.insertSelective(model);
    if (model.getType() == PURCHASE_MATERIAL_TYPE_1.getCode()) {
      // 采购零件 质检
      InspectExample example = new InspectExample();
      example.createCriteria().andInspectNoEqualTo(model.getInspectNo());
      List<Inspect> inspectList = inspectMapper.selectByExample(example);
      Inspect inspect = new Inspect();
      if (!CollectionUtils.isEmpty(inspectList) && inspectList.size() > 0) {
        inspect.setQualifiedNumber(inspectList.get(0).getQualifiedNumber() + model.getQualifiedNumber());
        inspectMapper.updateByExampleSelective(inspect, example);
      }
    }
    if (model.getType() == ENTRUST_MATERIAL_TYPE_2.getCode()) {
      // 机加工 质检
      EntrustExample entrustExample = new EntrustExample();
      entrustExample.createCriteria().andEntrustNoEqualTo(model.getInspectNo());
      List<Entrust> entrustList = entrustMapper.selectByExample(entrustExample);
      Entrust entrust = new Entrust();
      if (!CollectionUtils.isEmpty(entrustList) && entrustList.size() > 0) {
        entrust.setQualifiedNumber(model.getQualifiedNumber() + entrustList.get(0).getQualifiedNumber());
        entrustMapper.updateByExampleSelective(entrust, entrustExample);
      }
    }
    return ResultBean.success(1);
  }

  @Override
  public ResultBean historyDelete(Integer id) {
    historyMapper.deleteByPrimaryKey(id);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean historyList(String inspectNo) {
    InspectHistoryExample historyExample = new InspectHistoryExample();
    historyExample.or().andInspectNoEqualTo(inspectNo);
    List<InspectHistory> histories = historyMapper.selectByExample(historyExample);
    return ResultBean.success(histories);
  }

  @Override
  public ResultBean historyList(Integer pageNum, Integer pageSize, Integer status) {
    InspectHistoryExample example = new InspectHistoryExample();
    InspectHistoryExample.Criteria criteria = example.createCriteria();
    if (InspectHistoryStatus.BEEN_STORE_2.code == status
        || InspectHistoryStatus.WAITING_STORE_1.code == status) {
      criteria.andStatusEqualTo(status.byteValue());
    }
    criteria.andQualifiedNumberGreaterThan(0);
    Page<InspectHistory> histories = PageHelper.startPage(pageNum, pageSize)
        .doSelectPage(() -> historyMapper.selectByExample(example));
    PageDTO pageDTO = new PageDTO();
    BeanUtils.copyProperties(histories, pageDTO);
    pageDTO.setList(histories.getResult());
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean updateHistoryStatus(Integer historyId) {
    InspectHistory inspectHistory = new InspectHistory();
    inspectHistory.setId(historyId);
    inspectHistory.setStatus(InspectHistoryStatus.BEEN_STORE_2.code);
    historyMapper.updateByPrimaryKeySelective(inspectHistory);
    return ResultBean.success(1);
  }
}
