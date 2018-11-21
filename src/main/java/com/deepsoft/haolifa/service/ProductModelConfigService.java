package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.ProductModelConfig;

import java.util.List;

public interface ProductModelConfigService {

    /**
     * 根据type和索引规则 获取信息
     *
     * @param type
     * @param indexRule
     * @return
     */
    List<ProductModelConfig> getList(int type, String indexRule);

    /**
     * 新增成品模型规则
     *
     * @return
     */
    int add(ProductModelConfig model);

    /**
     * 删除成品模型规则
     *
     * @param type
     * @param indexRule
     * @return
     */
    int delete(int type, String indexRule);

    /**
     * 更新成品模型规则
     *
     * @return
     */
    int update(ProductModelConfig model);
}
