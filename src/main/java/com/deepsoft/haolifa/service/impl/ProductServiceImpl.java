package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.ProductMapper;
import com.deepsoft.haolifa.model.domain.Product;
import com.deepsoft.haolifa.model.domain.ProductExample;
import com.deepsoft.haolifa.model.domain.StoreRoomRackExample;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.service.ProductService;
import com.deepsoft.haolifa.service.SysUserService;
import com.deepsoft.haolifa.util.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean saveInfo(ProductRequestDTO model) {
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        Product product = new Product();
        BeanUtils.copyProperties(model, product);
        product.setCreateUser(createUser);
        int insert = productMapper.insertSelective(product);
        return ResultBean.success(insert);
    }

    @Override
    public ResultBean updateInfo(ProductRequestDTO model) {
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        Product product = new Product();
        BeanUtils.copyProperties(model, product);
        product.setUpdateTime(new Date());
        CustomUser customUser = sysUserService.selectLoginUser();
        int updateUser = customUser != null ? customUser.getId() : 1;
        product.setUpdateUser(updateUser);
        int update = productMapper.updateByPrimaryKeySelective(product);
        return ResultBean.success(update);
    }

    @Override
    public ResultBean delete(int id) {
        Product record = new Product() {{
            setId(id);
            setIsDelete(CommonEnum.Consts.YES.code);
        }};
        int update = productMapper.updateByPrimaryKeySelective(record);
        return ResultBean.success(update);
    }

    @Override
    public Product getInfo(int id) {
        if (id == 0) {
            return null;
        }
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public ResultBean pageInfo(Integer pageNum, Integer pageSize, ProductConditionDTO productConditionDTO) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 20 : pageSize;
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        if (productConditionDTO.getIsDelete() > -1) {
            criteria.andIsDeleteEqualTo(productConditionDTO.getIsDelete());
        }
        if (StringUtils.isNotBlank(productConditionDTO.getName())) {
            criteria.andNameLike(productConditionDTO.getName());
        }
        if (StringUtils.isNotBlank(productConditionDTO.getProductNo())) {
            criteria.andProductNoLike(productConditionDTO.getProductNo());
        }
        PageInfo<StoreRoomRackRequestDTO> page = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> productMapper.selectByExample(example));
        return ResultBean.success(page);
    }
}
