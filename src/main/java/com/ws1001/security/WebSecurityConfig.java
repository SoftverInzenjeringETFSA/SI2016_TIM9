package com.ws1001.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


import com.ws1001.security.JWTLoginFilter;
import com.ws1001.security.JWTAuthenticationFilter;
import com.ws1001.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers(HttpMethod.POST, "/login").permitAll()  
        .anyRequest().authenticated()
        .and()
        // filtrirajmo sve zahtjeve za login sa nasim filterom JWTLoginFilter
        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
        // sve ostale zahtjeve filtriramo sa nasim filterom JWTAuthenticationFilter
        .addFilterBefore(new JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
  }

    //CORS problemi - potrebno je dozvoliti da OPTIONS zahtjevi koje browser salje
    //stignu do servera
   @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // za testiranje
    auth.userDetailsService(customUserDetailsService);
  }
}