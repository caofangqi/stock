package com.caofangqi.stock.stockhelper.domain.dto;

import com.caofangqi.stock.stockhelper.enums.EnumExchange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author caofangqi created at 2020/1/11 6:20 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockQuotationDTO implements Serializable {


    private static final long serialVersionUID = -2183706988998890068L;
    /**
     * 股票代码
     */
    private String code;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 交易所
     * @see EnumExchange
     */
    private EnumExchange exchange;

    /**
     * 今日开盘价
     * 单位 厘
     */
    private Long open;
    /**
     * 昨日收盘价
     */
    private Long yesterdayClose;
    /**
     * 当前价格
     */
    private Long current;
    /**
     * 今日最高价
     */
    private Long high;
    /**
     * 今日最低价
     */
    private Long low;
    /**
     * 日期
     */
    private LocalDate date;




}
