package com.deepsoft.haolifa.controller.finance;


import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.assets.*;
import com.deepsoft.haolifa.service.finance.AssetsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 固定资产表
 */
@RestController
@RequestMapping("/finance/assets")
@Api(tags = {"好利财务-固定资产管理"})
public class AssetsController {
    @Autowired
    private AssetsService assetsService;


    @ApiOperation("添加固定资产")
    @PostMapping("/save")
    public ResultBean save(@RequestBody AssetsAddDTO model) {
        return assetsService.save(model);
    }

    @ApiOperation("删除固定资产")
    @GetMapping("/delete/{id}")
    public ResultBean delete(@PathVariable("id") int id) {
        return assetsService.delete(id);
    }

    @ApiOperation("更新固定资产")
    @PostMapping("/updateAssets")
    public ResultBean updateAssets(@RequestBody AssetsUpDTO assetsUpDTO) {
        return assetsService.update(assetsUpDTO);
    }

    @ApiOperation("获取固定资产列表")
    @PostMapping("/getAssetsList")
    public ResultBean<PageDTO<AssetsRSDTO>> getAssetsList(@RequestBody AssetsRQDTO assetsRQDTO) {
        return assetsService.getList(assetsRQDTO);
    }

    @ApiOperation("获取资产金额合计")
    @PostMapping("/getAssetsSum")
    public ResultBean<AssetsSumDTO> getAssetsSum(@RequestBody AssetsRQDTO assetsRQDTO) {
        return assetsService.getAssetsSum(assetsRQDTO);
    }


}
