package com.example.exam4.service.impl;

import com.example.exam4.FactoryInfo;
import com.example.exam4.service.FactoryService;
import com.example.exam4.service.mapper.data.ChecFactoryData;
import com.example.exam4.service.mapper.CheckFactoryMapper;
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
public class FactoryServiceImplCheckStock implements FactoryService {
    @Autowired
    private CheckFactoryMapper mapper;

    @Override
    public boolean isExecutable(FactoryInfo stockInfo) {
        return stockInfo.getFunction().equals(FactoryInfo.Function.CHECK_STOCK.operation());
    }

    @Override
    public String result(FactoryInfo stockInfo) {
            return mapper.selectAllStock()
                    .stream()
                    .sorted(Comparator.comparing(ChecFactoryData::getName))
                    .filter(info -> info.getAmount().intValue() > 0)
                    .map(info -> String.format("%s: %s", info.getName(), info.getAmount()))
                    .collect(Collectors.joining(System.getProperty("line.separator")));
    }
}
