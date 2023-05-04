package com.weather.config;

import com.weather.security.JwtConfigurer;
import com.weather.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] openUrls = {
                "/api/v1/customer/token",
                "/api/v1/customer/register",
                "/v1/swagger/**"
        };
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers(openUrls).permitAll()
                .antMatchers("/api/v1/admin/cities/**").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}