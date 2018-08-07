package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.service.EquipmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"设备管理"})
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;





}
