/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class sets up the parameter the security in the application is run with.
 * 
 * @author liamkenny
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * Determines users permissions based on their role.
     * @param http
     * @throws Exception 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/users/register").permitAll()
                .antMatchers("/", "/posts/**", "/tags/**", "/users/profile").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/users/admin").access("hasRole('ROLE_ADMIN')")
                .and().formLogin().loginPage("/users/login").permitAll()
                .and().logout().logoutUrl("/app-logout")
                .logoutSuccessUrl("/users/login?logout")
                .and().exceptionHandling().accessDeniedPage("/access_denied");
    }
}
