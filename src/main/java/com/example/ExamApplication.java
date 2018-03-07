package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * アプリケーションのメインクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@ComponentScan(basePackages = {"com"})
@SpringBootApplication
public class ExamApplication extends SpringBootServletInitializer {

    /**
     * buildの成果物をwarにし、Tomcatにて起動させるためOverrideします。
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExamApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }
}