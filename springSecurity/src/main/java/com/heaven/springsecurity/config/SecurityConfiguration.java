package com.heaven.springsecurity.config;

import com.heaven.springsecurity.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security配置类
 * @author zhanggq
 * @date 2022/8/8 14:10
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        //数据库认证
        auth.userDetailsService(myUserDetailsService);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//开启表单认证
                .loginPage("/toLoginPage")//自定义登录页面
                .loginProcessingUrl("/login")//登录处理url
                .usernameParameter("username")//用户名的name属性
                .passwordParameter("password")//password的name属性
                .successForwardUrl("/")//登录成功跳转路径
                .and()
                .authorizeRequests()
                .antMatchers("/toLoginPage")//放行登录页
                .permitAll()
                .anyRequest()
                .authenticated();//所有请求都需要登录认证才能访问
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.httpBasic()//开启httpBasic验证
////                .and()
////                .authorizeRequests()
////                .anyRequest()
////                .authenticated();//所有请求都需要登录认证才能访问
//        http.formLogin()//开启表单认证
//                .loginPage("/toLoginPage")//自定义登录页面
//                .loginProcessingUrl("/login")//登录处理url
//                .usernameParameter("username")//用户名的name属性
//                .passwordParameter("password")//password的name属性
//                .successForwardUrl("/")//登录成功跳转路径
//                .and()
//                .authorizeRequests()
//                .antMatchers("/toLoginPage")//放行登录页
//                .permitAll()
//                .anyRequest()
//                .authenticated().and().csrf().disable();//所有请求都需要登录认证才能访问
//        return http.build();
//    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return (web) -> web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/favicon.ico");
//    }

//    public AuthenticationManager authenticationManager(){
//
//    }
}
