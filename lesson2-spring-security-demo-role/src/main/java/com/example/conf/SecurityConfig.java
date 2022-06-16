package com.example.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user")
                .password("user")
                .roles("ADMIN")
                .and()
                .withUser("normal")
                .password("normal")
                .roles("NORMAL");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/demo/echo").permitAll()
                //hasRole() 直接传参 ADMIN,USER，会自动插入前缀 ROLE_
                .antMatchers("/demo/admin").hasRole("ADMIN")
                //access() 中 "hasRole()" 等需要使用带 'ROLE_' 前缀的单词
                .antMatchers("/demo/normal").access("hasAnyRole('ROLE_ADMIN','ROLE_NORMAL')")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }
}
