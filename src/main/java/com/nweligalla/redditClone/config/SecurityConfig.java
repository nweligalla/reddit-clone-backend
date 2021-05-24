package com.nweligalla.redditClone.config;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//add security configs to the backend
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //desable all csrf protection to backend and allow all incomming api requests
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("api/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }


}
