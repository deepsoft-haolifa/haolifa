package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.Product;
import com.deepsoft.haolifa.model.dto.product.OutProductDTO;
import com.deepsoft.haolifa.model.dto.product.ProductConditionDTO;
import com.deepsoft.haolifa.model.dto.product.ProductRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"库房管理--成品管理"})
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("获取成品分页列表")
    @PostMapping("/pageInfo")
    public ResultBean<Product> pageInfoProduct(@RequestBody ProductConditionDTO model) {
        return productService.pageInfo(model);
    }

    @ApiOperation("成品出库")
    @PostMapping("/out-product")
    public ResultBean outProduct(@RequestBody OutProductDTO model) {
        boolean outProduct = productService.outProduct(model);
        if (outProduct) {
            ResultBean.success(null);
        } else {
            ResultBean.error(CommonEnum.ResponseEnum.FAIL);
        }
        return null;
    }
}
