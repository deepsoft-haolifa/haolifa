package com.deepsoft.haolifa.service;


import com.deepsoft.haolifa.model.domain.MaterialClassify;
import com.deepsoft.haolifa.model.dto.MaterialClassifyRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

/**
 * 原料管理接口
 */
public interface MaterialService {

    /**
     * 添加原料分类
     *
     * @param model 分类名称
     * @return
     */
    ResultBean saveClassify(MaterialClassifyRequestDTO model);


    /**
     * 更新原料分类
     *
     * @param id
     * @param classifyName
     * @return
     */
    ResultBean updateClassify(int id, String classifyName);

    /**
     * 删除成品分类
     *
     * @return
     */
    ResultBean deleteClassify(int id);

    /**
     * 删除成品分类
     *
     * @return
     */
    List<MaterialClassify> listClassify();

    /**
     * 获取原料分页列表
     *
     * @param currentPage 页码
     * @param pageSize 页数
     * @param classifyNameLike 分类名称
     * @return
     */
    ResultBean pageInfoClassify(Integer currentPage, Integer pageSize,String classifyNameLike);
}
