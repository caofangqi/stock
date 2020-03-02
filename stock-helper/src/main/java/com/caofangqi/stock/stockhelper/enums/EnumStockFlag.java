package com.caofangqi.stock.stockhelper.enums;

/**
 * @author caofangqi created at 2020/3/2 10:47 PM
 */
public enum  EnumStockFlag {
    REQUIRE_ATTENTION(0,"关注的股票"),


    ;


    EnumStockFlag(int code, String description) {
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

