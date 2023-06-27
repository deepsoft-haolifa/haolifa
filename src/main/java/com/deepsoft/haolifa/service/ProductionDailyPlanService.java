package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.ProductionDailyPlan;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.productionPlan.ProductionDailyPlanConditionDto;
import com.deepsoft.haolifa.model.dto.productionPlan.ProductionDailyPlanReqDto;
import com.deepsoft.haolifa.model.dto.valveSeat.ValveSeatEntrustConditionDto;

/**
 * @author murphy.he
 **/
public interface ProductionDailyPlanService {
    /**
     * 新增
     */
    public int add(ProductionDailyPlanReqDto reqDto);

    /**
     * 更新
     */
    public int update(ProductionDailyPlanReqDto reqDto);

    /**
     * 删除
     */
    public int delete(Integer id);

    /**
     * 分页查询
     */
    public PageDTO<ProductionDailyPlan> pageList(ProductionDailyPlanConditionDto pageDto);

}
