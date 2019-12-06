package com.deepsoft.haolifa.service.impl;

import static com.deepsoft.haolifa.constant.CommonEnum.FlowId.SUPPLIER_FLOW;
import static com.deepsoft.haolifa.constant.CommonEnum.FormType.SUPPLIER_TYPE;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.FlowInstanceMapper;
import com.deepsoft.haolifa.dao.repository.SupplierEvaluationRecordMapper;
import com.deepsoft.haolifa.dao.repository.SupplierMapper;
import com.deepsoft.haolifa.dao.repository.SupplierProductMapper;
import com.deepsoft.haolifa.dao.repository.extend.SupplierProductExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
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
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class SupplierServiceImpl extends BaseService implements SupplierService {

    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    SupplierEvaluationRecordMapper evaluationRecordMapper;
    @Autowired
    SupplierProductExtendMapper supplierProductExtendMapper;
    @Lazy
    @Autowired
    FlowInstanceService instanceService;
    @Autowired
    FlowInstanceMapper flowInstanceMapper;

    @Override
    public ResultBean saveInfo(SupplierRequestDTO model) {
        log.info("SupplierServiceImpl saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(model, supplier);
        if (model.getAccessories() != null || model.getAccessories().size() > 0) {
            supplier.setAccessory(JSON.toJSONString(model.getAccessories()));
        }
        String supplierNo = "sn_" + RandomUtils.orderNoStr();
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
        supplier.setAccessory(model.getAccessories().isEmpty() ? "" : JSON.toJSONString(model.getAccessories()));
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
        SupplierResponseInfo responseInfo = new SupplierResponseInfo();
        BeanUtils.copyProperties(supplier, responseInfo);
        if (StringUtils.isNotEmpty(supplier.getAccessory())) {
            responseInfo.setAccessories(JSON.parseArray(supplier.getAccessory(), Accessory.class));
        } else {
            responseInfo.setAccessories(new ArrayList<>());
        }
        return ResultBean.success(responseInfo);
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
        SupplierExample example = new SupplierExample();
        example.createCriteria().andIsQualifiedEqualTo((byte) 1).andIsDeleteEqualTo(CommonEnum.Consts.NO.code);
        List<Supplier> suppliers = supplierMapper.selectByExample(example);
        return ResultBean.success(suppliers);
    }

    @Override
    public ResultBean approve(String supplierNo) {
        Supplier supplier = new Supplier();
        supplier.setIsQualified((byte) 3);// 评定中
        SupplierExample example = new SupplierExample();
        example.createCriteria().andSuppilerNoEqualTo(supplierNo).andIsDeleteEqualTo((byte) 0);
        supplierMapper.updateByExampleSelective(supplier, example);
        Supplier supplier1 = supplierMapper.selectByExample(example).get(0);
        // 添加流程
        FlowInstanceDTO flowInstanceDTO = new FlowInstanceDTO();
        flowInstanceDTO.setFormId(supplier1.getId());
        flowInstanceDTO.setFlowId(SUPPLIER_FLOW.id);
        flowInstanceDTO.setFormNo(supplierNo);
        flowInstanceDTO.setFormType(SUPPLIER_TYPE.code);
        flowInstanceDTO.setSummary("供应商合格审批");
        instanceService.create(flowInstanceDTO);
        return ResultBean.success(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateSupplierStatus(String supplierNo, Integer status, Integer instanceId) {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andSuppilerNoEqualTo(supplierNo);
        Supplier supplier = new Supplier();
        supplier.setIsQualified(status.byteValue());
        supplierMapper.updateByExampleSelective(supplier, example);
        // 将审批过程中的附件存到审批记录表
        FlowInstance flowInstance = flowInstanceMapper.selectByPrimaryKey(instanceId);
        SupplierEvaluationRecord record = new SupplierEvaluationRecord();
        record.setSupplierNo(supplierNo);
        record.setAccessory(flowInstance.getAccessory());
        record.setCreateData(flowInstance.getCreateTime());
        record.setUpdateDate(flowInstance.getUpdateTime());
        record.setAuditResult(status.byteValue());
        evaluationRecordMapper.insertSelective(record);
    }

    @Override
    public ResultBean evaluationRecords(String supplierNo) {
        SupplierEvaluationRecordExample example = new SupplierEvaluationRecordExample();
        example.or().andSupplierNoEqualTo(supplierNo);
        return ResultBean.success(evaluationRecordMapper.selectByExample(example));
    }

    @Override
    public List<SupplierRespDTO> supplierList(SupplierReqDTO supplierReqDTO) {
        List<String> graphNos = supplierReqDTO.getGraphNos();
        supplierReqDTO.setMaterialCount(graphNos.size());
        return supplierProductExtendMapper.getSupplierList(supplierReqDTO);
    }
}

