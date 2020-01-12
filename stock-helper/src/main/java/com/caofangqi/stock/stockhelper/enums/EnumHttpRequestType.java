package com.caofangqi.stock.stockhelper.enums;

/**
 * @author caofangqi created at 2020/1/11 9:17 下午
 */
public enum EnumHttpRequestType {

    POST(1,"post"),
    GET(2,"get"),

    ;


    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    EnumHttpRequestType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
