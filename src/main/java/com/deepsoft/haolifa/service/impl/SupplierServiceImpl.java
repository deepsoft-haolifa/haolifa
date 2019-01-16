package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SupplierEvaluationRecordMapper;
import com.deepsoft.haolifa.dao.repository.SupplierMapper;
import com.deepsoft.haolifa.model.domain.Supplier;
import com.deepsoft.haolifa.model.domain.SupplierEvaluationRecord;
import com.deepsoft.haolifa.model.domain.SupplierExample;
import com.deepsoft.haolifa.model.dto.FlowInstanceDTO;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierListDTO;
import com.deepsoft.haolifa.model.dto.SupplierRequestDTO;
import com.deepsoft.haolifa.service.FlowInstanceService;
import com.deepsoft.haolifa.service.SupplierService;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SupplierServiceImpl extends BaseService implements SupplierService {

  @Autowired
  SupplierMapper supplierMapper;
  @Autowired
  SupplierEvaluationRecordMapper evaluationRecordMapper;
  @Autowired
  FlowInstanceService instanceService;

  @Override
  public ResultBean saveInfo(SupplierRequestDTO model) {
    log.info("SupplierServiceImpl saveInfo start|{}", JSONObject.toJSON(model));
    if (StringUtils.isAnyBlank()) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    String supplierNo = "sn_" + RandomUtils.orderNoStr();
    Supplier supplier = new Supplier();
    BeanUtils.copyProperties(model, supplier);
    supplier.setSuppilerNo(supplierNo);
    supplier.setStaffInfo(JSONObject.toJSONString(model.getStaffInfo()));
    supplier.setCredentialsInfo(JSONObject.toJSONString(model.getCredentialsInfo()));
    supplier.setFinancialInfo(JSONObject.toJSONString(model.getFinancialInfo()));
    supplier.setMainOrgan(JSONObject.toJSONString(model.getMainOrgan()));
    supplier.setQualityAssuranceInfo(JSONObject.toJSONString(model.getQualityAssuranceInfo()));
    supplier.setCreateUserId(getLoginUserId());
    int insertId = supplierMapper.insertSelective(supplier);
    return ResultBean.success(insertId);
  }

  @Override
  public ResultBean updateInfo(SupplierRequestDTO model) {
    log.info("SupplierServiceImpl updateInfo start|{}", JSONObject.toJSON(model));
    if (model.getId() == null || model.getId() == 0) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    Supplier supplier = new Supplier();
    BeanUtils.copyProperties(model, supplier);
    supplier.setCredentialsInfo(JSONObject.toJSONString(model.getCredentialsInfo()));
    supplier.setFinancialInfo(JSONObject.toJSONString(model.getFinancialInfo()));
    supplier.setMainOrgan(JSONObject.toJSONString(model.getMainOrgan()));
    supplier.setQualityAssuranceInfo(JSONObject.toJSONString(model.getQualityAssuranceInfo()));
    int update = supplierMapper.updateByPrimaryKeySelective(supplier);
    return ResultBean.success(update);
  }

  @Override
  public ResultBean deleteInfo(Integer id) {
    log.info("SupplierServiceImpl deleteInfo start|{}", id);
    if (null == id || 0 == id) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    Supplier supplier = new Supplier();
    supplier.setId(id);
    supplier.setIsDelete(CommonEnum.Consts.YES.code);
    int update = supplierMapper.updateByPrimaryKeySelective(supplier);
    return ResultBean.success(update);
  }

  @Override
  public ResultBean getInfo(Integer id) {
    log.info("SupplierServiceImpl getInfo start|{}", id);
    if (null == id || 0 == id) {
      return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
    }
    Supplier supplier = supplierMapper.selectByPrimaryKey(id);
    if (supplier.getIsDelete().equals(CommonEnum.Consts.YES.code)) {
      return new ResultBean(CommonEnum.ResponseEnum.RESOURCE_NOT_EXIST);
    }
    return ResultBean.success(supplier);
  }

  @Override
  public ResultBean getList(SupplierListDTO model) {
    if (model.getPageNum() == null || model.getPageNum() == 0) {
      model.setPageNum(1);
    }
    if (model.getPageSize() == null || model.getPageSize() == 0) {
      model.setPageSize(10);
    }
    SupplierExample supplierExample = new SupplierExample();
    SupplierExample.Criteria criteria = supplierExample.createCriteria();
    if (StringUtils.isNotEmpty(model.getSupplierNo())) {
      criteria.andSuppilerNoLike("%" + model.getSupplierNo() + "%");
    }
    if (StringUtils.isNotEmpty(model.getSupplierName())) {
      criteria.andSuppilerNameLike("%" + model.getSupplierName() + "%");
    }
    criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
    Page<Supplier> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() -> {
      supplierMapper.selectByExample(supplierExample);
    });
    PageDTO<Supplier> pageDTO = new PageDTO<>();
    BeanUtils.copyProperties(pageData, pageDTO);
    pageDTO.setList(pageData.getResult());
    return ResultBean.success(pageDTO);
  }

  @Override
  public ResultBean listByName() {
    List<Supplier> suppliers = supplierMapper.selectByExample(new SupplierExample());
    return ResultBean.success(suppliers);
  }

  @Override
  public ResultBean approve(String supplierNo) {
    Supplier supplier = new Supplier();
    supplier.setIsQualified((byte) 3);// 评定中
    SupplierExample example = new SupplierExample();
    example.createCriteria().andSuppilerNoEqualTo(supplierNo);
    supplierMapper.updateByExampleSelective(supplier, example);
    // 添加记录
    SupplierEvaluationRecord evaluationRecord = new SupplierEvaluationRecord();
    evaluationRecord.setCreateData(new Date());
    evaluationRecord.setAuditResult((byte) 0);
    evaluationRecord.setSupplierFile("");
    evaluationRecord.setAccessory("");
    evaluationRecord.setSupplierNo(supplierNo);
    evaluationRecordMapper.insertSelective(evaluationRecord);
    // 添加流程
    FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
    flowInstanceDTO.setFormId(0);
    flowInstanceDTO.setFlowId(3);
    flowInstanceDTO.setFormNo(supplierNo);
    flowInstanceDTO.setFormType(9);
    flowInstanceDTO.setSummary("供应商合格审批");
    instanceService.create(flowInstanceDTO);
    return ResultBean.success(1);
  }

  @Override
  public void updateSupplierStatus(String supplierNo, Integer status) {
    SupplierExample example = new SupplierExample();
    example.createCriteria().andSuppilerNoEqualTo(supplierNo);
    Supplier supplier = new Supplier();
    supplier.setIsQualified(status.byteValue());
    supplierMapper.updateByExampleSelective(supplier, example);
  }
}

