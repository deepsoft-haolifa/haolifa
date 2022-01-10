package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.AutoControlMaterial;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutDto;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutPage;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutRecordRespVo;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlMaterialPageDto;

/**
 * @author murphy.he
 **/
public interface AutoControlMaterialService {
    /**
     * 新增自控物资
     */
    int add(AutoControlMaterial material);

    /**
     * 编辑自控物资
     */
    int update(AutoControlMaterial material);
    /**
     * 删除自控物资
     */
    int del(int id);
    /**
     * 自控物资分页列表
     */
    PageDTO<AutoControlMaterial> pageList(AutoControlMaterialPageDto pageDto);

    /**
     * 根据图号获取详情
     *
     * @param graphNo
     * @return
     */
    AutoControlMaterial infoByNo(String graphNo);


    /**
     * 自控物资入库
     */
    int entry(AutoControlEntryOutDto entryOutDto);

    /**
     * 自控物资出库
     */
    int out(AutoControlEntryOutDto entryOutDto);

    /**
     * 自控物资出入库详情
     */
    PageDTO<AutoControlEntryOutRecordRespVo> entryOutPage(AutoControlEntryOutPage entryOutDto);
}
