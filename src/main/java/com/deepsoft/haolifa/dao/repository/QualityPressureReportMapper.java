package com.deepsoft.haolifa.dao.repository;


import com.deepsoft.haolifa.model.domain.QualityPressureReport;

import java.util.List;

public interface QualityPressureReportMapper {

    QualityPressureReport selectPressure();
    List<QualityPressureReport> selectPressureByReason();

}
