package com.example.exam4.service.impl;

import com.example.exam4.FactoryInfo;
import com.example.exam4.service.FactoryService;
import com.example.exam4.service.mapper.CheckSalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
/**
 * 課題4の(4) 売り上げチェックに対する処理を行うクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
public class FactoryServiceImplCheckSales implements FactoryService {
    @Autowired
    private CheckSalesMapper mapper;

    @Override
    public boolean isExecutable(FactoryInfo stockInfo) {
        return stockInfo.getFunction().equals(FactoryInfo.Function.CHECK_SALES.operation());
    }

    @Transactional
    @Override
    public String result(FactoryInfo stockInfo) {
        return String.format("sales: %s", mapper.salesSum());
    }
}
