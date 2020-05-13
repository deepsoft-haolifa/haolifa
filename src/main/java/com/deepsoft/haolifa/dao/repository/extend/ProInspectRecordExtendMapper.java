package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.InspectItemSumDto;
import com.deepsoft.haolifa.model.dto.export.ProInspectRecordDto;
import com.deepsoft.haolifa.model.vo.PreOutMaterialPageVo;
import com.deepsoft.haolifa.model.vo.PreOutMaterialVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 通用Mapper
 *
 * @author murphy.he
 **/
public interface ProInspectRecordExtendMapper {

    /**
     * 分页查询成品入库，关联订单合同价格
     *
     * @param paramMap
     * @return
     */
    List<ProInspectRecordDto> listProInspectRecord(Map<String,Object> paramMap);

}
