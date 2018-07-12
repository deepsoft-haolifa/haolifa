package com.deepsoft.haolifa.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class AspectLogDTO {
    private String projectName;
    private Date startTime;
    private Date endTime;
    private String methodType;
    private Object request;
    private Object response;
}
