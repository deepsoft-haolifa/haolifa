package com.deepsoft.haolifa.model.dto.sporadic;

import com.deepsoft.haolifa.model.dto.PageParam;
import com.deepsoft.haolifa.model.dto.storage.BaseStorageDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 零星物料出，入库实体
 *
 * @author murphy.he
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SporadicEntryOutPage extends PageParam {

    @ApiModelProperty(value = "零星物料名称")
    private String materialName;

    @ApiModelProperty(value = "零星物料Id")
    private Integer sporadicId;

    @ApiModelProperty(value = "1出库；2入库", allowableValues = "1,2")
    private Byte type;
}
