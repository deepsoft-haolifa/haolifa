package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.PurchaseOrderMapper;
import com.deepsoft.haolifa.service.PurcahseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PurcahseOrderServiceImpl implements PurcahseOrderService {

    @Autowired
    PurchaseOrderMapper purchaseOrderMapper;
}
