package com.deepsoft.haolifa.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.deepsoft.haolifa.constant.CommonEnum;
import com.deepsoft.haolifa.model.domain.MaterialRequisition;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;
import com.deepsoft.haolifa.service.MaterialRequisitionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 领料表Controller
 *
 * @author murphy.he
 **/
@Api(tags = {"领料单管理"})
@RestController
@RequestMapping("/material-requisition")
public class MaterialRequisitionController {

    @Resource
    private MaterialRequisitionService materialRequisitionService;

    @PostMapping("save")
    @ApiOperation(value = "保存领料单")
    public ResultBean save(@RequestBody List<MaterialRequisition> materialRequisition) {
        boolean b = materialRequisitionService.addBatch(materialRequisition);
        if (b) {
            return ResultBean.success(b);
        }
        return ResultBean.error(CommonEnum.ResponseEnum.SYSTEM_EXCEPTION);

    }

    @GetMapping("info")
    @ApiOperation(value = "领料单详情")
    public ResultBean info(@RequestParam("orderNo") String orderNo) {
        return ResultBean.success(materialRequisitionService.list(new LambdaQueryWrapper<MaterialRequisition>().eq(MaterialRequisition::getOrderNo, orderNo)));
    }

}
