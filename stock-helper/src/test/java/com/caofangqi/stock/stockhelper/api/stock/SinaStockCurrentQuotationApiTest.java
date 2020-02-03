package com.caofangqi.stock.stockhelper.api.stock;

import com.caofangqi.stock.stockhelper.domain.req.StockApiParam;
import com.caofangqi.stock.stockhelper.enums.EnumExchange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author caofangqi created at 2020/1/11 10:08 下午
 */
@SpringBootTest
public class SinaStockCurrentQuotationApiTest {


    @Resource
    SinaStockCurrentQuotationApi sinaStockCurrentQuotationApi;


    @Test
    public void testSina(){
        StockApiParam param = StockApiParam.builder()
                .stockCode("002427")
                .exchange(EnumExchange.SZ_EXCHANGE)
                .build();
        System.out.printf(">>>>>>>:"+ sinaStockCurrentQuotationApi.execute(param));

    }

}
