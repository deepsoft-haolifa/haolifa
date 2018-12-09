package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.DeliveryNotice;
import com.deepsoft.haolifa.model.domain.DeliveryRecord;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryNoticeAuditDTO;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryNoticeConditionDTO;
import com.deepsoft.haolifa.model.dto.delivery.DeliveryRecordConditionDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.DeliveryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"发货单"})
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;


    @ApiOperation("上传发货通知单")
    @PostMapping("/saveNotice")
    public ResultBean saveNotice(@RequestBody DeliveryNotice model) {
        return deliveryService.saveNotice(model);
    }


    @ApiOperation("发货通知单详情")
    @GetMapping("/noticeInfo/{id}")
    public ResultBean noticeInfo(@PathVariable("id") int id) {
        return ResultBean.success(deliveryService.noticeInfo(id));
    }
    @ApiOperation("财务审核发货通知单")
    @PostMapping("/auditNotice")
    public ResultBean auditNotice(@RequestBody DeliveryNoticeAuditDTO model) {
        return deliveryService.auditNotice(model);
    }
    @ApiOperation("发货通知单列表")
    @PostMapping("/noticeList")
    public ResultBean noticeList(@RequestBody DeliveryNoticeConditionDTO model) {
        return deliveryService.pageNotices(model);
    }



    @ApiOperation("添加发货记录")
    @PostMapping("/save")
    public ResultBean save(@RequestBody DeliveryRecord model) {
        return deliveryService.save(model);
    }

    @ApiOperation("获取发货记录详情")
    @PostMapping("/getInfo/{id}")
    public ResultBean getInfo(@PathVariable int id) {
        return ResultBean.success(deliveryService.getInfo(id));
    }

    @ApiOperation("更新发货记录")
    @PostMapping("/update")
    public ResultBean getInfo(@RequestBody DeliveryRecord model) {
        return deliveryService.update(model);
    }

    @ApiOperation("获取发货记录列表")
    @PostMapping("/pageList")
    public ResultBean pageList(@RequestBody DeliveryRecordConditionDTO model) {
        return deliveryService.pageInfo(model);
    }

    @ApiOperation("获取发货类型")
    @GetMapping("/getClassifyList")
    public ResultBean getClassifyList() {
        return ResultBean.success(deliveryService.getClassifyList());
    }
}
