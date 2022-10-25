package com.deepsoft.haolifa.service;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.model.domain.PayWorkAttendance;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayWorkAttendancePageDTO;
import com.deepsoft.haolifa.model.dto.pay.PayWorkingProcedureDTO;

import java.util.List;

public interface PayWorkAttendanceService {
    ResultBean pageInfo(PayWorkAttendancePageDTO model);

    void insert(List<PayWorkAttendance> objects);

    ResultBean save(PayWorkAttendancePageDTO model);

    ResultBean getInfo(Integer id);

    ResultBean edit(PayWorkAttendancePageDTO model);

    ResultBean delete(Integer id);

    ExcelWriter export(PayWorkAttendancePageDTO payWorkAttendancePageDTO);

    void createAttendance(PayWorkAttendancePageDTO payWorkAttendancePageDTO) throws Exception;

}
