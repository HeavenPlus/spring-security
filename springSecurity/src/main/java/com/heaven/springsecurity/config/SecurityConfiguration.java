package com.heaven.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security配置类
 * @author zhanggq
 * @date 2022/8/8 14:10
 */
@Configuration
public class SecurityConfiguration {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/favicon.ico");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()//开启表单认证
//                .loginPage("/toLoginPage")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/toLoginPage")
//                .permitAll()
//                .anyRequest()
//                .authenticated();//所有请求都需要登录认证才能访问
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.httpBasic()//开启httpBasic验证
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();//所有请求都需要登录认证才能访问
        http.formLogin()//开启表单认证
                .loginPage("/toLoginPage")
                .and()
                .authorizeRequests()
                .antMatchers("/toLoginPage")
                .permitAll()
                .anyRequest()
                .authenticated();//所有请求都需要登录认证才能访问
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/favicon.ico");
    }
}
