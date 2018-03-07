package com.example.exam4.service;

import com.example.exam4.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * {@link com.example.exam4.Exam4RestController}の対象になるサービス振り分けを行うproxyクラスです。
 *
 * @author HyungCheol Kim
 */
@Component
public class StockServiceProxy {
    /**
     * {@link StockService}を実装したクラスのリスト
     */
    @Autowired
    private List<StockService> services;

    /**
     * 引数の対象になるサービスを検索し、{@link StockService#result(StockInfo)}処理を行います。
     *
     * @param info serviceの情報
     * @return 文字列
     * @throws RuntimeException 対象になる{@link StockService}が存在しない場合
     */
    public String execute(StockInfo info) {
        String result = services.stream()
                .filter(service -> service.isExecutable(info))
                .findAny()
                .orElseThrow(() -> new RuntimeException("対象のServiceが存在しません"))
                .result(info);

        return result;

    }

}
