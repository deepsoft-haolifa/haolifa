package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayTeamDTO;
import com.deepsoft.haolifa.model.dto.pay.PayTeamVO;

public interface PayTeamService {
    ResultBean pageInfo(PayTeamVO model);

    ResultBean save(PayTeamDTO model);

    ResultBean getInfo(Integer teamId);

    ResultBean edit(PayTeamDTO model);

    ResultBean delete(Integer teamId);
}
