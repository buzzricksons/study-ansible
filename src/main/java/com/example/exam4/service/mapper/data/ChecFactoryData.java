package com.example.exam4.service.mapper.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
/**
 * {@link com.example.exam4.service.mapper.CheckFactoryMapper}で利用するデータクラスです。
 *
 * @author HyungCheol Kim
 */
@Setter
@Getter
@Builder
public class ChecFactoryData {
    private final String name;
    private final BigDecimal amount;
}
