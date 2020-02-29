package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.QualityInspectReport;
import com.deepsoft.haolifa.model.domain.QualityProductReport;

import java.util.List;

public interface QualityInspecReportMapper {

    QualityInspectReport selectInspect();
    List<QualityInspectReport> selectInspectBySupplierName();
    List<QualityInspectReport> selectInspectByMaterialName();

}
