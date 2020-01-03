package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.SporadicMaterial;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutDto;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutPage;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicMaterialPageDto;
import com.deepsoft.haolifa.service.SporadicMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author murphy.he
 **/
@Api(tags = "零星物资管理")
@RequestMapping("sporadic")
@RestController
public class SporadicMaterialController {

    @Autowired
    private SporadicMaterialService sporadicMaterialService;


    @PostMapping("/add")
    @ApiOperation("添加")
    public ResultBean add(@RequestBody SporadicMaterial sporadicMaterial) {
        int add = sporadicMaterialService.add(sporadicMaterial);
        if (add > 0) {
            return ResultBean.success(add);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/update")
    @ApiOperation("更新")
    public ResultBean update(@RequestBody SporadicMaterial sporadicMaterial) {
        int update = sporadicMaterialService.update(sporadicMaterial);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/page")
    @ApiOperation("零星物料分页列表")
    public ResultBean<SporadicMaterial> pageList(@RequestBody SporadicMaterialPageDto sporadicMaterial) {
        return ResultBean.success(sporadicMaterialService.pageList(sporadicMaterial));
    }

    @PostMapping("/entry")
    @ApiOperation("零星物料入库")
    public ResultBean entry(@RequestBody SporadicEntryOutDto entryOutDto) {
        int update = sporadicMaterialService.entry(entryOutDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/out")
    @ApiOperation("零星物料出库")
    public ResultBean out(@RequestBody SporadicEntryOutDto entryOutDto) {
        int update = sporadicMaterialService.out(entryOutDto);
        if (update > 0) {
            return ResultBean.success(update);
        } else {
            return ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
    }

    @PostMapping("/entry-out-page-list")
    @ApiOperation("零星物料 出库/入库详情")
    public ResultBean entryOutPageList(@RequestBody SporadicEntryOutPage page) {
        return ResultBean.success(sporadicMaterialService.entryOutPage(page));
    }

}
