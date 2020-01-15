package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.InspectItemSumDto;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutPage;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicEntryOutRecordRespVo;
import com.deepsoft.haolifa.model.dto.sporadic.SporadicMaterialPageDto;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 零星零件Mapper
 *
 * @author murphy.he
 **/
public interface SporadicMaterialExtendMapper {

    /**
     * 零星零件出入库记录导出
     *
     * @param params
     * @return
     */
    List<SporadicEntryOutRecordRespVo> pageRecord(SporadicEntryOutPage params);

}
