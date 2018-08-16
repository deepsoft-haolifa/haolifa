package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.MaterialInspectResultMapper;
import com.deepsoft.haolifa.dao.repository.ProInspectResultMapper;
import com.deepsoft.haolifa.service.InspectResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InspectResultServiceImpl implements InspectResultService {

    @Autowired
    MaterialInspectResultMapper materialInspectResultMapper;

    @Autowired
    ProInspectResultMapper proInspectResultMapper;
}
