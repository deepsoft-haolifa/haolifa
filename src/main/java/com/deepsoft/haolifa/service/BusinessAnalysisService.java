package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.dto.businessAnalysis.BusinessAnalysisDTO;

/**
 * @author murphy.he
 **/
public interface BusinessAnalysisService {

    /**
     * 生成 经营分析数据
     * 默认有定时任务，一天生成一次，也可以手动执行
     *
     * @param year 年份
     */
    void generate(String year);

    /**
     * 获取最新生成的经营分析数据
     *
     * @param year
     * @return
     */
    BusinessAnalysisDTO get(String year);
}
