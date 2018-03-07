package com.example.exam4;

import org.springframework.stereotype.Component;

/**
 * Utilityクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Component
public class Utils {
    /**
     * 引数の文字列が整数かを判断します。
     *
     * @param num 文字列
     * @return 引数が整数であれば {@code true}、整数でなければ{@code false}
     */
    public boolean isValidatedNumber (String num) {
        return num.matches("\\d+");
    }
}
