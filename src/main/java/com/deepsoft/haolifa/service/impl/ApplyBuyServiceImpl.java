package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum.Consts;
import com.deepsoft.haolifa.constant.CommonEnum.FormType;
import com.deepsoft.haolifa.constant.CommonEnum.ResponseEnum;
import com.deepsoft.haolifa.dao.repository.ApplyBuyMapper;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.PurchaseOrderItemMapper;
import com.deepsoft.haolifa.dao.repository.extend.PurchaseOrderItemExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ApplyBuyService;
import com.deepsoft.haolifa.util.DateFormatterUtils;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ApplyBuyServiceImpl extends BaseService implements ApplyBuyService {

  @Autowired
  ApplyBuyMapper applyBuyMapper;
  @Autowired
  PurchaseOrderItemExtendMapper ItemExtendMapper;
  @Autowired
  MaterialMapper materialMapper;

  @Autowired
  PurchaseOrderItemMapper orderItemMapper;
  @Transactional(rollbackFor = Exception.class)
  @Override
  public ResultBean save(ApplyBuyDTO model) {
    String applyBuyNo = "ap_" + RandomUtils.orderNoStr();
    int createUserId = getLoginUserId();
    if (model.getItemList() != null && model.getItemList().size() > 0) {
      List<ApplyBuyItem> items = model.getItemList();
      for (int i = 0; i < items.size(); i++) {
        ApplyBuy buy = new ApplyBuy();
        ApplyBuyItem item = items.get(i);
        buy.setCreateUserId(createUserId);
        buy.setMaterialGraphNo(item.getMaterialGraphNo());
        buy.setMaterialName(item.getMaterialName());
        buy.setPurchaseNumber(item.getPurchaseNumber());
        buy.setApplyBuyNo(applyBuyNo);
        buy.setProductOrderNo(model.getProductOrderNo());
        applyBuyMapper.insertSelective(buy);
      }
      Map result = new HashMap(2);
      result.put("formNo", applyBuyNo);
      result.put("formType", FormType.APPLYBUY_TYPE.code);
      result.put("formId", 0);
      return ResultBean.success(result);
    } else {
      return ResultBean.error(ResponseEnum.PARAM_ERROR);
    }
  }


  @Override
  public ResultBean deleteItem(int itemId) {
    applyBuyMapper.deleteByPrimaryKey(itemId);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean update(ApplyBuyUpdateDTO model) {
    ApplyBuy applyBuy = new ApplyBuy();
    applyBuy.setId(model.getItemId());
    applyBuy.setPurchaseNumber(model.getPurchaseNumber());
    applyBuy.setMaterialName(model.getMaterialName());
    applyBuy.setMaterialGraphNo(model.getMaterialGraphNo());
    applyBuyMapper.updateByPrimaryKeySelective(applyBuy);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean updateArrivalTime(int itemId, String arrivalTime) {
    if (StringUtils.isEmpty(arrivalTime)) {
      return ResultBean.error(ResponseEnum.PARAM_ERROR);
    }
    ApplyBuy applyBuy = new ApplyBuy();
    applyBuy.setId(itemId);
    applyBuy.setArrivalTime(DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, arrivalTime));
    applyBuyMapper.updateByPrimaryKeySelective(applyBuy);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean getInfo(String formNo) {
    ApplyBuyExample example = new ApplyBuyExample();
    example.or().andApplyBuyNoEqualTo(formNo);
    List<ApplyBuy> applyBuys = applyBuyMapper.selectByExample(example);
    return ResultBean.success(applyBuys);
  }

  @Override
  public ResultBean updateStatus(int itemId) {
    ApplyBuy applyBuy = new ApplyBuy();
    applyBuy.setId(itemId);
    applyBuy.setStatus((byte) 3);
    applyBuy.setDealUserId(getLoginUserId());
    applyBuyMapper.updateByPrimaryKeySelective(applyBuy);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean list(int pageNum, int pageSize, int status, String materialName, String materialGraphNo) {
    ApplyBuyExample example = new ApplyBuyExample();
    ApplyBuyExample.Criteria criteria = example.createCriteria();
    if (status != -1) {
      criteria.andStatusEqualTo((byte) status);
    }
    if(StringUtils.isNotEmpty(materialName)) {
      criteria.andMaterialNameLike("%"+materialName+"%");
    }
    if(StringUtils.isNotEmpty(materialGraphNo)) {
      criteria.andMaterialGraphNoLike("%"+materialGraphNo+"%");
    }
    Page pageData = PageHelper.startPage(pageNum, pageSize,"create_time desc").doSelectPage(() -> applyBuyMapper.selectByExample(example));
    List<ApplyBuy> applyBuyList = pageData.getResult();
    List<ApplyBuyListDTO> listDTOS = new ArrayList<>();
    for (int i = 0; i < applyBuyList.size(); i++) {
      ApplyBuy applyBuy = applyBuyList.get(i);
      ApplyBuyListDTO listDTO = new ApplyBuyListDTO();
      BeanUtils.copyProperties(applyBuy, listDTO);
      if (applyBuy.getDealUserId() == 0) {
        listDTO.setDealUserName("");
      } else {
        listDTO.setDealUserName(sysUserService.getSysUser(applyBuy.getDealUserId()).getRealName());
      }
      listDTOS.add(listDTO);
    }
    PageDTO pageDTO = new PageDTO();
    BeanUtils.copyProperties(pageData, pageDTO);
    pageDTO.setList(listDTOS);
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean list(String orderNo) {
    ApplyBuyExample applyBuyExample = new ApplyBuyExample();
    applyBuyExample.or().andProductOrderNoEqualTo(orderNo);
    return ResultBean.success(applyBuyMapper.selectByExample(applyBuyExample));
  }

  @Override
  public ResultBean updateStatusByOrderNo(String orderNo, String arriveTime) {
    ApplyBuyExample example = new ApplyBuyExample();
    example.or().andProductOrderNoEqualTo(orderNo);
    ApplyBuy applyBuy = new ApplyBuy();
    applyBuy.setStatus((byte) 1);
    applyBuy.setArrivalTime(DateFormatterUtils.parseDateString(DateFormatterUtils.TWO_FORMATTERPATTERN, arriveTime));
    applyBuyMapper.updateByExampleSelective(applyBuy, example);
    return ResultBean.success(1);
  }

  @Override
  public ResultBean updateStatusByOrderNo(String orderNo, Integer status) {
    ApplyBuyExample example = new ApplyBuyExample();
    example.or().andProductOrderNoEqualTo(orderNo);
    ApplyBuy applyBuy = new ApplyBuy();
    applyBuy.setStatus(status.byteValue());
    applyBuyMapper.updateByExampleSelective(applyBuy, example);
    return ResultBean.success(1);
  }
}
