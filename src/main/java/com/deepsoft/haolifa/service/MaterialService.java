package com.deepsoft.haolifa.service;


import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialClassify;
import com.deepsoft.haolifa.model.dto.MaterialClassifyRequestDTO;
import com.deepsoft.haolifa.model.dto.MaterialRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;

import java.util.List;

/**
 * 零件管理接口
 */
public interface MaterialService {

    /**
     * 添加零件分类
     *
     * @param model 分类名称
     * @return
     */
    ResultBean saveClassify(MaterialClassifyRequestDTO model);


    /**
     * 更新零件分类
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
     * 删除零件分类
     *
     * @return
     */
    List<MaterialClassify> listClassify();

    /**
     * 获取零件分页列表
     *
     * @param currentPage      页码
     * @param pageSize         页数
     * @param classifyNameLike 分类名称
     * @return
     */
    ResultBean pageInfoClassify(Integer currentPage, Integer pageSize, String classifyNameLike);

    /**
     * 添加零件
     *
     * @return
     */
    ResultBean save(MaterialRequestDTO model);


    /**
     * 更新零件
     *
     * @param model
     * @return
     */
    ResultBean update(MaterialRequestDTO model);

    /**
     * 删除零件
     *
     * @return
     */
    ResultBean delete(int id);

    /**
     * 获取零件详情（根据图号）
     *
     * @return
     */
    Material getInfoByGraphNo(String graphNo);

    /**
     * 获取零件详情（根据主键）
     *
     * @return
     */
    Material getInfoById(int id);

    /**
     * 获取零件分页列表
     *
     * @param currentPage      页码
     * @param pageSize         页数
     * @param classifyNameLike 分类名称
     * @param nameLike         名称
     * @param graphNoLike      图号
     * @return
     */
    ResultBean pageInfo(Integer currentPage, Integer pageSize, String classifyNameLike, String nameLike, String graphNoLike,int status);
}
