package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.dto.ProductMaterialDTO;
import com.deepsoft.haolifa.model.dto.ProductRequestDTO;
import com.deepsoft.haolifa.model.dto.ProductUpdateRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.ProductMaterialService;
import com.deepsoft.haolifa.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"配套管理--成品管理"})
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMaterialService productMaterialService;

    @ApiOperation("新增成品信息")
    @PostMapping("/save")
    public ResultBean saveProduct(@RequestBody ProductRequestDTO model) {
        return productService.saveInfo(model);
    }

    @ApiOperation("更新成品信息")
    @PutMapping("/update")
    public ResultBean updateProduct(@RequestBody ProductUpdateRequestDTO model) {
        return productService.updateInfo(model);
    }

    @ApiOperation("删除成品信息")
    @DeleteMapping("/delete/{id}/{productNo}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "成品id", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "productNo", value = "成品号", dataType = "string", paramType = "path", required = true)
    })
    public ResultBean deleteProduct(@PathVariable int id, @PathVariable String productNo) {
        return productService.delete(id, productNo);
    }

    @ApiOperation("获取成品信息（包括零件管理信息）")
    @GetMapping("/getInfo/{id}")
    @ApiImplicitParam(name = "id", value = "成品id", dataType = "int", paramType = "path", required = true)
    public ResultBean getInfoProduct(@PathVariable int id) {
        return ResultBean.success(productService.getProductAllInfo(id));
    }

    @ApiOperation("获取成品分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "成品名称", name = "nameLike", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "成品编号", name = "productNoLike", dataType = "string", paramType = "query")
    })
    @GetMapping("/pageInfo")
    public ResultBean pageInfoProduct(@RequestParam(defaultValue = "1") Integer currentPage,
                                      @RequestParam(defaultValue = "20") Integer pageSize,
                                      @RequestParam(required = false) String nameLike,
                                      @RequestParam(required = false) String productNoLike) {
        return productService.pageInfo(currentPage, pageSize, nameLike, productNoLike);
    }


    @ApiOperation("（编辑成品信息时用的到）编辑成品零件关联信息")
    @PutMapping("/material/edit/{productNo}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productNo", value = "成品号", dataType = "string", paramType = "path", required = true)
    })
    public ResultBean saveProductMaterial(@PathVariable String productNo, @RequestBody ProductMaterialDTO model) {
        return productMaterialService.editInfo(productNo, model);
    }

    @ApiOperation("（编辑成品信息时用的到）删除成品零件关联信息")
    @DeleteMapping("/material/delete/{productNo}/{materialGraphNo}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productNo", value = "成品号", dataType = "string", paramType = "path", required = true),
            @ApiImplicitParam(name = "materialGraphNo", value = "零件编号", dataType = "string", paramType = "path", required = true)
    })
    public ResultBean deleteProductMaterial(@PathVariable String productNo, @PathVariable String materialGraphNo) {
        return productMaterialService.delete(productNo, materialGraphNo);
    }

//    @ApiOperation("获取成品零件配置分页列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
//            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
//            @ApiImplicitParam(required = true, value = "成品编号", name = "productNo", dataType = "string", paramType = "query")
//    })
//    @GetMapping("/material/pageInfo")
//    public ResultBean pageInfoProduct(@RequestParam(defaultValue = "1") Integer currentPage,
//                                      @RequestParam(defaultValue = "20") Integer pageSize,
//                                      @RequestParam String productNo) {
//        return productMaterialService.pageInfo(currentPage, pageSize, productNo);
//    }
}
