package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.EntrustMapper;
import com.deepsoft.haolifa.service.EntrustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EntrustServiceImpl implements EntrustService {

    @Autowired
    EntrustMapper entrustMapper;
}
