package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.ApplyBuyMapper;
import com.deepsoft.haolifa.service.ApplyBuyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApplyBuyServiceImpl implements ApplyBuyService {

    @Autowired
    ApplyBuyMapper applyBuyMapper;
}
