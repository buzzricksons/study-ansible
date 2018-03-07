package com.example.exam4.service.mapper;

import com.example.exam4.service.mapper.data.SellData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 * 販売のマッパーです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
@Mapper
public interface SellMapper {
    /**
     * 販売データの保存を行います。
     *
     * @param info 販売情報
     */
    @Insert("INSERT INTO SELL (serial, name, amount, price, sale) VALUES (#{serial}, #{name}, #{amount}, #{price}, #{sale})")
    void sell(SellData info);
}
