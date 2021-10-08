package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkAttendancePageDTO;

import java.util.List;

public interface PayWorkAttendanceService {
    ResultBean pageInfo(PayWorkAttendancePageDTO model);

    void insert(List<PayWorkAttendance> objects);
}
