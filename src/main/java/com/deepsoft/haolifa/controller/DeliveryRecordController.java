package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.DeliveryRecordConditionDTO;
import com.deepsoft.haolifa.model.dto.DeliveryRecordDTO;
import com.deepsoft.haolifa.model.dto.InvoiceDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.DeliveryRecordService;
import com.deepsoft.haolifa.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"发货单"})
@RestController
@RequestMapping("/delivery/")
public class DeliveryRecordController {
    @Autowired
    DeliveryRecordService deliveryRecordService;

    @ApiOperation("添加发货单")
    @PostMapping("save")
    public ResultBean save(@RequestBody DeliveryRecordDTO model) {
        return deliveryRecordService.save(model);
    }

    @ApiOperation("获取发货单详情")
    @PostMapping("getInfo")
    public ResultBean getInfo(@RequestBody DeliveryRecordConditionDTO model) {
        return ResultBean.success(deliveryRecordService.getInfo(model.getDeliveryNo(), model.getOrderNo()));
    }

}
