package com.deepsoft.haolifa.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class HistoryInfo {

    private Integer historyId;
    private Integer instanceId;
    private Integer flowId;
    private Integer stepId;
    private String auditInfo;
    private Integer allotUserId;
    private Integer auditResult;
    private Integer formId;
    private Integer formType;
    private String formNo;
    private String stepName;
    private String auditUserName;
    private Integer auditUserId;
    private Date createTime;
    private String accessory;

    private List<Accessory> accessories;

    private List<Map<String,Integer>> forms;

}
