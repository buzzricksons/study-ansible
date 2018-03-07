package com.example.exam4;

import com.example.exam4.service.StockServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * example4に対するリクエストのコントローラーです。
 *
 * @author HyungCheol Kim
 */
@org.springframework.web.bind.annotation.RestController
public class Exam4RestController {
    @Autowired
    private StockServiceProxy stockServiceProxy;
    /**
     * {@code /stocker}ディレクトリに対する処理を行います。
     *
     * @param session セッション情報
     * @param stockInfo リクエストのパラメータ
     * @return 文字列
     * @see StockServiceProxy
     */
    @RequestMapping("/stocker")
    public String stocker(HttpSession session, StockInfo stockInfo) {
        return stockServiceProxy.execute(stockInfo);
    }
}