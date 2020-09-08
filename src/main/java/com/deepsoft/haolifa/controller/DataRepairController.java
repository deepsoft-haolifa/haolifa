package com.deepsoft.haolifa.controller;

import cn.hutool.json.JSONUtil;
import com.deepsoft.haolifa.dao.repository.StockMapper;
import com.deepsoft.haolifa.dao.repository.extend.CommonExtendMapper;
import com.deepsoft.haolifa.model.domain.Stock;
import com.deepsoft.haolifa.model.domain.StockExample;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.SysLogConditionDTO;
import com.deepsoft.haolifa.model.vo.DataRepairVO;
import com.deepsoft.haolifa.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Api(tags = {"数据修复"})
@RestController
@RequestMapping("/sys-log")
@Slf4j
public class DataRepairController {
    @Resource
    private CommonExtendMapper commonExtendMapper;

    @Resource
    private StockMapper stockMapper;

    @PostMapping("repairStock")
    @ApiOperation("修复批次号库存和主库存不一致的数据")
    public ResultBean repairStock() {
        List<DataRepairVO> dataRepairVOS = commonExtendMapper.checkStock();
        for (DataRepairVO repairVO : dataRepairVOS) {
            log.info("repari:{}", JSONUtil.toJsonStr(repairVO));
            String graphNo = repairVO.getGraphNo();
            StockExample stockExample = new StockExample();
            stockExample.or().andMaterialGraphNoEqualTo(graphNo).andQuantityGreaterThan(0);
            List<Stock> stockList = stockMapper.selectByExample(stockExample);
            for (Stock stock : stockList) {
                Integer quantity = stock.getQuantity();
                if (quantity >= repairVO.getQty()) {
                    Stock updateStock = new Stock();
                    updateStock.setId(stock.getId());
                    updateStock.setQuantity(quantity - repairVO.getQty());
                    stockMapper.updateByPrimaryKeySelective(updateStock);
                    break;
                }
            }
        }

        return null;
    }

    @PostMapping("repairStock-max")
    @ApiOperation("修复批次号库存和主库存不一致的数据")
    public ResultBean repairStockMax() {
        List<DataRepairVO> dataRepairVOS = commonExtendMapper.checkStock();
        for (DataRepairVO repairVO : dataRepairVOS) {
            log.info("repari:{}", JSONUtil.toJsonStr(repairVO));
            String graphNo = repairVO.getGraphNo();
            StockExample stockExample = new StockExample();
            stockExample.or().andMaterialGraphNoEqualTo(graphNo).andQuantityGreaterThan(0);
            List<Stock> stockList = stockMapper.selectByExample(stockExample);
            int qq = repairVO.getQty();
            for (Stock stock : stockList) {
                Integer quantity = stock.getQuantity();
                int cqq = qq - quantity;
                if (cqq > 0) {
                    Stock updateStock = new Stock();
                    updateStock.setId(stock.getId());
                    updateStock.setQuantity(0);
                    stockMapper.updateByPrimaryKeySelective(updateStock);
                    qq = cqq;
                } else {
                    Stock updateStock = new Stock();
                    updateStock.setId(stock.getId());
                    updateStock.setQuantity(-cqq);
                    stockMapper.updateByPrimaryKeySelective(updateStock);
                    break;
                }
            }
        }
        return null;
    }
}
