package com.caofangqi.stock.stockhelper.api.stock;

import com.caofangqi.stock.stockhelper.constants.StockQuotationApiConstants;
import com.caofangqi.stock.stockhelper.domain.dto.StockQuotationDTO;
import com.caofangqi.stock.stockhelper.domain.req.SinaStockQuotationReq;
import com.caofangqi.stock.stockhelper.domain.req.StockApiParam;
import com.caofangqi.stock.stockhelper.utils.OkHttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author caofangqi created at 2020/1/11 8:19 下午
 */
@Component
@Slf4j
public class SinaStockQuotationApi  extends AbstractStockQuotationApi<SinaStockQuotationReq> {


    @Resource
    private OkHttpUtils okHttpUtils;

    @Override
    public String request(SinaStockQuotationReq req) {
       return okHttpUtils.get(StockQuotationApiConstants.SINA_STOCK_PRICE_URL,req.getParam());
    }

    /**
     *  var hq_str_sz002427="*ST尤夫,8.900,8.970,9.080,9.170,8.900,9.080,9.090,1034411,9376305.790,20500,9.080,29400,9.070,7000,9.060,11800,9.050,5500,9.030,33200,9.090,17600,9.100,6000,9.110,14200,9.120,3700,9.130,2020-01-10,15:00:03,00";
     * @param result 请求返回数据，格式如上
     */
    @Override
    public StockQuotationDTO parseResponseData(String result,StockApiParam param) {
        if (StringUtils.isBlank(result)){
            return null;
        }
        log.info("新浪请求接口返回数据:"+result);
        String [] sq = result.replace("var hq_str_sz002427=\"","").replace("\";","").split(",");
        StockQuotationDTO
                .builder()
                .code(param.getStockCode())
                .exchange(param.getExchange())
                .name(sq[0])
                .open(Long.parseLong(sq[1])*1000)
                .yesterdayClose(Long.parseLong(sq[2])*1000)
                .current(Long.parseLong(sq[3])*1000)

                .build();

        return null;
    }

    @Override
    public SinaStockQuotationReq wrapRequestData(StockApiParam param) {
        return SinaStockQuotationReq.convert(param);
    }


}
