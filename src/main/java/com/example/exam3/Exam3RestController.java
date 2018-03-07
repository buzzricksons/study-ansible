package com.example.exam3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * example3に対するリクエストのコントローラーです。
 *
 * @author HyungCheol Kim
 */
@org.springframework.web.bind.annotation.RestController
public class Exam3RestController {
    @Autowired
    private CalcService calcService;

    /**
     * {@code /calc}ディレクトリに対する処理を行います。
     *
     * @param session セッション情報
     * @param allRequestParams リクエストパラメータ
     * @return 文字列
     */
    @RequestMapping("/calc")
    public String calc(HttpSession session, @RequestParam Map<String,String> allRequestParams) {
        return calcService.calculate(allRequestParams.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .findFirst()
                .get()
                .replaceAll("\\s+","+"));//URLの+がエスケープ処理されたことを戻す。
    }
}