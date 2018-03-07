package com.example.exam4.service.impl;

import com.example.exam4.FactoryInfo;
import com.example.exam4.service.FactoryService;
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
public class FactoryServiceImplDeleteAll implements FactoryService {
    @Autowired
    private DeleteAllMapper mapper;

    @Override
    public boolean isExecutable(FactoryInfo stockInfo) {
        return stockInfo.getFunction().equals(FactoryInfo.Function.DELETE_ALL.operation());
    }

    @Transactional
    @Override
    public String result(FactoryInfo stockInfo) {
        mapper.deleteAllStockData();
        mapper.deleteAllSellData();
        return "";
    }
}
