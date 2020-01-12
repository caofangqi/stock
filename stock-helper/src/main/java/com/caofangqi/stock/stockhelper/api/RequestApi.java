package com.caofangqi.stock.stockhelper.api;

/**
 * @author caofangqi created at 2020/1/11 5:57 下午
 */
public interface RequestApi <T,R,P> {

    /**
     * 执行请求 Api
     */
    T execute(P param);
    /**
     * 请求 Api
     */
    String request(R req);

    /**
     * 解析返回数据
     */
    T parseResponseData(String result,P param);
    /**
     * 包装请求数据
     */
    R wrapRequestData(P param);


}
