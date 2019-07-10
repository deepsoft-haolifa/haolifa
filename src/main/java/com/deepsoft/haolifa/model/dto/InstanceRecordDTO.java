package com.deepsoft.haolifa.model.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InstanceRecordDTO {

    private List<HistoryInfo> historyInfos;

    private HistoryInfo dealStep;

    private String summary;

    private String formNo;

    private Integer formId;

    private String initUserName;

    private Integer initUserId;

    private Date createTime;

    private Integer instanceId;

    private List<Accessory> accessories;

}
