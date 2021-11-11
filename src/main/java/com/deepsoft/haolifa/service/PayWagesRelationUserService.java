package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.PayWagesRelationUser;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

public interface PayWagesRelationUserService {
    List<PayWagesRelationUser> getList(PayWagesRelationUser model);

    ResultBean save(PayWagesRelationUser model);

    ResultBean getInfo(Integer id);

    ResultBean edit(PayWagesRelationUser model);

    ResultBean delete(Integer id);
}
