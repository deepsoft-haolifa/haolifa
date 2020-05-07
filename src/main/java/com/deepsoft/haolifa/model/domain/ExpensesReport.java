package com.deepsoft.haolifa.model.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

@Data
public class ExpensesReport {
    private BigDecimal totalAmount;

    private String secondClassify;

    private String expensesClassify;

    @DateTimeFormat(pattern = "yyyy-MM")
    private String createTime;

    private String dataMonth;

    private String department;


}
