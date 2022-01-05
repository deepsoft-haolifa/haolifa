package com.deepsoft.haolifa.enums;

public enum RoleEnum {

    ROLE_ADMIN("ROLE_ADMIN", "系统管理员	"),
    ROLE_CN("ROLE_CN", "出纳");

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

    RoleEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
