package com.example.exam4.service.mapper;

import com.example.exam4.StockInfo;
import com.example.exam4.service.mapper.data.CheckStockData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 在庫チェックのマッパーです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
@Mapper
public interface CheckStockMapper {
    /**
     * 全ての在庫情報を取得します。
     *
     * @return 在庫情報のリスト
     */
    @Select("SELECT name, sum(amount) as amount FROM stock GROUP BY name")
    List<CheckStockData> selectAllStock();

    /**
     * 引数に対する在庫情報を取得します。
     *
     * @param info 取得する在庫
     * @return 在庫情報
     */
    @Select("SELECT name, sum(amount) as amount FROM stock WHERE name = #{name} GROUP BY name")
    CheckStockData selectStock(StockInfo info);
}
