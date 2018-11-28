package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.DeliveryRecord;
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
@RequestMapping("/delivery")
public class DeliveryRecordController {
    @Autowired
    DeliveryRecordService deliveryRecordService;

    @ApiOperation("添加发货单")
    @PostMapping("/save")
    public ResultBean save(@RequestBody DeliveryRecord model) {
        return deliveryRecordService.save(model);
    }

    @ApiOperation("获取发货单详情")
    @PostMapping("/getInfo/{id}")
    public ResultBean getInfo(@PathVariable int id) {
        return ResultBean.success(deliveryRecordService.getInfo(id));
    }

    @ApiOperation("更新发货单详情")
    @PostMapping("/update")
    public ResultBean getInfo(@RequestBody DeliveryRecord model) {
        return deliveryRecordService.update(model);
    }

    @ApiOperation("获取发货单列表")
    @PostMapping("/pageList")
    public ResultBean pageList(@RequestBody DeliveryRecordConditionDTO model) {
        return deliveryRecordService.pageInfo(model);
    }

    @ApiOperation("获取发货类型")
    @GetMapping("/getClassifyList")
    public ResultBean getClassifyList() {
        return ResultBean.success(deliveryRecordService.getClassifyList());
    }
}
