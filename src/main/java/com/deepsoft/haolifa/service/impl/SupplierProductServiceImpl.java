package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SupplierProductMapper;
import com.deepsoft.haolifa.model.domain.Equipment;
import com.deepsoft.haolifa.model.domain.SupplierProduct;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SupplierPorductDTO;
import com.deepsoft.haolifa.service.SupplierProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SupplierProductServiceImpl implements SupplierProductService {

    @Autowired
    SupplierProductMapper supplierProductMapper;

    @Override
    public ResultBean save(SupplierPorductDTO model) {
        SupplierProduct supplierProduct = new SupplierProduct();
        BeanUtils.copyProperties(model, supplierProduct);
        // TODO
        supplierProduct.setCreateUserId(1);
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
        int update = supplierProductMapper.updateByPrimaryKey(supplierProduct);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean getInfo(Integer id) {
        SupplierProduct supplierProduct = supplierProductMapper.selectByPrimaryKey(id);
        return ResultBean.success(supplierProduct);
    }

    @Override
    public ResultBean getList(Integer currentPage, Integer pageSize, Integer materialType, String materialName) {
        PageHelper.startPage(currentPage, pageSize);
        Page<SupplierProduct> pageData = supplierProductMapper.selectListByPage(materialType, materialName);
        Map<String, Object> result = new HashMap<>(4);
        result.put("totalCount", pageData.getTotal());
        result.put("pageSize", pageData.getPageSize());
        result.put("pages", pageData.getPages());
        result.put("list", pageData.getResult());
        return ResultBean.success(result);
    }
}
