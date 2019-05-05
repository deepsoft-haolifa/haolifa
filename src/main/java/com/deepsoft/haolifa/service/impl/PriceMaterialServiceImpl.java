package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.dao.repository.PriceMaterialMapper;
import com.deepsoft.haolifa.dao.repository.PriceProductMapper;
import com.deepsoft.haolifa.model.domain.PriceMaterial;
import com.deepsoft.haolifa.model.domain.PriceMaterialExample;
import com.deepsoft.haolifa.model.domain.PriceProductExample;
import com.deepsoft.haolifa.model.dto.CustomUser;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.price.PriceMaterialConditionDTO;
import com.deepsoft.haolifa.model.dto.price.PriceProductConditionDTO;
import com.deepsoft.haolifa.service.MaterialService;
import com.deepsoft.haolifa.service.PriceMaterialService;
import com.deepsoft.haolifa.service.PriceProductService;
import com.deepsoft.haolifa.service.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class PriceMaterialServiceImpl implements PriceMaterialService {

    @Autowired
    private PriceMaterialMapper priceMaterialMapper;
    @Autowired
    private MaterialService materialService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public ResultBean saveInfo(PriceMaterial model) {
        CustomUser customUser = sysUserService.selectLoginUser();
        int createUser = customUser != null ? customUser.getId() : 1;
        model.setCreateUser(createUser);
        int insert = priceMaterialMapper.insertSelective(model);
        if (insert > 0) {
            // 更新零件价格
            String blankCost = model.getBlankCost();
            materialService.updateMaterialPrice(model.getGraphNo(),new BigDecimal(blankCost));
            return ResultBean.success(insert);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @Override
    public ResultBean updateInfo(PriceMaterial model) {
        if (model.getId() == 0) {
            return ResultBean.error(CommonEnum.ResponseEnum.PARAM_ERROR);
        }
        int update = priceMaterialMapper.updateByPrimaryKeySelective(model);
        if (update > 0) {
            // 更新零件价格
            String blankCost = model.getBlankCost();
            materialService.updateMaterialPrice(model.getGraphNo(),new BigDecimal(blankCost));
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @Override
    public ResultBean delete(int id) {
        int delete = priceMaterialMapper.deleteByPrimaryKey(id);
        return ResultBean.success(delete);

    }

    @Override
    public PriceMaterial getInfo(int id, String materialGraphNo) {
        PriceMaterial product = null;
        if(id > 0) {
            product = priceMaterialMapper.selectByPrimaryKey(id);
        } else if(StringUtils.isNotEmpty(materialGraphNo)) {
            PriceMaterialExample priceMaterialExample = new PriceMaterialExample();
            priceMaterialExample.createCriteria().andGraphNoEqualTo(materialGraphNo);
            List<PriceMaterial> priceMaterialList = priceMaterialMapper.selectByExample(priceMaterialExample);
            if(priceMaterialList != null && priceMaterialList.size()>0) {
                product = priceMaterialList.get(0);
            }
        }
        return product;
    }

    @Override
    public ResultBean pageInfo(PriceMaterialConditionDTO priceMaterialConditionDTO) {
        PriceMaterialExample example = new PriceMaterialExample();
        PriceMaterialExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(priceMaterialConditionDTO.getModel())) {
            criteria.andModelLike("%" + priceMaterialConditionDTO.getModel() + "%");
        }
        if (StringUtils.isNotBlank(priceMaterialConditionDTO.getGraphNo())) {
            criteria.andGraphNoLike("%" + priceMaterialConditionDTO.getGraphNo() + "%");
        }
        if (StringUtils.isNotBlank(priceMaterialConditionDTO.getSpecifications())) {
            criteria.andSpecificationsLike("%" + priceMaterialConditionDTO.getSpecifications() + "%");
        }
        if (StringUtils.isNotBlank(priceMaterialConditionDTO.getName())) {
            criteria.andNameLike("%" + priceMaterialConditionDTO.getName() + "%");
        }
        example.setOrderByClause("id desc");

        Page<PriceMaterial> products = PageHelper.startPage(priceMaterialConditionDTO.getPageNum(), priceMaterialConditionDTO.getPageSize())
                .doSelectPage(() -> priceMaterialMapper.selectByExample(example));
        PageDTO<PriceMaterial> pageDTO = new PageDTO<>();
        BeanUtils.copyProperties(products, pageDTO);
        pageDTO.setList(products);
        return ResultBean.success(pageDTO);
    }
}
