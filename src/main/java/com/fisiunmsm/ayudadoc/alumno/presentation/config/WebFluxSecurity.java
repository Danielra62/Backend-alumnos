package com.fisiunmsm.ayudadoc.alumno.presentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebFluxSecurity {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .authorizeExchange(exchanges -> exchanges
                        // Endpoints públicos de autenticación
                        .pathMatchers("/api-alumno/v1/auth/login").permitAll()
                        .pathMatchers("/api-alumno/v1/auth/registro").permitAll()
                        // Endpoints que requieren autenticación
                        .pathMatchers("/api-alumno/v1/notas/**").authenticated()
                        // Otros endpoints
                        .pathMatchers("/api-alumno/v1/registro-curso").permitAll()

                        .anyExchange().authenticated()
                )
                .httpBasic()
                .and()
                .build();
    }
}