package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.SupplierProductMapper;
import com.deepsoft.haolifa.service.SupplierProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SupplierProductServiceImpl implements SupplierProductService {

    @Autowired
    SupplierProductMapper supplierProductMapper;
}
