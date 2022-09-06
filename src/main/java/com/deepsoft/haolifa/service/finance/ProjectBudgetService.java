package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetAddDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetRQDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetRSDTO;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.ProjectBudgetUpDTO;

public interface ProjectBudgetService {
    ResultBean save(ProjectBudgetAddDTO model);

    ResultBean delete(int id);

    ResultBean update(ProjectBudgetUpDTO assetsUpDTO);

    ResultBean<PageDTO<ProjectBudgetRSDTO>> getList(ProjectBudgetRQDTO assetsRQDTO);

}
