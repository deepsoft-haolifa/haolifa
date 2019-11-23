package com.deepsoft.haolifa.dao.repository;


import com.deepsoft.haolifa.model.domain.QualityAuditReport;

import java.util.List;

public interface QualityAuditReportMapper {

    List<QualityAuditReport> selectAudit();

}