package com.caofangqi.stock.stockhelper.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caofangqi.stock.stockhelper.entity.Stock;
import com.caofangqi.stock.stockhelper.mapper.StockMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author caofangqi created at 2020/3/2 10:43 PM
 */
@Component
public class StockManager {
    @Resource
    private StockMapper stockMapper;

    /**
     * 获取需要刷新信息的股票
     * @return list
     */
    public List<Stock> getRequireRefreshInfoStock(){
        QueryWrapper<Stock> stockQueryWrapper = new QueryWrapper<>();
        stockQueryWrapper.eq("flag",1);

        return  stockMapper.selectList(stockQueryWrapper);
    }

}
