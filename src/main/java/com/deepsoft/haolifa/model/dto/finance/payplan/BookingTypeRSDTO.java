package com.deepsoft.haolifa.model.dto.finance.payplan;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/***
 * 付款方式
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BookingTypeRSDTO {


    @ApiModelProperty(value = "code")
    private String code;
    @ApiModelProperty(value = "desc")
    private String desc;
    @ApiModelProperty(value = "payWayList")
    private List<PayWay> wayList;


    @Data
  public static class PayWay {
        @ApiModelProperty(value = "code")
        private String code;
        @ApiModelProperty(value = "desc")
        private String desc;
    }

}
