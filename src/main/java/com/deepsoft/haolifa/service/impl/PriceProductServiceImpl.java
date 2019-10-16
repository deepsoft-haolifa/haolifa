package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.PriceProductMapper;
import com.deepsoft.haolifa.dao.repository.ProductMapper;
import com.deepsoft.haolifa.dao.repository.ProductMaterialMapper;
import com.deepsoft.haolifa.dao.repository.extend.ProductMaterialExtendMapper;
import com.deepsoft.haolifa.model.domain.*;
import com.deepsoft.haolifa.model.dto.*;
import com.deepsoft.haolifa.model.dto.price.PriceProductConditionDTO;
import com.deepsoft.haolifa.service.*;
import com.deepsoft.haolifa.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PriceProductServiceImpl implements PriceProductService {

    @Autowired
    private PriceProductMapper priceProductMapper;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean saveInfo(PriceProduct model) {
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        model.setCreateUser(createUser);
        int insert = priceProductMapper.insertSelective(model);
        if (insert > 0) {
            return ResultBean.success(insert);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @Override
    public ResultBean updateInfo(PriceProduct model) {
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        int update = priceProductMapper.updateByPrimaryKeySelective(model);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @Override
    public ResultBean delete(int id) {
        int delete = priceProductMapper.deleteByPrimaryKey(id);
        return ResultBean.success(delete);

    }

    @Override
    public PriceProduct getInfo(int id) {
        if (id == 0) {
            return null;
        }
        PriceProduct product = priceProductMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public ResultBean pageInfo(PriceProductConditionDTO priceProductConditionDTO) {
        PriceProductExample example = new PriceProductExample();
        PriceProductExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(priceProductConditionDTO.getProductModel())) {
            criteria.andProductModelLike("%" + priceProductConditionDTO.getProductModel() + "%");
        }
        if (StringUtils.isNotBlank(priceProductConditionDTO.getProductNo())) {
            criteria.andProductNoLike("%" + priceProductConditionDTO.getProductNo() + "%");
        }

        example.setOrderByClause("id desc");

        Page<PriceProduct> products = PageHelper.startPage(priceProductConditionDTO.getPageNum(), priceProductConditionDTO.getPageSize())
                .doSelectPage(() -> priceProductMapper.selectByExample(example));
        PageDTO<PriceProduct> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(products, pageDTO);
        pageDTO.setList(products);
        return ResultBean.success(pageDTO);
    }
}
