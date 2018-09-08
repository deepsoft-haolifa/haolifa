package com.deepsoft.haolifa.controller;

import com.deepsoft.haolifa.model.domain.OrderProduct;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"订单成品相关管理"})
@RestController
@RequestMapping("/order-product/")
public class OrderProductController {
//
//    @Autowired
//    private OrderProductService orderProductService;
//
//    @ApiOperation("订单excel上传接口--开发中")
//    @PostMapping("/uploadExcel/save")
//    @ApiImplicitParam(name = "base64Source", value = "上传excel文件的base64编码", dataType = "String", required = true)
//    public ResultBean save(@RequestParam String base64Source) {
//        return orderProductService.uploadOrderProductExcel(base64Source);
//    }
//    }
//
//    @ApiOperation("成品订单添加")
//    @DeleteMapping("/save")
//    @ApiImplicitParam(name = "id", value = "分类id", dataType = "int", paramType = "path", required = true)
//    public ResultBean deleteClassify(@RequestBody OrderProduct orderProduct) {
//        return orderProductService.saveOrderProductInfo(orderProduct);
//    }
//
//    @ApiOperation("获取成品订单详情")
//    @GetMapping("/details/{orderNo}")
//    public ResultBean listClassify() {
//        return orderProductService.getOrderProductInfo();
//    }


//    @ApiOperation("获取零件类别分页列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(required = true, value = "当前页面", name = "currentPage", dataType = "int", paramType = "query"),
//            @ApiImplicitParam(required = true, value = "每页数量", name = "pageSize", dataType = "int", paramType = "query"),
//            @ApiImplicitParam(value = "分类名称", name = "classifyNameLike", dataType = "string", paramType = "query")
//    })
//    @GetMapping("/classify/pageInfo")
//    public ResultBean pageInfoClassify(@RequestParam(defaultValue = "1") Integer currentPage,
//                                       @RequestParam(defaultValue = "20") Integer pageSize,
//                                       @RequestParam(required = false) String classifyNameLike) {
//        return materialService.pageInfoClassify(currentPage, pageSize, classifyNameLike);
//    }
}
