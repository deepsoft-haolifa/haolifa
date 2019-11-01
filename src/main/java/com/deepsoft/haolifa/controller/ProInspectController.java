package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.constant.Constant;
import com.deepsoft.haolifa.model.domain.OrderProductAssociate;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.order.OrderProductDTO;
import com.deepsoft.haolifa.model.dto.pressureInspect.PressureInspectResDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectConditionDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectListDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectRecordDTO;
import com.deepsoft.haolifa.model.dto.proInspect.ProInspectResDTO;
import com.deepsoft.haolifa.service.OrderProductService;
import com.deepsoft.haolifa.service.ProInspectResultService;
import com.deepsoft.haolifa.service.ProInspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"成品质检"})
@RestController
@RequestMapping("/pro-inspect")
public class ProInspectController {

    @Autowired
    private ProInspectService proInspectService;
    @Autowired
    private OrderProductService orderProductService;

    @ApiOperation("新增")
    @PostMapping("/save")
    public ResultBean save(@RequestBody ProInspectRecordDTO model) {
        //根据订单号查询需要的成品数量
        OrderProductDTO orderProductDTO = orderProductService.getOrderProductInfo(model.getOrderNo());
        //订单产品列表
        List<OrderProductAssociate> orderProductAssociates = orderProductDTO.getOrderProductAssociates();
        //得到需要的数量
        int num = 0;
        for(OrderProductAssociate orderProductAssociate:orderProductAssociates){
            if(orderProductAssociate.getProductNo().equals(model.getProductNo())&&orderProductAssociate.getProductModel().equals(model.getProductModel())){
                num = orderProductAssociate.getProductNumber();
            }
        }
        //得到质检结果
        ProInspectConditionDTO proInspectConditionDTO = new ProInspectConditionDTO();
        proInspectConditionDTO.setOrderNo(model.getOrderNo());
        proInspectConditionDTO.setPageNum(1);
        proInspectConditionDTO.setPageSize(200);
        ResultBean resultBean =  proInspectService.pageInfo(proInspectConditionDTO);
        PageDTO<ProInspectListDTO> pageDTO = (PageDTO<ProInspectListDTO>) resultBean.getResult();
        List<ProInspectListDTO> proInspectListDTOList = pageDTO.getList();
        //已入库产品编号跟型号
        int number = 0;
        for(ProInspectListDTO proInspectListDTO:proInspectListDTOList){
            if(proInspectListDTO.getProductNo().equals(model.getProductNo())&&proInspectListDTO.getProductModel().equals(model.getProductModel())){
                number = number + proInspectListDTO.getQualifiedNumber();
            }
        }
        //判断保存的数量是否小于等于总数量-已经质检数量
        if(model.getQualifiedNumber() > num - number){
            return ResultBean.error(CommonEnum.ResponseEnum.ORDER_SIGLE_PRO_INSPECT_NUM_ERROR);
        }
        return proInspectService.save(model);
    }

    @ApiOperation("删除")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable Integer id) {
        return proInspectService.delete(id);
    }
    @ApiOperation("修改")
    @PostMapping("/update")
    public ResultBean update(@RequestBody ProInspectRecordDTO model) {
        return proInspectService.update(model);
    }

    @ApiOperation("分页列表")
    @PostMapping("/pageInfo")
    public ResultBean getList(@RequestBody ProInspectConditionDTO model) {
        return proInspectService.pageInfo(model);
    }


    @ApiOperation("更新质检单入库状态")
    @PostMapping("/updateStorageStatus")
    @ApiImplicitParams({
            @ApiImplicitParam( value = "质检id", name = "id", dataType = "int", paramType = "query"),
            @ApiImplicitParam( value = "入库状态（1待入库；2已入库）", name = "storageStatus", dataType = "int", paramType = "query"),
           })
    public ResultBean updateStorageStatus(@RequestParam int id, @RequestParam byte storageStatus) {
        return ResultBean.success(proInspectService.updateStorageStatus(id, storageStatus));
    }

    @ApiOperation("成品不合格原因列表")
    @GetMapping("/reasonList")
    public ResultBean reasonList() {
        String[] split = Constant.INSPECT_UNQUALIFIED_REASON.split(",");
        return ResultBean.success(split);
    }


}
