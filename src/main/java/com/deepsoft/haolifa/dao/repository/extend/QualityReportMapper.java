package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.domain.QualityProductReport;
import com.deepsoft.haolifa.model.dto.export.ExportQualityDto;
import com.deepsoft.haolifa.model.dto.export.ReportAssemblingReasonDto;

import java.util.List;
import java.util.Map;

/**
 * 质量报表sql
 *
 * @author murphy.he
 **/
public interface QualityReportMapper {
    /**
     * 装配不合格原因(json 数组，需要自己解析下)
     *
     * @return
     */
    List<String> selectAssemblingReason();

    /**
     * 机加工零件、采购送检零件 合格质量
     *
     * @return
     */
    QualityProductReport selectInspectHistoryByType(Map<String, Object> paramMap);

    /**
     * 按月统计零件采购合格率
     *
     * @return
     */
    List<QualityProductReport> selectPurchasePassByMonth(Map<String, Object> paramMap);

    /**
     * 按月统计零件加工合格率
     *
     * @return
     */
    List<QualityProductReport> selectInspectPassByMonth(Map<String, Object> paramMap);
    /**
     * 按月统计喷涂合格率
     *
     * @return
     */
    List<QualityProductReport> selectSparyPassByMonth(Map<String, Object> paramMap);
    /**
     * 按月统计成品合格率
     *
     * @return
     */
    List<QualityProductReport> selectProInspectPassByMonth(Map<String, Object> paramMap);

}
