package com.caofangqi.stock.stockhelper.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 股票
 * </p>
 *
 * @author caofangqi
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

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
     */
    private Integer exchange;

    /**
     * 股票状态
     */
    private Integer status;

    /**
     * 股票标记 flag 我对于股票的定义
     * @see com.caofangqi.stock.stockhelper.enums.EnumStockFlag
     */
    private Integer flag;

    /**
     * 所属行业
     */
    private String industry;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;


}
