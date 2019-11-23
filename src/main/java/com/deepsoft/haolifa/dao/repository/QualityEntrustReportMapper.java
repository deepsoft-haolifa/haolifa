package com.deepsoft.haolifa.dao.repository;

import com.deepsoft.haolifa.model.domain.QualityEntrustReport;

public interface QualityEntrustReportMapper {

    QualityEntrustReport selectByType(Integer type);

}