package com.deepsoft.haolifa.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SupplierMapper;
import com.deepsoft.haolifa.model.domain.Supplier;
import com.deepsoft.haolifa.model.domain.SupplierExample;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierRequestDTO;
import com.deepsoft.haolifa.service.SupplierService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public ResultBean saveInfo(SupplierRequestDTO model) {
        log.info("SupplierServiceImpl saveInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplier, model);
        supplier.setCredentialsInfo(JSONObject.toJSONString(model.getCredentials()));
        supplier.setFinancialInfo(JSONObject.toJSONString(model.getFinancial()));
        supplier.setMainOrgan(JSONObject.toJSONString(model.getMainOrgan()));
        supplier.setQualityAssuranceInfo(JSONObject.toJSONString(model.getQualityAssurance()));
        // TODO 需替换为真实userId
        supplier.setCreateUserId(1);
        int insertId = supplierMapper.insertSelective(supplier);
        return ResultBean.success(insertId);
    }

    @Override
    public ResultBean updateInfo(SupplierRequestDTO model) {
        log.info("SupplierServiceImpl updateInfo start|{}", JSONObject.toJSON(model));
        if (StringUtils.isAnyBlank()) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplier, model);
        supplier.setCredentialsInfo(JSONObject.toJSONString(model.getCredentials()));
        supplier.setFinancialInfo(JSONObject.toJSONString(model.getFinancial()));
        supplier.setMainOrgan(JSONObject.toJSONString(model.getMainOrgan()));
        supplier.setQualityAssuranceInfo(JSONObject.toJSONString(model.getQualityAssurance()));
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
        return ResultBean.success(supplier);
    }

    @Override
    public ResultBean getList(Integer currentPage, Integer pageSize, String supplierName, String supplierNo) {
        Supplier supplier = new Supplier();
        PageHelper.startPage(currentPage,pageSize);
        Page<Supplier> pageData = supplierMapper.selectListByExample(supplier);
        Map<String,Object> result = new HashMap<>(3);
        result.put("totalCount", pageData.getTotal());
        result.put("pageSize", pageData.getPageSize());
        result.put("pages", pageData.getPages());
        result.put("list", pageData.getResult());
        return ResultBean.success(result);
    }
}
