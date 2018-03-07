package com.example.exam4;

import lombok.Setter;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * {@link Exam4RestController#factory(HttpSession, FactoryInfo)}で利用されるリクエストパラメータを格納するクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Setter
public class FactoryInfo {
    private String function;
    private String name;
    private String amount;
    private String price;
    private final String serial = UUID.randomUUID().toString();

    public FactoryInfo(){
    }

    public String getFunction() {
        return function;
    }
    public String getName() {
        return name;
    }

    /**
     * 在庫数を返します。設定されてない場合は1を返します。
     *
     * @return 在庫数
     */
    public String getAmount() {
        return amount != null ? amount : "1";
    }

    /**
     * 価格を返します。設定されてない場合は0を返します。
     *
     * @return 価格
     */
    public String getPrice() {
        return price != null ? price : "0";
    }

    /**
     * 各オペレーションの特定できるユニークなキーを返します。
     *
     * @return
     */
    public String getSerial() {
        return serial;
    }

    /**
     * RESTによって行われるオペレーションのenumです。
     */
    public enum Function {
        ADD_STOCK("addstock"),
        CHECK_STOCK("checkstock"),
        SELL("sell"),
        CHECK_SALES("checksales"),
        DELETE_ALL("deleteall")
        ;

        private String operation;

        private Function(String operation) {
            this.operation = operation;
        }

        /**
         * オペレーションを表す文字列を返します。
         *
         * @return　文字列
         */
        public String operation() {
            return operation;
        }
    }
}
