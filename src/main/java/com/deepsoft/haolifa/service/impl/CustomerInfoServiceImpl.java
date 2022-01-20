package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.CustomerInfoMapper;
import com.deepsoft.haolifa.model.domain.CustomerInfo;
import com.deepsoft.haolifa.model.domain.CustomerInfoExample;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.customer.CustomerInfoConditionDto;
import com.deepsoft.haolifa.service.CustomerInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author murphy.he
 **/
@Slf4j
@Service
public class CustomerInfoServiceImpl extends BaseService implements CustomerInfoService {
    @Resource
    private CustomerInfoMapper customerInfoMapper;

    @Override
    public PageDTO<CustomerInfo> pageInfo(CustomerInfoConditionDto pageDto) {
        CustomerInfoExample example = new CustomerInfoExample();
        CustomerInfoExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(pageDto.getName())) {
            criteria.andNameLike("%" + pageDto.getName() + "%");
        }
        Page<CustomerInfo> pageList = PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize(), "id desc")
            .doSelectPage(() -> customerInfoMapper.selectByExample(example));
        PageDTO<CustomerInfo> pageDtos = new PageDTO<>();
        BeanUtils.copyProperties(pageList, pageDtos);
        pageDtos.setList(pageList);
        return pageDtos;
    }
}
