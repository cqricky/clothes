package com.ricky.clothes.constant;

/**
 * Created by caiqing on 16/3/3.
 */
public enum  EnumLocation {
    KAIKAI(0,"KK"),
    RICKY(1, "Ricky");

    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private EnumLocation(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
