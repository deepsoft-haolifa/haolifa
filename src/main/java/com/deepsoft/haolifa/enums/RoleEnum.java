package com.deepsoft.haolifa.enums;

public enum RoleEnum {

    ROLE_ADMIN("ROLE_ADMIN", "系统管理员"),
    ROLE_ZJL("ROLE_ZJL", "总经理"),
    ROLE_ZGKJ("ROLE_ZGKJ", "主管会计"),
    ROLE_CWGLZXFZR("ROLE_CWGLZXFZR", "财务管理中心负责人"),
    //    销售会计	ROLE_XSKJ
    ROLE_XSKJ("ROLE_XSKJ", "销售会计"),
    ROLE_CN("ROLE_CN", "出纳");

    //总经理、财务经理、主管会计、出纳
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
