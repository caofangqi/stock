package com.caofangqi.stock.stockhelper.api;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author caofangqi created at 2020/1/11 6:08 下午
 */
@Slf4j
public abstract class AbstractRequestApi<T, R, P> implements RequestApi<T, R, P> {


    @Override
    public T execute(P param) {

        if (param == null){
            return null;
        }

        R req = null;
        String result = null;

        try {
            //包装请求参数
            req = wrapRequestData(param);
            //请求Api
            result = request(req);
            //解析数据
            return parseResponseData(result,param);

        } catch (Exception e) {
            log.error("请求Api捕获异常,入参:param={},req={},result={}",
                    JSONObject.toJSONString(param), JSONObject.toJSONString(req), JSONObject.toJSONString(result), e);
            return null;
        }

    }

}
