package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.PayHourQuota;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;
import com.deepsoft.haolifa.model.vo.pay.PayOrderUserRelationProcedureVO;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.PayOrderUserRelationProcedureService;
import com.deepsoft.haolifa.service.PayWorkingProcedureService;
import com.deepsoft.haolifa.util.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 上午11:27 2021/10/16
 * @description 工序明细管理
 */
@Api(tags = "绩效工序明细管理")
@RestController
@RequestMapping("/pay-working-procedure")
public class PayWorkingProcedureController {

    @Resource
    private PayWorkingProcedureService payWorkingProcedureService;
    @Autowired
    private OrderProductService orderProductService;
    @Resource
    private PayOrderUserRelationProcedureService payOrderUserRelationProcedureService;

    @ApiOperation("列表")
    @PostMapping("/getList")
    public ResultBean getList(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.pageInfo(model);
    }

    @ApiOperation("获取所有列表")
    @PostMapping("/getAllList")
    public ResultBean getAllList(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.getAllList(model);
    }

    @ApiOperation("保存")
    @PostMapping(value = "/save")
    public ResultBean save(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.save(model);
    }

    @ApiOperation("查看详情")
    @GetMapping(value = "info/{id}")
    public ResultBean getInfo(@PathVariable("id") Integer id) {
        return payWorkingProcedureService.getInfo(id);
    }

    @ApiOperation("修改")
    @PostMapping(value = "/edit")
    public ResultBean edit(@RequestBody PayWorkingProcedureDTO model) {
        return payWorkingProcedureService.edit(model);
    }

    @ApiOperation("删除")
    @GetMapping(value = "del/{id}")
    public ResultBean del(@PathVariable("id") Integer id) {
        return payWorkingProcedureService.delete(id);
    }


    @ApiOperation("获取订单的产品列表（只包含产品）")
    @GetMapping("/product-list")
    @ApiImplicitParam(name = "orderNo", value = "订单号", dataType = "String", paramType = "query", required = true)
    public ResultBean productList(String orderNo) {
        return ResultBean.success(orderProductService.getOrderProductList(orderNo));
    }

    @ApiOperation("分配任务按钮")
    @GetMapping(value = "assignTask")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderNo", value = "订单号", required = true),
        @ApiImplicitParam(name = "type", value = "订单类型， 1：生产装配订单；2：喷涂订单；3：机加工订单;4:自控车间；5：橡胶车间", required = true)

    })
    public ResultBean assignTask(@RequestParam(value = "orderNo") String orderNo,
                                 @RequestParam(value = "type") String type) {
        return payWorkingProcedureService.assignTask(orderNo, type);
    }

    @ApiOperation("分配任务保存按钮")
    @PostMapping(value = "/saveTask")
    public ResultBean saveTask (@RequestBody PayOrderUserRelationProcedureVO procedure) {
        return payOrderUserRelationProcedureService.insertSelective(procedure);
    }

    @ApiOperation("导入工序")
    @PostMapping(value = "/import")
    public ResultBean uploadMaterial() {
        try {
            File file2 =new File("/Users/liuyaofei/newself/批量上传/各车间产品加工工序明细表（批量上传测试）.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file2);
            List<PayWorkingProcedureDTO> objects = (List<PayWorkingProcedureDTO>) ExcelUtils.importExcelReadColumn(fileInputStream, PayWorkingProcedureDTO.class);
            payWorkingProcedureService.save(objects);
            return ResultBean.success(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

}
