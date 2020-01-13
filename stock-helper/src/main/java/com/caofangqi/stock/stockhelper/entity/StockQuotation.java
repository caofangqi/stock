package com.caofangqi.stock.stockhelper.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author caofangqi
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StockQuotation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * stock 表主键ID
     */
    private Long stockId;

    /**
     * 价格记录日期，天，周，月。
     */
    private LocalDate recordDate;

    /**
     * 开盘价，单位厘
     */
    private Long openPrice;

    /**
     * 日期内最高价，单位厘
     */
    private Long highPrice;

    /**
     * 收盘价,单位厘
     */
    private Long closePrice;

    /**
     * 最低价格，单位厘
     */
    private Long lowPrice;

    /**
     * 价格变化。
     */
    private Long priceChange;

    /**
     * 时间纬度类型,天，月，几日。
     */
    private Integer dateType;


}
