package com.wipro.assiessment19.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/check-delivery", "/delivery/status").authenticated() // only allow authenticated users
                .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults()) // enable basic authentication
            .csrf(csrf -> csrf.disable()); // disable CSRF for simplicity
        return http.build();
    }
}
