package com.deepsoft.haolifa.model.dto.autoControl;

import com.deepsoft.haolifa.model.domain.AutoControlEntryOutRecord;
import com.deepsoft.haolifa.model.domain.SporadicEntryOutRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class AutoControlEntryOutRecordRespVo extends AutoControlEntryOutRecord {

    private String materialName;
    private String classifyName;
    private String graphNo;

    private String model;

    private String specifications;

    private BigDecimal price;
}
