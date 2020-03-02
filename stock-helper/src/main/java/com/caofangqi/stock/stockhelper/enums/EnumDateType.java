package com.caofangqi.stock.stockhelper.enums;

/**
 * @author caofangqi created at 2020/3/2 10:53 PM
 */
public enum EnumDateType {
    DAY(1,"日")

    ;

    EnumDateType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
