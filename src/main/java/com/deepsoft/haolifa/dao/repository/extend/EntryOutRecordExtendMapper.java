package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.export.ExportEntryOutRecordDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 通用Mapper
 *
 * @author murphy.he
 **/
public interface EntryOutRecordExtendMapper {

    /**
     * 分页查询成品入库记录，关联订单合同价格
     *
     * @param paramMap
     * @return
     */
    List<ExportEntryOutRecordDto> listProductRecord(Map<String, Object> paramMap);

    /**
     * 分页查询成品出库记录，关联订单
     *
     * @param paramMap
     * @return
     */
    List<ExportEntryOutRecordDto> listOutProductRecord(Map<String, Object> paramMap);

    /**
     * 获取某个月的零件（每个月出库的所有零件的总金额（出库数*单价））
     * @param paramMap
     * @return
     */
    BigDecimal costMaterial(Map<String, Object> paramMap);

    /**
     * 获取零件出库金额，不带M&J&B
     * @param paramMap
     * @return
     */
    BigDecimal costMaterialNotMJB(Map<String, Object> paramMap);

}
