package com.deepsoft.haolifa.model.dto.autoControlEntrust;

import com.deepsoft.haolifa.model.dto.Accessory;
import com.deepsoft.haolifa.model.dto.InspectReason;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class InspectDto {
    @ApiModelProperty("自控单ID")
    private Integer autoControlId;
    @ApiModelProperty("自控单NO")
    private String no;
    @ApiModelProperty("物料图号")
    private String materialGraphNo;
    @ApiModelProperty("物料名称")
    private String materialGraphName;
    @ApiModelProperty("检测数量")
    private Integer testNumber;
    @ApiModelProperty("合格数量")
    private Integer qualifiedNumber;
    @ApiModelProperty("不合格数量")
    private Integer unqualifiedNumber;
    @ApiModelProperty("处理意见")
    private String handlingSuggestion;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("不合格原因列表")
    private List<Accessory> accessoryList;
    @ApiModelProperty("质检附件")
    private List<InspectReason> reasonList;
}
