package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.service.SupplierProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"供应商产品管理"})
@RestController
@RequestMapping("/supplier-pro")
public class SupplierProductController {

    @Autowired
    SupplierProductService supplierProductService;

}
