package com.deepsoft.haolifa.service;

import com.deepsoft.haolifa.model.domain.EntryOutStoreRecord;
import com.deepsoft.haolifa.model.domain.SporadicEntryOutRecord;
import com.deepsoft.haolifa.model.domain.SporadicMaterial;
import com.deepsoft.haolifa.model.dto.PageDTO;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutDto;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutPage;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutRecordRespVo;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicMaterialPageDto;

/**
 * @author murphy.he
 **/
public interface SporadicMaterialService {
    /**
     * 新增零星物资
     */
    int add(SporadicMaterial material);

    /**
     * 编辑零星物资
     */
    int update(SporadicMaterial material);
    /**
     * 删除零星物资
     */
    int del(int id);
    /**
     * 零星物资分页列表
     */
    PageDTO<SporadicMaterial> pageList(SporadicMaterialPageDto pageDto);

    /**
     * 根据图号获取详情
     *
     * @param graphNo
     * @return
     */
    SporadicMaterial infoByNo(String graphNo);


    /**
     * 零星物资入库
     */
    int entry(SporadicEntryOutDto entryOutDto);

    /**
     * 零星物资出库
     */
    int out(SporadicEntryOutDto entryOutDto);

    /**
     * 零星物资出入库详情
     */
    PageDTO<SporadicEntryOutRecordRespVo> entryOutPage(SporadicEntryOutPage entryOutDto);
}
