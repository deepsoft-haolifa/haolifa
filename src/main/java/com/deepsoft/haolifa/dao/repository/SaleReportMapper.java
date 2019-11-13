package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.dto.export.ExportSaleDTO;
import com.deepsoft.haolifa.model.dto.export.ExportpPurchaseDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleReportMapper {
    //获取目前总金额总数量
    List<ExportSaleDTO> selectAll();
    //根据月份获取总金额 总数量
    List<ExportSaleDTO> selectByMonth(@Param("startTime") String startTime,@Param("endTime") String endTime);

    //根据产品型号获取金额数量
    List<ExportSaleDTO> selectByModel();

}