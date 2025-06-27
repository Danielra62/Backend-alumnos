package com.fisiunmsm.ayudadoc.alumno.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisiunmsm.ayudadoc.alumno.application.service.AuthService;
import com.fisiunmsm.ayudadoc.alumno.domain.model.Usuario;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-alumno/v1/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Mono<Usuario> login(@RequestBody LoginRequest loginRequest) {
        return authService.autenticarUsuario(
            loginRequest.getUsername(), 
            loginRequest.getPassword()
        );
    }
}

// Clase DTO para la solicitud de login
class LoginRequest {
    private String username;
    private String password;

    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}