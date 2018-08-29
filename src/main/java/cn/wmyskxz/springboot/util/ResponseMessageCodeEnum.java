package cn.wmyskxz.springboot.util;

public enum ResponseMessageCodeEnum {
    SUCCESS("0"),
    ERROR("-1"),
    VALID_ERROR("1000"),
    SAVE_SUCCESS("r0001"),
    UPDATE_SUCCESS("r0002"),
    REMOVE_SUCCESS("r0003");

    private String code;

    private ResponseMessageCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}