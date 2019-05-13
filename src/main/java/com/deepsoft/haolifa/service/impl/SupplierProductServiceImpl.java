package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.SupplierProductMapper;
import com.deepsoft.haolifa.dao.repository.extend.SupplierProductExtendMapper;
import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.domain.SupplierProduct;
import com.deepsoft.haolifa.model.domain.SupplierProductExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierPorductDTO;
import com.deepsoft.haolifa.model.dto.SupplierProductListDTO;
import com.deepsoft.haolifa.service.SupplierProductService;
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
public class SupplierProductServiceImpl extends BaseService implements SupplierProductService {

    @Autowired
    SupplierProductMapper supplierProductMapper;

    @Autowired
    SupplierProductExtendMapper supplierProductExample;

    @Override
    public ResultBean save(SupplierPorductDTO model) {
        SupplierProduct supplierProduct = new SupplierProduct();
        BeanUtils.copyProperties(model, supplierProduct);
        supplierProduct.setMaterialType(model.getMaterialType().byteValue());
        if (model.getMaterialType() == null
                || (model.getMaterialType().equals(0) && StringUtils.isEmpty(model.getMaterialGraphNo()))
                || StringUtils
                .isEmpty(model.getSupplierNo())) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        if(model.getMaterialType().equals(1)) {
            supplierProduct.setMaterialGraphNo("");
        }
        supplierProduct.setCreateUserId(getLoginUserId());
        int insert = supplierProductMapper.insertSelective(supplierProduct);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean delete(Integer id) {
        int delete = supplierProductMapper.deleteByPrimaryKey(id);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean update(SupplierPorductDTO model) {
        SupplierProduct supplierProduct = new SupplierProduct();
        BeanUtils.copyProperties(model, supplierProduct);
        supplierProduct.setMaterialType(model.getMaterialType().byteValue());
        int update = supplierProductMapper.updateByPrimaryKeySelective(supplierProduct);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        SupplierProduct supplierProduct = supplierProductMapper.selectByPrimaryKey(id);
        return ResultBean.success(supplierProduct);
    }

    @Override
    public ResultBean getList(SupplierProductListDTO model) {
        if (model.getPageNum() == null || model.getPageNum() == 0) {
            model.setPageNum(1);
        }
        if (model.getPageSize() == null || model.getPageSize() == 0) {
            model.setPageSize(10);
        }
        Page<SupplierProduct> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize()).doSelectPage(() ->
            supplierProductExample.getSupplierProList(model));
        PageDTO<SupplierProduct> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
