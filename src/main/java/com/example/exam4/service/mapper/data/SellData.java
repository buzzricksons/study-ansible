package com.example.exam4.service.mapper.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
/**
 * {@link com.example.exam4.service.mapper.SellMapper}で利用するデータクラスです。
 *
 * @author HyungCheol Kim
 */
@Setter
@Getter
@Builder
public class SellData {
    private final String serial;
    private final String name;
    private final BigDecimal amount;
    private final BigDecimal price;
    private final BigDecimal sale;
}
