package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProductMaterialMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.ProductMaterialService;
import com.deepsoft.haolifa.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductMaterialServiceImpl extends BaseService implements ProductMaterialService {

    @Autowired
    private ProductMaterialMapper productMaterialMapper;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private ProductService productService;

    @Override
    public List<ProductMaterial> getMaterialListByNo(String productNo) {
        // 判断是否有这个产品
        Product infoByNo = productService.getInfoByNo(productNo);
        if (infoByNo == null) {
            return null;
        }
        ProductMaterialExample example = new ProductMaterialExample();
        example.or().andProductNoEqualTo(productNo);
        List<ProductMaterial> productMaterials = productMaterialMapper.selectByExample(example);
        return productMaterials;
    }

    @Override
    public ResultBean delete(String productNo, String materialGraphNo) {
        ProductMaterialExample example = new ProductMaterialExample();
        example.or().andProductNoEqualTo(productNo).andMaterialGraphNoEqualTo(materialGraphNo);
        int delete = productMaterialMapper.deleteByExample(example);
        return ResultBean.success(delete);
    }

    @Override
    public ResultBean pageInfo(Integer currentPage, Integer pageSize, String productNo) {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;
        ProductMaterialExample example = new ProductMaterialExample();
        ProductMaterialExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(CommonEnum.Consts.NO.code);

        if (StringUtils.isNotBlank(productNo)) {
            criteria.andProductNoEqualTo(productNo);
        }
        example.setOrderByClause("create_time desc");
        Page<ProductMaterial> products = PageHelper.startPage(currentPage, pageSize)
                .doSelectPage(() -> productMaterialMapper.selectByExample(example));

        List<ProductMaterial> result = products.getResult();
        List<Material> materials = new ArrayList<>();
        for (ProductMaterial productMaterial : result) {
            String materialGraphNo = productMaterial.getMaterialGraphNo();
            Material infoByGraphNo = materialService.getInfoByGraphNo(materialGraphNo);
            materials.add(infoByGraphNo);
        }
        PageDTO<Material> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(materials, pageDTO);
        pageDTO.setList(materials);
        return ResultBean.success(pageDTO);
    }
}
