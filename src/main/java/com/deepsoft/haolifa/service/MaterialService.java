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
     * @return
     */
    ResultBean updateClassify(MaterialClassifyRequestDTO model);

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
     * 获取零件分类详情
     *
     * @return
     */
    MaterialClassify getClassifyInfo(int id);

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
    ResultBean pageInfo(Integer currentPage, Integer pageSize, String classifyNameLike, String nameLike, String graphNoLike, int status);

    /**
     * 更新零件当前数量
     *
     * @param graphNo  图号
     * @param quantity 数量（正数增加，负数减少）
     * @return
     */
    int updateCurrentQuantity(String graphNo, int quantity);

    /**
     * 更新零件锁定数量
     *
     * @param graphNo  图号
     * @param quantity 数量（正数增加，负数减少）
     * @return
     */
    int updateLockQuantity(String graphNo, int quantity);

    /**
     * 根据分类id获取列表
     *
     * @param classifyId
     */
    List<Material> getListByClassifyId(int classifyId);

}
