package com.deepsoft.haolifa.model.dto;

import lombok.Data;

import java.util.List;


/**
 * @className: BaseTreeGrid
 * @description: tree结构实体
 * @author: hedong@ibeesaas.com
 * @date: 2019-01-04 16:19
 **/
@Data
public class BaseTreeGrid {

    /**
     * 节点Id
     */
    private Integer id;
    /**
     * 父节点ID
     */
    private Integer pid;

    /**
     * 孩子节点
     */
    private List<BaseTreeGrid> children;

    /**
     * 是否是叶子节点
     */
    private Boolean leaf;

    /**
     * 是否展开
     */
    private Boolean expanded;
}
