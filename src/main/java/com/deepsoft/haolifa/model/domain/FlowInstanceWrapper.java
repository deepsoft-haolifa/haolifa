package com.deepsoft.haolifa.model.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FlowInstanceWrapper extends FlowInstance {

    private String initUserName;

    private Integer initUserId;

}
