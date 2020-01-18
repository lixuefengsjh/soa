package com.lxf.controller.security.config;

import com.lxf.controller.security.handler.ImoocAuthenctiationFailureHandler;
import com.lxf.controller.security.handler.ImoocAuthenticationSuccessHandler;
import com.lxf.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 深度学习security:
     * 1.认证（账号密码认证，三方认证，短信认证，指纹认证，人脸认证等等）
     * 2.授权
     * 3.攻击防护
     */
    @Autowired
    private UserManagerService userDetailsService;
    @Autowired
    private ImoocAuthenctiationFailureHandler imoocAuthenctiationFailureHandler;
    @Autowired
    private ImoocAuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 初学配置
         */
//        http.
//                formLogin().and().authorizeRequests().anyRequest().authenticated();
        http
                .formLogin().successHandler(imoocAuthenticationSuccessHandler).failureHandler(imoocAuthenctiationFailureHandler).and()
                .authorizeRequests()
                .antMatchers("/static/index.html").permitAll()
                .antMatchers("/product/**").hasRole("User1")
                .antMatchers("/admin/**").hasRole("User2")
                .anyRequest().authenticated()
                .and();
        /**
         * 注意，这里添以后无妨将验证的信息存入session还是会报错
         */
//                .httpBasic()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("{noop}admin").roles("ADMIN", "USER") // 管理员，同事具有 ADMIN,USER权限，可以访问所有资源
//                .and()
//                .withUser("user").password("{noop}user").roles("USER"); // 普通用户，只能访问 /product/**
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
