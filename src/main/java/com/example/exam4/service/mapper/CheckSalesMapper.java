package com.example.exam4.service.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
/**
 * 売上チェックのマッパーです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
@Mapper
public interface CheckSalesMapper {
    /**
     * 売上チェックを行います。
     *
     * @return 売上金額
     */
    @Select("SELECT sum(sale) as sale FROM sell")
    String salesSum();
}
