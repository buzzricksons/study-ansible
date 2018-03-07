package com.example.exam4.service.mapper;

import com.example.exam4.service.mapper.data.AddStockData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 在庫追加のマッパーです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
@Mapper
public interface AddStockMapper {
    /**
     * 在庫を追加を行います。
     *
     * @param addStockData 在庫データ
     */
    @Insert("INSERT INTO STOCK (serial, name, amount) VALUES (#{serial}, #{name}, #{amount})")
    void addStock(AddStockData addStockData);
}
