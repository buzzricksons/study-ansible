package com.example.exam2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 課題2に対するBasic認証情報を表すクラスです。
 *
 * @author HyungCheol Kim
 *
 */
@Configuration
@EnableWebSecurity
public class Exam2SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Value("${example2.id}")
    private String id;
    @Value("${example2.pw}")
    private String pw;

    /**
     * Basic認証で使われるidとパスワードを設定します。
     * 設定値はresources/application.ymlのexample2.idとexample2.pwです。
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(id)
                .password(pw)
                .roles("USER");
    }

    /**
     * Basic認証するend pointを設定します。
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private", "/private/*").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

        http.headers().frameOptions().disable();
    }
}