package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.TechnicalDetailedMapper;
import com.deepsoft.haolifa.model.domain.TechnicalDetailed;
import com.deepsoft.haolifa.model.domain.TechnicalDetailedExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.technicalDetailed.TechnicalDetailedConditionDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 技术清单Service
 *
 * @author murphy.he
 **/
@Service
@Slf4j
public class TechnicalDetailedService {

    @Autowired
    TechnicalDetailedMapper technicalDetailedMapper;

    public int update(TechnicalDetailed reqDto) {
        // 根据规格，型号，执行器型号确定唯一
        return technicalDetailedMapper.updateByPrimaryKeySelective(reqDto);
    }

    public PageDTO<TechnicalDetailed> pageList(TechnicalDetailedConditionDTO pageDto) {
        TechnicalDetailedExample example = new TechnicalDetailedExample();
        TechnicalDetailedExample.Criteria criteria = example.createCriteria();


        if (StringUtils.isNotEmpty(pageDto.getActuatorModel())) {
            criteria.andActuatorModelLike("%" + pageDto.getActuatorModel() + "%");
        }
        if (StringUtils.isNotEmpty(pageDto.getSpecifications())) {
            criteria.andSpecificationsLike("%" + pageDto.getSpecifications() + "%");
        }
        if (StringUtils.isNotEmpty(pageDto.getProductModel())) {
            criteria.andProductModelLike("%" + pageDto.getProductModel() + "%");
        }
        if (StringUtils.isNotEmpty(pageDto.getProductName())) {
            criteria.andProductNameLike("%" + pageDto.getProductName() + "%");
        }
        Page<TechnicalDetailed> pageList = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize(), "id desc")
            .doSelectPage(() -> technicalDetailedMapper.selectByExample(example));
        PageDTO<TechnicalDetailed> pageDtos = new PageDTO<>();
        BeanUtils.copyProperties(pageList, pageDtos);
        pageDtos.setList(pageList);
        return pageDtos;
    }

}
