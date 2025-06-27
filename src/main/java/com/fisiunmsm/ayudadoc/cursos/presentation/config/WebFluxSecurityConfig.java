package com.fisiunmsm.ayudadoc.cursos.presentation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class WebFluxSecurityConfig {
  
@Bean
public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    return http.csrf().disable()
        .authorizeExchange()
            .pathMatchers(
                "/api-alumno/v1/auth/login",  // Permitir login sin autenticación
                "/api-cur/v1/cursos",
                "/api-alumno/v1/auth/registro"         // Permitir acceso público a listado de cursos
            ).permitAll()
            .anyExchange().authenticated()   // Todo lo demás requiere autenticación
        .and()
        .httpBasic()
        .and()
        .build();
}
}
