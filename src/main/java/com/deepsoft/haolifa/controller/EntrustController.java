package com.deepsoft.haolifa.controller;


import com.deepsoft.haolifa.model.dto.EntrustDTO;
import com.deepsoft.haolifa.model.dto.EntrustListDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.service.EntrustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"机加委托管理"})
@RestController
@RequestMapping("entrust")
public class EntrustController {

    @Autowired
    private EntrustService entrustService;

    @ApiOperation("添加机加委托申请")
    @PostMapping("save")
    public ResultBean save(@RequestBody EntrustDTO model){
        return entrustService.save(model);
    }

    @ApiOperation("删除机加委托申请")
    @GetMapping("delete/{entrustNo}")
    public ResultBean delete(@PathVariable("entrustNo") String entrustNo){
        return entrustService.delete(entrustNo);
    }

    @ApiOperation("修改机加委托申请")
    @PostMapping("update/{entrustNo}")
    public ResultBean update(@PathVariable("entrustNo")String entrustNo,@RequestBody EntrustDTO model){
        return entrustService.update(entrustNo,model);
    }


    @ApiOperation("查询机加委托申请详情")
    @GetMapping("info/{entrustNo}")
    public ResultBean getInfo(@PathVariable("entrustNo") String entrustNo){
        return entrustService.getInfo(entrustNo);
    }

    @ApiOperation("查询机加委托申请列表")
    @PostMapping("list")
    public ResultBean getList(@RequestBody EntrustListDTO model){
        return entrustService.getList(model);
    }

    @ApiOperation("更新机加委托申请单状态(发起、开始处理、处理完成)")
    @GetMapping("updateStatus/{entrustNo}/{status}")
    public ResultBean updateStatus(@PathVariable("entrustNo") String entrustNo,@PathVariable("status")Integer status){
        return entrustService.updateStatus(entrustNo,status);
    }

}
