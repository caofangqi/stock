package com.caofangqi.stock.stockhelper.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caofangqi.stock.stockhelper.domain.dto.StockQuotationDTO;
import com.caofangqi.stock.stockhelper.entity.StockQuotation;
import com.caofangqi.stock.stockhelper.mapper.StockQuotationMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author caofangqi created at 2020/3/2 10:51 PM
 */
@Component
public class StockQuotationManager {

    @Resource
    StockQuotationMapper stockQuotationMapper;




    public void insertOrUpdate(StockQuotationDTO dto){
        StockQuotation entity = StockQuotation.convert(dto);
        QueryWrapper<StockQuotation> wrapper = new QueryWrapper<>();
        wrapper.eq("date_type", entity.getDateType());
        wrapper.eq("record_date", entity.getRecordDate());
        wrapper.eq("stock_id",entity.getStockId());
        StockQuotation stockQuotation = stockQuotationMapper.selectOne(wrapper);
        if (stockQuotation != null){
            entity.setId(stockQuotation.getId());
            stockQuotationMapper.updateById(entity);
        }else {
            stockQuotationMapper.insert(entity);
        }

    }

}
