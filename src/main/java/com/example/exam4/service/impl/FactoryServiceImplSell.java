package com.example.exam4.service.impl;

import com.example.exam4.FactoryInfo;
import com.example.exam4.service.FactoryService;
import com.example.exam4.service.mapper.data.AddFactorykData;
import com.example.exam4.service.mapper.AddFactoryMapper;
import com.example.exam4.service.mapper.data.SellData;
import com.example.exam4.service.mapper.SellMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 課題4の(3) 販売に対する処理を行うクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
public class FactoryServiceImplSell implements FactoryService {
    @Autowired
    private SellMapper sellMapper;
    @Autowired
    private AddFactoryMapper addStockMapper;

    @Override
    public boolean isExecutable(FactoryInfo stockInfo) {
        return stockInfo.getFunction().equals(FactoryInfo.Function.SELL.operation());
    }

    @Transactional
    @Override
    public String result(FactoryInfo stockInfo) {
        BigDecimal price = new BigDecimal(stockInfo.getPrice());
        BigDecimal amount = new BigDecimal(stockInfo.getAmount());
        SellData sellData = SellData.builder()
                .serial(stockInfo.getSerial())
                .name(stockInfo.getName())
                .amount(amount)
                .price(price)
                .sale(price.compareTo(new BigDecimal(0)) < 1 ? new BigDecimal(0) : amount.multiply(price))
                .build();

        AddFactorykData addStockData = AddFactorykData.builder()
                .serial(sellData.getSerial())
                .name(sellData.getName())
                .amount(sellData.getAmount().negate()).build();

        sellMapper.sell(sellData);
        addStockMapper.addStock(addStockData);
        return "";
    }
}
