package com.example.exam3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * example3のサービスクラスです。
 *
 * @author HyungCheol Kim
 */
@Component
@Service
public class CalcService {
    @Value("${example.error-message}")
    private String ERROR_MESSAGE;
    /**
     * 引数の四則演算を計算して結果を返します。
     * 計算は{@link SpelExpressionParser}を利用します。
     *
     * @param math 四則演算の文字列
     * @return 正常であれば結果、他の場合は{@link #ERROR_MESSAGE}
     */
    public String calculate(String math) {
        try {
            ExpressionParser parser = new SpelExpressionParser();
            Expression exp = parser.parseExpression(math);
            int result = (Integer) exp.getValue();
            return Integer.toString(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR_MESSAGE;
        }
    }
}
