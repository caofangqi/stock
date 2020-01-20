package com.caofangqi.stock.stockhelper.utils;

/**
 * @author caofangqi created at 2020/1/12 12:35 上午
 */
public class MoneyUtils {


    /**
     * 元转成厘
     */
    public static Long yuanToLi(String value){
        double d = Double.parseDouble(value);
        return (long)d * 1000;
    }
}
