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
}
