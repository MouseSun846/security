package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author MouseSun
 * @Date 2020/7/9 20:50
 * @Address 杭州电子科技大学
 */
@Configuration
@EnableWebSecurity //启用 Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true) //会拦截注解@PreAuthorize验证权限
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 通过复写configure方法 ，进行创建用户
     */
/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        */

    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行bootstrap下面的所有静态资源，不需要验证
        web.ignoring().antMatchers("/bootstrap/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/bootstrap/sign-in/index.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/hello") //重定向--会记录重定向地址
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")  //注销接口
                .logoutSuccessUrl("/bootstrap/sign-in/index.html") //注销后跳转登录页
                .permitAll()
                .and()
                .csrf().disable();
    }

    /**
         *基于内存的方式，构建连个用户账号： mouse/sun sun/mouse
         *//*
        auth.inMemoryAuthentication().
                withUser("mouse").password("sun").roles("admin");
        auth.inMemoryAuthentication().
                withUser("sun").password("mouse").roles("normal");

    }*/



    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
