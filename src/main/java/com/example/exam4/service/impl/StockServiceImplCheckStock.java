package com.example.exam4.service.impl;

import com.example.exam4.StockInfo;
import com.example.exam4.service.StockService;
import com.example.exam4.service.mapper.data.CheckStockData;
import com.example.exam4.service.mapper.CheckStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.stream.Collectors;
/**
 * 課題4の(2) 在庫チェックに対する処理を行うクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
public class StockServiceImplCheckStock implements StockService {
    @Autowired
    private CheckStockMapper mapper;

    @Override
    public boolean isExecutable(StockInfo stockInfo) {
        return stockInfo.getFunction().equals(StockInfo.Function.CHECK_STOCK.operation());
    }

    @Override
    public String result(StockInfo stockInfo) {
            return mapper.selectAllStock()
                    .stream()
                    .sorted(Comparator.comparing(CheckStockData::getName))
                    .filter(info -> info.getAmount().intValue() > 0)
                    .map(info -> String.format("%s: %s", info.getName(), info.getAmount()))
                    .collect(Collectors.joining(System.getProperty("line.separator")));
    }
}
