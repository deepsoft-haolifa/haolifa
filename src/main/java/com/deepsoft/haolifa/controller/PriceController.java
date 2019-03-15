package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.PriceMaterial;
import com.deepsoft.haolifa.model.domain.PriceProduct;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.price.PriceMaterialConditionDTO;
import com.deepsoft.haolifa.model.dto.price.PriceProductConditionDTO;
import com.deepsoft.haolifa.service.PriceMaterialService;
import com.deepsoft.haolifa.service.PriceProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"价格管理（零件+成品）"})
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceProductService priceProductService;

    @Autowired
    private PriceMaterialService priceMaterialService;

    @ApiOperation("新增成品价格")
    @PostMapping("/product/save")
    public ResultBean saveProduct(@RequestBody PriceProduct model) {
        return priceProductService.saveInfo(model);
    }

    @ApiOperation("更新成品价格")
    @PutMapping("/product/update")
    public ResultBean updateProduct(@RequestBody PriceProduct model) {
        return priceProductService.updateInfo(model);
    }

    @ApiOperation("删除成品价格")
    @DeleteMapping("/product/delete/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", paramType = "path", required = true),
    })
    public ResultBean delete(@PathVariable int id) {
        return priceProductService.delete(id);
    }

    @ApiOperation("获取成品价格")
    @GetMapping("/product/getInfo/{id}")
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", paramType = "path", required = true)
    public ResultBean getInfo(@PathVariable int id) {
        return ResultBean.success(priceProductService.getInfo(id));
    }

    @ApiOperation("获取成品价格分页")
    @PostMapping("/product/pageInfo")
    public ResultBean pageInfoProduct(@RequestBody PriceProductConditionDTO model) {
        return priceProductService.pageInfo(model);
    }

    @ApiOperation("新增零件价格")
    @PostMapping("/material/save")
    public ResultBean saveMaterial(@RequestBody PriceMaterial model) {
        return priceMaterialService.saveInfo(model);
    }

    @ApiOperation("更新零件价格")
    @PutMapping("/material/update")
    public ResultBean updateMaterial(@RequestBody PriceMaterial model) {
        return priceMaterialService.updateInfo(model);
    }

    @ApiOperation("删除零件价格")
    @DeleteMapping("/material/delete/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", paramType = "path", required = true),
    })
    public ResultBean deleteMaterial(@PathVariable int id) {
        return priceMaterialService.delete(id);
    }

    @ApiOperation("获取零件价格")
    @GetMapping("/material/getInfo/{id}")
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "int", paramType = "path", required = true)
    public ResultBean getMaterialInfo(@PathVariable int id) {
        return ResultBean.success(priceMaterialService.getInfo(id));
    }

    @ApiOperation("获取零件价格分页")
    @PostMapping("/material/pageInfo")
    public ResultBean pageInfoMaterial(@RequestBody PriceMaterialConditionDTO model) {
        return priceMaterialService.pageInfo(model);
    }
}
