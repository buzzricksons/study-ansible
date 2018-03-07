package com.example.exam4.service.impl;

import com.example.exam4.Utils;
import com.example.exam4.service.mapper.data.AddFactorykData;
import com.example.exam4.service.mapper.AddFactoryMapper;
import com.example.exam4.FactoryInfo;
import com.example.exam4.service.FactoryService;
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
public class FactoryServiceImplAddStock implements FactoryService {
    @Value("${example.error-message}")
    private String ERROR_MESSAGE;
    @Autowired
    private Utils utils;
    @Autowired
    private AddFactoryMapper mapper;

    @Override
    public boolean isExecutable(FactoryInfo stockInfo) {
        return stockInfo.getFunction().equals(FactoryInfo.Function.ADD_STOCK.operation());
    }

    @Transactional
    @Override
    public String result(FactoryInfo stockInfo) {
        if (!utils.isValidatedNumber(stockInfo.getAmount())) {
            return ERROR_MESSAGE;
        }

        mapper.addStock(AddFactorykData.builder()
                .serial(stockInfo.getSerial())
                .name(stockInfo.getName())
                .amount(new BigDecimal(stockInfo.getAmount())).build());
        return "";
    }
}
