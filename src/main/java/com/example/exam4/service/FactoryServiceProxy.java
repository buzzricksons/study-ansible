package com.example.exam4.service;

import com.example.exam4.FactoryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * {@link com.example.exam4.Exam4RestController}の対象になるサービス振り分けを行うproxyクラスです。
 *
 * @author HyungCheol Kim
 */
@Component
public class FactoryServiceProxy {
    /**
     * {@link FactoryService}を実装したクラスのリスト
     */
    @Autowired
    private List<FactoryService> services;

    /**
     * 引数の対象になるサービスを検索し、{@link FactoryService#result(FactoryInfo)}処理を行います。
     *
     * @param info serviceの情報
     * @return 文字列
     * @throws RuntimeException 対象になる{@link FactoryService}が存在しない場合
     */
    public String execute(FactoryInfo info) {
        String result = services.stream()
                .filter(service -> service.isExecutable(info))
                .findAny()
                .orElseThrow(() -> new RuntimeException("対象のServiceが存在しません"))
                .result(info);

        return result;

    }

}
