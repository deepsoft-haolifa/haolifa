package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.assets.*;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyAddDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyRQDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyRSDTO;
import com.deepsoft.haolifa.model.dto.finance.company.CompanyUpDTO;
import com.deepsoft.haolifa.service.finance.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 公司单位
 */
@RestController
@RequestMapping("/finance/company")
@Api(tags = {"好利财务-公司单位"})
public class CompanyController {
    @Autowired
    private CompanyService assetsService;


    @ApiOperation("添加公司单位")
    @PostMapping("/save")
    public ResultBean save(@RequestBody CompanyAddDTO model) {
        return assetsService.save(model);
    }

    @ApiOperation("删除公司单位")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") int id) {
        return assetsService.delete(id);
    }

    @ApiOperation("更新公司单位")
    @PostMapping("/updateCompany")
    public ResultBean updateCompany(@RequestBody CompanyUpDTO assetsUpDTO) {
        return assetsService.update(assetsUpDTO);
    }

    @ApiOperation("获取公司单位列表")
    @PostMapping("/getCompanyList")
    public ResultBean<PageDTO<CompanyRSDTO>> getCompanyList(@RequestBody CompanyRQDTO assetsRQDTO) {
        return assetsService.getList(assetsRQDTO);
    }


}
