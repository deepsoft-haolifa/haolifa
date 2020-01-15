package com.deepsoft.haolifa.model.dto.sporadic;

import com.deepsoft.haolifa.model.domain.SporadicEntryOutRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SporadicEntryOutRecordRespVo extends SporadicEntryOutRecord {

    private String materialName;
    private String classifyName;
    private String graphNo;

    private String model;

    private String specifications;
}
