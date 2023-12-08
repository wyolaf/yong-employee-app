package com.yong.employee.base;

public enum BaseErrorCode implements IErrorCode {

    SUCCESS("20000", "成功"),
    BUSINESS_ERROR("9998", "操作失败"),
    SYSTEM_ERROR("9999", "系统错误");

    private String code;
    private String msg;

    private BaseErrorCode(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
