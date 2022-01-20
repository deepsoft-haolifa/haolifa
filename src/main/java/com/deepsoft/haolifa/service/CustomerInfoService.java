package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.CustomerInfo;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.customer.CustomerInfoConditionDto;

/**
 * @author murphy.he
 **/
public interface CustomerInfoService {

    /**
     * 分页
     * @return
     */
    PageDTO<CustomerInfo> pageInfo(CustomerInfoConditionDto pageDto);
}
