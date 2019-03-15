package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.PriceProduct;
import com.deepsoft.haolifa.model.dto.ProductRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.price.PriceProductConditionDTO;
import com.deepsoft.haolifa.service.PriceProductService;
import com.deepsoft.haolifa.service.ProductMaterialService;
import com.deepsoft.haolifa.service.ProductService;
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


}
