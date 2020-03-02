package com.caofangqi.stock.stockhelper.enums;

import java.util.Arrays;

/**
 * @author caofangqi created at 2020/1/11 6:21 下午
 */
public enum  EnumExchange {

    SH_EXCHANGE(1,"sh","上海证券交易所"),
    SZ_EXCHANGE(2,"sz","深圳证券交易所"),


    ;
    private Integer value;
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumExchange getEnumExchange(Integer value){
        return Arrays.stream(EnumExchange.values())
                .filter(v->v.getValue().equals(value))
                .findFirst().orElse(null);
    }

    EnumExchange(Integer value, String code, String name) {
        this.value = value;
        this.code = code;
        this.name = name;
    }
}
