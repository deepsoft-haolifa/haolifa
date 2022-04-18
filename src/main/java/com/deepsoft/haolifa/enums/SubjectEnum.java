package com.deepsoft.haolifa.enums;


/***
 * 字典表 key
 */
public enum SubjectEnum {

    clf_id(114, "材料费"),

    ;
    private Integer code;
    private String desc;

    SubjectEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
