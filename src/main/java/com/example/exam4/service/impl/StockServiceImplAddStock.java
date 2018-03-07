package com.example.exam4.service.impl;

import com.example.exam4.Utils;
import com.example.exam4.service.mapper.data.AddStockData;
import com.example.exam4.service.mapper.AddStockMapper;
import com.example.exam4.StockInfo;
import com.example.exam4.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 課題4の(1) 在庫の追加に対する処理を行うクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
public class StockServiceImplAddStock implements StockService {
    @Value("${example.error-message}")
    private String ERROR_MESSAGE;
    @Autowired
    private Utils utils;
    @Autowired
    private AddStockMapper mapper;

    @Override
    public boolean isExecutable(StockInfo stockInfo) {
        return stockInfo.getFunction().equals(StockInfo.Function.ADD_STOCK.operation());
    }

    @Transactional
    @Override
    public String result(StockInfo stockInfo) {
        if (!utils.isValidatedNumber(stockInfo.getAmount())) {
            return ERROR_MESSAGE;
        }

        mapper.addStock(AddStockData.builder()
                .serial(stockInfo.getSerial())
                .name(stockInfo.getName())
                .amount(new BigDecimal(stockInfo.getAmount())).build());
        return "";
    }
}
