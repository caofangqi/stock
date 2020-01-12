package com.caofangqi.stock.stockhelper.domain.req;

import com.caofangqi.stock.stockhelper.enums.EnumExchange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author caofangqi created at 2020/1/11 8:22 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockApiParam implements Serializable {


    private static final long serialVersionUID = 8175915092708745520L;

    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 交易所
     */
    private EnumExchange exchange;




}
