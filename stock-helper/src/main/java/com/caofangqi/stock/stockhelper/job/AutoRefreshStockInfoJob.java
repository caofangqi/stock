package com.caofangqi.stock.stockhelper.job;

import com.caofangqi.stock.stockhelper.api.stock.SinaStockCurrentQuotationApi;
import com.caofangqi.stock.stockhelper.domain.dto.StockQuotationDTO;
import com.caofangqi.stock.stockhelper.domain.req.StockApiParam;
import com.caofangqi.stock.stockhelper.entity.Stock;
import com.caofangqi.stock.stockhelper.enums.EnumDateType;
import com.caofangqi.stock.stockhelper.enums.EnumExchange;
import com.caofangqi.stock.stockhelper.manager.StockManager;
import com.caofangqi.stock.stockhelper.manager.StockQuotationManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caofangqi created at 2020/3/2 10:39 PM
 */
@Component
@EnableScheduling
public class AutoRefreshStockInfoJob {


    @Resource
    StockManager stockManager;
    @Resource
    SinaStockCurrentQuotationApi sinaStockCurrentQuotationApi;
    @Resource
    StockQuotationManager stockQuotationManager;



    @Scheduled(cron = "0 0/1 * * * *")
    public void autoRefreshStockInfo() {

        try {
            List<Stock> stockList = stockManager.getRequireRefreshInfoStock();

            stockList
                    .parallelStream()
                    .forEach(stock -> {
                        StockQuotationDTO quotation = sinaStockCurrentQuotationApi.execute(
                                StockApiParam
                                        .builder()
                                        .exchange(EnumExchange.getEnumExchange(stock.getExchange()))
                                        .stockCode(stock.getCode())
                                        .build()
                        );
                        quotation.setStockId(stock.getId());
                        quotation.setDateType(EnumDateType.DAY.getCode());
                        stockQuotationManager.insertOrUpdate(quotation);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
