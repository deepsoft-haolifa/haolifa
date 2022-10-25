package com.deepsoft.haolifa.model.vo.pay;

import com.deepsoft.haolifa.model.dto.pay.PayOrderUserRelationProcedureDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author liuyaofei
 * @Date create in 下午10:45 2021/11/8
 * @description 订单人员工序关联表VO
 */
@Data
@EqualsAndHashCode()
@ApiModel(description = "工序保存")
public class PayOrderUserRelationProcedureVO {
    @ApiModelProperty(value = "工序list对象")
    private List<PayOrderUserRelationProcedureDTO> payOrderUserRelationProcedureList;

}
