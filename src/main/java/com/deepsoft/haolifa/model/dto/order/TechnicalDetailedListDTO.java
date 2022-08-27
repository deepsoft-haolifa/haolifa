package com.deepsoft.haolifa.model.dto.order;

import com.deepsoft.haolifa.model.domain.OrderTechnicalDetailedRel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author murphy.he
 **/
@Data
public class TechnicalDetailedListDTO {

    @ApiModelProperty("技术清单列表")
    public List<OrderTechnicalDetailedRel> technicalDetailedRels;

}
