package com.example.exam4.service;

import com.example.exam4.FactoryInfo;
import org.springframework.stereotype.Service;

/**
 * {@link com.example.exam4.Exam4RestController}に対するサービスを表すインタフェースです。
 *
 * @author HyungCheol Kim
 */
@Service
public interface FactoryService {
    /**
     * 引数のstockInfoに対するサービスかを判断します。
     * @param stockInfo
     * @return
     */
    boolean isExecutable(FactoryInfo stockInfo);

    /**
     * 引数のstockInfoから処理を行い、結果を返します。
     * @param stockInfo
     * @return 文字列
     */
    String result(FactoryInfo stockInfo);
}
