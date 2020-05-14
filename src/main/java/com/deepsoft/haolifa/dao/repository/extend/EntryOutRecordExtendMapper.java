package com.deepsoft.haolifa.dao.repository.extend;

import com.deepsoft.haolifa.model.dto.export.ExportEntryOutRecordDto;

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

}
