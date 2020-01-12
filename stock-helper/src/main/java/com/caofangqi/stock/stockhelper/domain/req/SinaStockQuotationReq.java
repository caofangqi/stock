package com.caofangqi.stock.stockhelper.domain.req;

import com.caofangqi.stock.stockhelper.enums.EnumHttpRequestType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author caofangqi created at 2020/1/11 8:50 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SinaStockQuotationReq implements Serializable {

    private static transient String paramPre = "/list=";

    private static final long serialVersionUID = -7073767156793362946L;

    /**
     * 请求参数
     */
    private String param;
    /**
     * 请求类型
     */
    private EnumHttpRequestType requestType;


   public static SinaStockQuotationReq convert(StockApiParam param){
       if (StringUtils.isEmpty(param.getStockCode())){
           return null;
       }
       return SinaStockQuotationReq
               .builder()
               .requestType(EnumHttpRequestType.GET)
               .param(paramPre+param.getExchange().getCode()+param.getStockCode())
               .build();
   }


}
