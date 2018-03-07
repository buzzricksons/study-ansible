package com.example.exam4.service.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 * 全削除のマッパーです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
@Mapper
public interface DeleteAllMapper {
    /**
     * 全ての在庫情報を削除します。
     */
    @Delete("DELETE FROM stock")
    void deleteAllStockData();

    /**
     * 全ての販売情報を削除します。
     */
    @Delete("DELETE FROM sell")
    void deleteAllSellData();


}
