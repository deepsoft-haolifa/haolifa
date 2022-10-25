package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.UserPipLineDTO;
import com.deepsoft.haolifa.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finance/t")
@Api(tags = {"好利财务-审批管理"})
public class TController {

    @Autowired
    private SysUserService sysUserService;

    // /finance/t/te
    @ApiOperation("审批流程")
    @GetMapping("/te")
    @Transactional(rollbackFor = Exception.class)
    public ResultBean te() {
        List<UserPipLineDTO> userPipLineDTOS = sysUserService.currentUserPipLine();
        return ResultBean.success(userPipLineDTOS);
    }

}
