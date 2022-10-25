package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutPage;
import com.deepsoft.haolifa.model.dto.autoControl.AutoControlEntryOutRecordRespVo;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutPage;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutRecordRespVo;

import java.util.List;

/**
 * 自控物料Mapper
 *
 * @author murphy.he
 **/
public interface AutoControlMaterialExtendMapper {

    /**
     * 自控物料出入库记录导出
     *
     * @param params
     * @return
     */
    List<AutoControlEntryOutRecordRespVo> pageRecord(AutoControlEntryOutPage params);

}
