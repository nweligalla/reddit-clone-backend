package com.nweligalla.redditClone.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//add security configs to the backend
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //disable all csrf protection to backend and allow all incoming api requests
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();

//        .authorizeRequests()
//                .antMatchers("api/auth/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();

    }

    // Encrypt password

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
