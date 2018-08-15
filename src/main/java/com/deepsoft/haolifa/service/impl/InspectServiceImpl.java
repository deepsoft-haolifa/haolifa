package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.InspectMapper;
import com.deepsoft.haolifa.service.InspectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InspectServiceImpl implements InspectService {

    @Autowired
    InspectMapper inspectMapper;
}
