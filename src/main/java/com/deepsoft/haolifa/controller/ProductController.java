package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ProductConditionDTO;
import com.deepsoft.haolifa.model.dto.ProductRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"成品管理"})
@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("新增成品信息")
    @PostMapping("/product/save")
    public ResultBean saveProduct(@RequestBody ProductRequestDTO model) {
        return productService.saveInfo(model);
    }

    @ApiOperation("更新成品信息")
    @PostMapping("/product/update")
    public ResultBean updateProduct(@RequestBody ProductRequestDTO model) {
        return productService.updateInfo(model);
    }

    @ApiOperation("删除成品信息")
    @GetMapping("/product/delete/{id}")
    @ApiImplicitParam(name = "id", value = "成品id", dataType = "int", paramType = "path", required = true)
    public ResultBean deleteProduct(@PathVariable int id) {
        return productService.delete(id);
    }

    @ApiOperation("获取成品分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query")
    })
    @PostMapping("/product/pageInfo")
    public ResultBean pageInfoProduct(@RequestParam Integer currentPage, @RequestParam Integer pageSize, @RequestBody ProductConditionDTO productConditionDTO) {
        return productService.pageInfo(currentPage, pageSize, productConditionDTO);
    }
}
