package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizProjectBudget;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.projectbudget.*;

public interface ProjectBudgetService {
    ResultBean save(ProjectBudgetAddDTO model);

    ResultBean delete(int id);

    ResultBean update(ProjectBudgetUpDTO assetsUpDTO);

    ResultBean<PageDTO<ProjectBudgetRSDTO>> getList(ProjectBudgetRQDTO assetsRQDTO);

    ResultBean<PageDTO<ProjectBudgetRSDTO>> getCurUserProjectBudgetList(ProjectBudgetRQDTO assetsRQDTO);


    BizProjectBudget queryCurMonthBudget(ProjectBudgetQueryBO queryBO);
}
