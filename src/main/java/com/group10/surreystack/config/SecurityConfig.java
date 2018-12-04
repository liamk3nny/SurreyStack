/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author liamkenny
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    //@Autowired
    //private UserDetailsService userService;
    
    /*
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }
    */
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("liam").password("abc").roles("USER");
        auth.inMemoryAuthentication().withUser("ignas").password("abc").roles("ADMIN");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/users/register").permitAll()
                .antMatchers("/").access("hasRole('USER')")
                .and().formLogin().loginPage("/users/login").permitAll()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
        
        /*
        http.authorizeRequests()
                .antMatchers("/").access("hasRole('ADMIN')")
                .and().formLogin().loginPage("/users/login").permitAll()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
        */
        /*
        http.authorizeRequests()
                //.antMatchers("/").hasRole("2").anyRequest().authenticated()
                .antMatchers("/", "/posts/**", "/tags/**", "/users/profile").hasRole("ADMIN")
                .antMatchers("/users/register").permitAll()
                .and().formLogin().loginPage("/users/login").permitAll();
                
        /*
        
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/users/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/users/login?logout").permitAll();
        */
    }
}
