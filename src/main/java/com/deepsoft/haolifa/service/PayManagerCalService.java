package com.deepsoft.haolifa.service;

import cn.hutool.poi.excel.ExcelWriter;
import com.deepsoft.haolifa.model.domain.PayManagerCal;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayManagerCalPageDTO;

import java.util.List;

public interface PayManagerCalService {

    ResultBean pageInfo(PayManagerCalPageDTO model);

    ResultBean save(PayManagerCalDTO model);

    ResultBean getInfo(Integer id);

    ResultBean edit(PayManagerCalDTO model);

    ResultBean delete(Integer id);

    List<PayManagerCal> getList(PayManagerCalDTO payManagerCalDTO);

    ResultBean save(List<PayManagerCalDTO> model);

    ExcelWriter export(PayManagerCalDTO payManagerCalDTO);

}
