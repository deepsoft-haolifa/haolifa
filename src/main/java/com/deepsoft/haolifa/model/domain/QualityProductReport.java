package com.deepsoft.haolifa.model.domain;

import lombok.Data;

/**
 * 质量报表
 */
@Data
public class QualityProductReport {
    private String createTime;
    private Integer totalNum;
    private Integer qualifiedNumber;
    private Integer unqualifiedNumber;

}
