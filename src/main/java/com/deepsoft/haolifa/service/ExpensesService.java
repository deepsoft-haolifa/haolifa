package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.ExpensesDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

public interface ExpensesService {

    ResultBean save(ExpensesDTO model);

    ResultBean delete(Integer id);

    ResultBean update(ExpensesDTO model);

    ResultBean getList(Integer pageNum, Integer pageSize);
}
