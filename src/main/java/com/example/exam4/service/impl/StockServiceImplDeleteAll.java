package com.example.exam4.service.impl;

import com.example.exam4.StockInfo;
import com.example.exam4.service.StockService;
import com.example.exam4.service.mapper.DeleteAllMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * 課題4の(5) 全削除に対する処理を行うクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
public class StockServiceImplDeleteAll implements StockService {
    @Autowired
    private DeleteAllMapper mapper;

    @Override
    public boolean isExecutable(StockInfo stockInfo) {
        return stockInfo.getFunction().equals(StockInfo.Function.DELETE_ALL.operation());
    }

    @Transactional
    @Override
    public String result(StockInfo stockInfo) {
        mapper.deleteAllStockData();
        mapper.deleteAllSellData();
        return "";
    }
}
