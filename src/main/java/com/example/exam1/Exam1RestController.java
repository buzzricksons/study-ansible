package com.example.exam1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * example1に対するリクエストのコントローラーです。
 * application.ymlにて設定したvalueを返します。
 *
 * @author HyungCheol Kim
 */
@org.springframework.web.bind.annotation.RestController
public class Exam1RestController {
    @Value("${example1.return-value}")
    private String value;

    /**
     * {@code /}ディレクトリに対する処理を行います。
     * 戻り値はresources/application.ymlのexample1.return-valueに設定されている値を返します。
     *
     * @param session セッション情報
     * @return 文字列
     */
    @RequestMapping("/")
    public String home(HttpSession session) {
        return value;
    }
}