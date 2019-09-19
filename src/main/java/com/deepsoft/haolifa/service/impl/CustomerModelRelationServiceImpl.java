package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.CustomerModelRelationMapper;
import com.deepsoft.haolifa.model.domain.CustomerModelRelation;
import com.deepsoft.haolifa.model.domain.CustomerModelRelationExample;
import com.deepsoft.haolifa.service.CustomerModelRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerModelRelationServiceImpl implements CustomerModelRelationService {
    @Autowired
    private CustomerModelRelationMapper customerModelRelationMapper;

    @Override
    public String getHaoliGraphNo(String customerNo, String customerModelNo) {
        CustomerModelRelationExample example = new CustomerModelRelationExample();
        example.or().andCustomerNoEqualTo(customerNo).andCustomerModelNoEqualTo(customerModelNo);
        List<CustomerModelRelation> customerModelRelations = customerModelRelationMapper.selectByExample(example);
        return customerModelRelations.size() > 0 ? customerModelRelations.get(0).getHaoliModelNo() : "";
    }
}
