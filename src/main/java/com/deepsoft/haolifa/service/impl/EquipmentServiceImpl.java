package com.deepsoft.haolifa.service.impl;

import com.deepsoft.haolifa.dao.repository.EquipmentMapper;
import com.deepsoft.haolifa.service.EquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentMapper equipmentMapper;


}