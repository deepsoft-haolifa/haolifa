package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.pay.PayProductionWorkshopDTO;
import com.deepsoft.haolifa.model.dto.pay.PayProductionWorkshopVO;

public interface PayProductionWorkShopService {
    ResultBean pageInfo(PayProductionWorkshopVO model);

    ResultBean save(PayProductionWorkshopDTO model);

    ResultBean getInfo(Integer workId);

    ResultBean edit(PayProductionWorkshopDTO model);

    ResultBean delete(Integer workId);

    ResultBean getList();

    ResultBean getDepartDistinctList();


    }
