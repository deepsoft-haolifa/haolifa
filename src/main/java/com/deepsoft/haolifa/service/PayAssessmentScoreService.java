package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayAssessmentScoreDTO;

public interface PayAssessmentScoreService {
    ResultBean pageInfo(Integer pageNum, Integer pageSize);

    ResultBean save(PayAssessmentScoreDTO model) throws Exception;

    ResultBean getInfo(Integer assessId);

    ResultBean edit(PayAssessmentScoreDTO model);

    ResultBean delete(Integer scoreId);

}
