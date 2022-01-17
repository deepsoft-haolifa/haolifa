package com.deepsoft.haolifa.enums;


/***
 *  合同分解狀態 - 审核状态
 */
public enum BillContractAuditStatusEnum {

    // 0未完成；1.完成
    decompose_un("0", "未分解"),
    decompose_underway("1", "分解中"),
    decompose_done("2", "分解完成");

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    BillContractAuditStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
