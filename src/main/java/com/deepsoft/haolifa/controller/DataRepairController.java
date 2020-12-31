package com.deepsoft.haolifa.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.deepsoft.haolifa.dao.repository.MaterialMapper;
import com.deepsoft.haolifa.dao.repository.StockMapper;
import com.deepsoft.haolifa.dao.repository.extend.CommonExtendMapper;
import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialExample;
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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Api(tags = {"数据修复"})
@RestController
@RequestMapping("/sys-log")
@Slf4j
public class DataRepairController {
    @Resource
    private CommonExtendMapper commonExtendMapper;

    @Resource
    private StockMapper stockMapper;

    @Resource
    private MaterialMapper materialMapper;

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

    @PostMapping("stock-out-material")
    @ApiOperation("盘点零件")
    public void stockOutMaterial() throws IOException {
        List<String> noSystemNoList = new ArrayList<>();
        List<String> excelNoList = new ArrayList<>();
        List<String> systemNoExcelList = new ArrayList<>();
        // 1. 先获取系统中所有的图号（阀体，阀座，阀板，阀杆）
        MaterialExample example = new MaterialExample();
        example.or().andMaterialClassifyIdIn(Stream.of(1, 2, 3, 4).collect(Collectors.toList()));
        List<Material> materials = materialMapper.selectByExample(example);
        log.info("stock out material list:{}", materials.size());
        List<String> graphNoList = materials.stream().map(Material::getGraphNo).collect(Collectors.toList());
        BufferedReader br = new BufferedReader(new FileReader("D://abc.xlsx"));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] split = line.split(",");
            String trueGraphNo = split[0];
            Integer trueQuantity = Integer.valueOf(split[1]);
            if (graphNoList.contains(trueGraphNo)) {
                this.changeStockQty(trueGraphNo, trueQuantity);
                excelNoList.add(trueGraphNo);
            } else {
                log.info("stock out material system no graph no:{}", trueGraphNo);
                noSystemNoList.add(trueGraphNo);
            }
        }
        // 系统中有，盘点表里面没有，则将系统中的图号的库存都清零
        graphNoList.forEach(e -> {
            if (!excelNoList.contains(e)) {
                log.info("excel not null bug system exist:{}", e);
                this.changeStockQty(e, 0);
                systemNoExcelList.add(e);
            }
        });

        // excel中有，系统中没有的数据
        if (CollectionUtil.isNotEmpty(noSystemNoList)) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("d://excelExists.txt"));
            for (String no : noSystemNoList) {
                bw.write(no);
                bw.flush();
            }
            bw.close();
        }
        // 系统中有，excel中没有的数据
        if (CollectionUtil.isNotEmpty(systemNoExcelList)) {
            BufferedWriter bw = new BufferedWriter(new FileWriter("d://systemExists.txt"));
            for (String no : systemNoExcelList) {
                bw.write(no);
                bw.flush();
            }
            bw.close();
        }
    }

    private void changeStockQty(String graphNo, Integer qty) {
        if (true) {
            return;
        }
        // 1.更新零件信息库的库存； 可用库存更新为表格的数据； 锁定库存更新为0；
        MaterialExample example = new MaterialExample();
        example.or().andGraphNoEqualTo(graphNo);
        Material update = new Material() {{
            setLockQuantity(0);
            setCurrentQuantity(qty);
        }};
        materialMapper.updateByExampleSelective(update, example);

        // 2.更新原来的库存表数据为0
        StockExample stockExample = new StockExample();
        stockExample.or().andMaterialGraphNoEqualTo(graphNo);
        Stock stockUpdate = new Stock() {{
            setQuantity(0);
            setRemark("2021盘点更新库存为0");
        }};
        stockMapper.updateByExampleSelective(stockUpdate, stockExample);

        // 3. 插入新的库存数据
        if (qty > 0) {
            Stock insertStock = new Stock() {{
                setMaterialGraphNo(graphNo);
                setMaterialBatchNo("20200101");
                setQuantity(qty);
                setType((byte) 2);
                setRemark("2021盘点新增");
                setRoomNo("");
                setRackNo("");
            }};
            stockMapper.insertSelective(insertStock);
        }
    }
}
