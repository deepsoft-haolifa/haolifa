package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.service.FinanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    FinanceService financeService;

}
