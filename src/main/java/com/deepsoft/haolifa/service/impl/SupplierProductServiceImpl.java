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
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.SupplierProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SupplierProductServiceImpl extends BaseService implements SupplierProductService {

    @Autowired
    SupplierProductMapper supplierProductMapper;
    @Autowired
    MaterialService materialService;
    @Autowired
    SupplierProductExtendMapper supplierProductExample;

    @Override
    public ResultBean save(List<SupplierPorductDTO> listModel) {
        int insert = 0;
        if (!CollectionUtils.isEmpty(listModel)) {
            for (SupplierPorductDTO model : listModel) {
                SupplierProduct supplierProduct = new SupplierProduct();
                BeanUtils.copyProperties(model, supplierProduct);
                supplierProduct.setMaterialType(model.getMaterialType().byteValue());
                if (model.getMaterialType() == null
                    || (model.getMaterialType().equals(0) && StringUtils.isEmpty(model.getMaterialGraphNo()))
                    || StringUtils
                    .isEmpty(model.getSupplierNo())) {
                    return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
                }
                // 判断添加的图号是否在图号库里面
                boolean existsGraphNo = materialService.existsGraphNo(supplierProduct.getMaterialGraphNo());
                if (!existsGraphNo) {
                    return ResultBean.error(CommonEnum.ResponseEnum.SUPPLIER_GRAPH_NO_ERROR, "供应商添加的这个产品不存着零件库，" + supplierProduct.getMaterialGraphNo());
                }

                if (model.getMaterialType().equals(1)) {
                    supplierProduct.setMaterialGraphNo("");
                }
                supplierProduct.setCreateUserId(getLoginUserId());
                insert = supplierProductMapper.insertSelective(supplierProduct);
            }
        }
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
        Page<SupplierProduct> pageData = PageHelper.startPage(model.getPageNum(), model.getPageSize(), "id desc").doSelectPage(() ->
            supplierProductExample.getSupplierProList(model));
        PageDTO<SupplierProduct> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(pageData, pageDTO);
        pageDTO.setList(pageData.getResult());
        return ResultBean.success(pageDTO);
    }
}
