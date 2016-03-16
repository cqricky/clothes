package com.ricky.clothes.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caiqing on 16/3/3.
 */
public enum  EnumLocation {
    KAIKAI(0,"KK"),
    RICKY(1, "Ricky");

    private static Map<String, EnumLocation> locations = new HashMap<String, EnumLocation>();

    static {
//        locations.put(new Integer())
    }
    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

//    public static EnumLocation forValue(String value) {
//        return
//    }

    @JsonValue
    public int toValue(){
        return this.getCode();
    }


    private EnumLocation(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
