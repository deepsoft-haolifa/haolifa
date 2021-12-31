package com.deepsoft.haolifa.service;


import com.deepsoft.haolifa.model.domain.Material;
import com.deepsoft.haolifa.model.domain.MaterialClassify;
import com.deepsoft.haolifa.model.dto.MaterialClassifyRequestDTO;
import com.deepsoft.haolifa.model.dto.MaterialRequestDTO;
import com.deepsoft.haolifa.model.dto.ResultBean;
import com.deepsoft.haolifa.model.dto.material.MaterialConditionDTO;
import com.deepsoft.haolifa.model.dto.material.MaterialListDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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
     * 根据图号获取零件
     * @param graphNos
     * @return
     */
    List<Material> listByGraphNos(List<String> graphNos);

    /**
     * 获取零件详情（根据主键）
     *
     * @return
     */
    Material getInfoById(int id);

    /**
     * 获取零件分页列表
     *
     * @return
     */
    ResultBean pageInfo(MaterialConditionDTO conditionDTO);

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
     * 根据分类id获取零件列表
     *
     * @param classifyId
     */
    List<Material> getListByClassifyId(int classifyId);

    /**
     * 根据图号获取列表
     *
     * @param graphNo 图号
     */
    List<Material> getListByGraphNoLike(String graphNo);

    /**
     * 根据型号和规格获取列表
     *
     * @param model          型号
     * @param specifications 规格
     */
    List<Material> getListBySingleModelAndSpec(int classifyId, String model, String specifications);

    /**
     * 根据型号和规格获取零件列表（因为零件可以多个型号，多个规格）
     *
     * @param model          型号
     * @param specifications 规格
     */
    List<Material> getListByMultiModelAndSpec(int classifyId, String model, String specifications);

    /**
     * 库存告警列表
     */
    ResultBean getMaterialAlarmList(MaterialConditionDTO model);


    /**
     * 更新零件价格
     */
    void updateMaterialPrice(String graphNo, BigDecimal price);

    /**
     * 获取零件图号列表（根据后缀）
     *
     * @param materialListDTO
     * @return
     */
    List<String> getGraphNoList(MaterialListDTO materialListDTO);

    /**
     * 判断图号是否存在
     *
     * @param graphNo
     * @return
     */
    boolean existsGraphNo(String graphNo);

}
