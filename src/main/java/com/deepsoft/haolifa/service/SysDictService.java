package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.SysDict;

import java.util.List;

/**
 * @className: SysDictService
 * @description: 字典表Service
 * @date: 2019-05-09 14:52
 **/
public interface SysDictService {

    /**
     * 根据typeCode获取字典列表
     *
     * @param typeCode
     * @return
     */
    List<SysDict> getSysDictByTypeCode(String typeCode);


}
