package com.deepsoft.haolifa.service.finance;

import com.deepsoft.haolifa.model.domain.BizCostBudget;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.finance.costbudget.BizCostBudgetAddDTO;
import com.deepsoft.haolifa.model.dto.finance.costbudget.BizCostBudgetDTO;

import java.util.List;

public interface CostBudgetService {

    /**
     * 添加
     *
     * @param model
     * @return
     */
    ResultBean save(BizCostBudgetAddDTO model);


    /**
     * 删除
     *
     * @param id
     * @return
     */
    ResultBean delete(Integer id);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    ResultBean update(BizCostBudget model);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    ResultBean getInfo(Integer id);

    /**
     * 获取列表
     *
     * @param model
     * @return
     */
    ResultBean getList(BizCostBudgetDTO model);
    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    ResultBean deleteBatch(List<Integer> ids);
}
